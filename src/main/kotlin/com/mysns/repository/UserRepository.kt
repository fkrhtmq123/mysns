package com.mysns.repository

import com.mysns.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {
  fun findByLogin(login: String): UserEntity?
}