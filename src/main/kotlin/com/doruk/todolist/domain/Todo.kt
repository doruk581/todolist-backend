package com.doruk.todolist.domain

import javax.persistence.*

@Entity
@Table(name = "TODO")
@SequenceGenerator(name = "seq_todo", sequenceName = "seq_todo")
data class Todo(
        @Column(name = "TODO_NAME", nullable = false)
        var todo: String) {

    constructor() : this("")

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_todo")
    var id: Long = 0
}
