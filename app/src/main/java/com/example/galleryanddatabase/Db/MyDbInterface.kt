package com.example.galleryanddatabase.Db

import com.example.galleryanddatabase.models.MyImage

interface MyDbInterface {
    fun addImage(myImage: MyImage)
    fun getAllImage(): ArrayList<MyImage>
}