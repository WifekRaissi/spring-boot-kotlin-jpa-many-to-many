package com.spring.springkotlinmysql.controllers


import com.spring.springkotlinmysql.entities.Book

import com.spring.springkotlinmysql.services.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/book")
class BookController {

    @Autowired
    lateinit var bookrService: BookService

    @GetMapping("/books")
    fun getAllUsers() =
            bookrService.getBooks()

    @GetMapping(value = "/{id}")
    fun getBookById(@PathVariable("id") id: Long) = bookrService.getBookById(id)

    @GetMapping(value = "/books/{title}")
    fun getBookByTitle(@PathVariable("title") title: String) =
            bookrService.getBookByTitle(title)

    @PostMapping("/books")
    fun createBook(@Valid @RequestBody user: Book) =
            bookrService.addBook(user)

    @DeleteMapping("/books/{id}")
    fun deleteBookById(@PathVariable id: Long) =
            bookrService.deleteBook(id)

    @DeleteMapping("/books")
    fun deleteBooks() =
            bookrService.deleteAllBooks()

    @PutMapping("/books/{id}")
    fun updateBook(@PathVariable ("id")id:Long, @RequestBody book: Book)=
            bookrService.updateBook(id,book)




}



