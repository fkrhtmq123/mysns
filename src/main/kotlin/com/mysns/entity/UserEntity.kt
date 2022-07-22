package com.mysns.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class UserEntity(
  var login: String,
  var username: String,
  @Id @GeneratedValue var id: Long? = null
)