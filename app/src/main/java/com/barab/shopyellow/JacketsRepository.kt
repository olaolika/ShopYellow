package com.barab.shopyellow

import com.barab.shopyellow.room.JacketsData
import com.barab.shopyellow.room.JacketsDataDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JacketsRepository(private val dao: JacketsDataDao) {
    private val list = dao.getAll()

    fun getAll() = list

    suspend fun insert(vararg jackets: JacketsData){
        withContext(Dispatchers.IO){
            jackets.forEach {
                dao.insert(it)
            }
        }
    }

    suspend fun getById(id: Int): JacketsData{
        return withContext(Dispatchers.IO){
            return@withContext dao.getById(id)
        }
    }
}
