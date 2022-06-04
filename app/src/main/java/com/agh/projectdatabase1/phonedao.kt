package com.agh.projectdatabase1

import androidx.room.*

@Dao
interface phonedao {

    @Insert
    fun insertAll(vararg phone: phone)

    @Delete
    fun delete(phone: phone)

    @Update
    fun updateTodo(vararg phone: phone)

    @Query("SELECT * FROM phone")
    fun getAll(): List<phone>

    @Query("SELECT * FROM phone WHERE ph LIKE :ph")
    fun findByTitle(ph: String): phone

}