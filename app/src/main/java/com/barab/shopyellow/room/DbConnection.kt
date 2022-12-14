package com.barab.shopyellow.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [JacketsData::class], version = 1)
abstract class DbConnection : RoomDatabase(){
    abstract fun entityDao(): JacketsDataDao
}