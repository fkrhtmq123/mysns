package com.mysns.controller

import com.mysns.entity.ArticleEntity
import com.mysns.entity.UserEntity
import com.mysns.extension.format
import com.mysns.property.BlogProperty
import com.mysns.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException

@Controller
class HtmlController(private val repository: ArticleRepository, private val property: BlogProperty) {

  @GetMapping("/")
  fun blog(model: Model): String {
    model["title"] = property.title
    model["banner"] = property.banner
    model["articles"] = repository.findAllByOrderByAddedAtDesc().map { it.render() }
    return "blog"
  }

  @GetMapping("/article/{slug}")
  fun article(@PathVariable slug: String, model: Model):String {
    val article = repository
      .findBySlug(slug)
      ?.render()
      ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")
    model["title"] = article.title
    model["article"] = article
    return "article"
  }

  fun ArticleEntity.render() = RenderedArticle(
    slug,
    title,
    content,
    author,
    addedAt.format()
  )

  data class RenderedArticle(
    val slug: String,
    val title: String,
    val content: String,
    val author: UserEntity,
    val addedAt: String
  )
}