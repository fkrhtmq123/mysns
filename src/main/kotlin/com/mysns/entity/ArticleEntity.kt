package com.mysns.entity

import com.mysns.extension.toSlug
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class ArticleEntity(
  var title: String,
  var content: String,
  @ManyToOne var author: UserEntity,
  var slug: String = title.toSlug(),
  var addedAt: LocalDateTime = LocalDateTime.now(),
  @Id @GeneratedValue var id: Long? = null
)