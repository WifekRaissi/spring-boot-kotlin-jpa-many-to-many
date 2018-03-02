package com.spring.springkotlinmysql.entities


import javax.persistence.*

@Entity
@Table
data class User(
    @Id @GeneratedValue
    val id:Long=-1,
    val firstname: String="",
    val lastname:String="",

    @ManyToMany(cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "user_book",
            joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "book_id", referencedColumnName = "id")))
    var books: List<Book> = mutableListOf<Book>()

    ){
    override fun toString(): String{
        return "{User: ${this.firstname}, Books: ${books.map { it->it.title }}}";
    }
}