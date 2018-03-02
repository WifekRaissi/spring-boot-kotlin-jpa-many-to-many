package com.spring.springkotlinmysql.services

import com.spring.springkotlinmysql.entities.Book
import com.spring.springkotlinmysql.entities.User
import com.spring.springkotlinmysql.repositories.BookRepository
import com.spring.springkotlinmysql.repositories.UserRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service



@Service
class BookServiceImpl: BookService {

    private val log = KotlinLogging.logger {}
    @Autowired
    lateinit var repository: BookRepository

    override fun getBooks() =
            repository.findAll()

    override fun getBookById(id: Long) =
            repository.findOne(id)


    override fun getBookByTitle(title: String) =
            repository.findBookByTitle(title)


    override fun addBook(book: Book): Book {
        repository.save(book)
        log.info("${book.title},added!!!")
        return book


    }

    override fun deleteBook(id: Long) {
        repository.delete(id)
        log.info("Book deleted!!")
    }

    override fun deleteAllBooks() {
        repository.deleteAll()
        log.info("All Books deleted!!")
    }



    override fun updateBook(id: Long, book: Book):Book {
        val currentBook = repository.findOne(id)
        if (currentBook != null) repository.save(currentBook.copy(id,book.title))
        log.info("${book.title},updated!!!")
        return currentBook

    }



}

