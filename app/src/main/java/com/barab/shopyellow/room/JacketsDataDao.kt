package com.barab.shopyellow.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Insert
import androidx.room.Query

@Dao
interface JacketsDataDao {

    @Query("select * from JacketsData")
    fun getAll(): LiveData<List<JacketsData>>

    @Query("select * from JacketsData where id = :jacketsId")
    suspend fun getById(jacketsId: Int): JacketsData

    @Insert(onConflict = REPLACE)
    suspend fun insert(entity: JacketsData)

}