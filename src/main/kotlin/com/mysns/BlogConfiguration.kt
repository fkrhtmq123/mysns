package com.mysns

import com.mysns.entity.ArticleEntity
import com.mysns.entity.UserEntity
import com.mysns.repository.ArticleRepository
import com.mysns.repository.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

  @Bean
  fun databaseInitializer(userRepository: UserRepository,
                          articleRepository: ArticleRepository) = ApplicationRunner {

    val kimdongwook = userRepository.save(UserEntity("kimdongwook", "kim"))
    articleRepository.save(ArticleEntity(
      title = "Reactor Bismuth is out",
      content = "dolor sit amet",
      author = kimdongwook
    ))
    articleRepository.save(ArticleEntity(
      title = "Reactor Aluminium has landed",
      content = "dolor sit amet",
      author = kimdongwook
    ))
  }
}
