package com.spring.springkotlinmysql.entities

import javax.persistence.*


@Entity
@Table
data class Book(
        @Id @GeneratedValue
        val id:Long=-1,
        val title: String="",

        @ManyToMany(mappedBy = "books")
var users: List<User> = mutableListOf<User>()
){
        override fun toString(): String{
                return "{Book: ${this.title}, Users: ${users.map { it->it.firstname }}}";
        }
}
