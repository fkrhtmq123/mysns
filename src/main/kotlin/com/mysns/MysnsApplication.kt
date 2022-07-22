package com.mysns

import com.mysns.property.BlogProperty
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperty::class)
class MysnsApplication

fun main(args: Array<String>) {
	runApplication<MysnsApplication>(*args)
}
