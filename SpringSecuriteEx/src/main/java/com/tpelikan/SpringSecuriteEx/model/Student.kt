package com.tpelikan.SpringSecuriteEx.model

class Student {
    var id: Int = 0
    var name: String? = null
    var marks: Int = 0

    constructor()

    constructor(id: Int, name: String?, marks: Int) : super() {
        this.id = id
        this.name = name
        this.marks = marks
    }
}
