package com.example.galleryanddatabase.Db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.galleryanddatabase.models.MyImage

class MyDbHelper(context: Context) : SQLiteOpenHelper(context, "gallery", null, 1),
    MyDbInterface {
    override fun onCreate(p0: SQLiteDatabase?) {
        val query =
            "create table image_table(id integer primary key autoincrement unique not null,image_link text not null,name text not null)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun addImage(myImage: MyImage) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("image_link", myImage.imageLink)
        contentValues.put("name", myImage.name)
        database.insert("image_table", null, contentValues)
        database.close()
    }

    override fun getAllImage(): ArrayList<MyImage> {
        val list = ArrayList<MyImage>()
        val database = this.readableDatabase
        val cursor = database.rawQuery("select * from image_table", null)
        if (cursor.moveToFirst()) {
            do {
                list.add(
                    MyImage(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                    )
                )

            } while (cursor.moveToNext())
        }
        return list
    }
}