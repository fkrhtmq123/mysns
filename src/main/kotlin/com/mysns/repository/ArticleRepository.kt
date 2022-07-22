package com.mysns.repository

import com.mysns.entity.ArticleEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : CrudRepository<ArticleEntity, Long> {
  fun findBySlug(slug: String): ArticleEntity?
  fun findAllByOrderByAddedAtDesc(): Iterable<ArticleEntity>
}