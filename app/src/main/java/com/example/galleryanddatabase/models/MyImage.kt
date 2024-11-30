package com.example.galleryanddatabase.models

class MyImage {
    var id: Int? = null
    var imageLink: String? = null
    var name: String? = null

    constructor(imageLink: String, name: String) {
        this.imageLink = imageLink
        this.name = name
    }
    constructor(id: Int, imageLink: String, name: String) {
        this.id = id
        this.imageLink = imageLink
        this.name = name
    }
    constructor()

    override fun toString(): String {
        return "MyImage(id=$id, imageLink=$imageLink, name=$name)"
    }
}