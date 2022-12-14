package com.barab.shopyellow.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class JacketsData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var price: Double,
    var description: String,
    var favorite: Boolean
)
