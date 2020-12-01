package com.example.mvpexample.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PostRoom (
    @PrimaryKey
    var id: Int? = null,

    @ColumnInfo
    var userId: Int? = null,

    @ColumnInfo
    var title: String? = null,

    @ColumnInfo
    var body: String? = null

)
