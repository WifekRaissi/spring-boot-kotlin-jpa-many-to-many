package com.spring.springkotlinmysql.repositories


import com.spring.springkotlinmysql.entities.Book
import com.spring.springkotlinmysql.entities.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: CrudRepository<Book, Long> {
    fun findBookByTitle(title: String): MutableList<Book>
}

