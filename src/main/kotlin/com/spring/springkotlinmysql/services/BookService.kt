package com.spring.springkotlinmysql.services

import com.spring.springkotlinmysql.entities.Book


interface BookService{


    fun updateBook(id: Long, book: Book): Book
    fun deleteAllBooks()
    fun deleteBook(id: Long)
    fun addBook(book: Book): Book
    fun getBookByTitle(title: String): MutableList<Book>
    fun getBookById(id: Long): Book?
    fun getBooks(): MutableIterable<Book>?
}