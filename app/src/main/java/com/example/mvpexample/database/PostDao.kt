package com.example.mvpexample.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post : PostRoom)

    @Query("SELECT * FROM PostRoom")
    fun getPosts(): Single<List<PostRoom>>

    @Query("DELETE FROM PostRoom")
    suspend fun delete()
}