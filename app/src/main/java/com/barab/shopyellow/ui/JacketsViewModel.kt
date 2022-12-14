package com.barab.shopyellow.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.barab.shopyellow.JacketsRepository
import com.barab.shopyellow.room.DbConnection
import com.barab.shopyellow.room.JacketsData
import kotlinx.coroutines.launch

class JacketsViewModel(application: Application): AndroidViewModel(application) {
    private var jackets: LiveData<List<JacketsData>>? = null
    var selectedJackets: MutableLiveData<JacketsData> = MutableLiveData()

    private val repository: JacketsRepository
        init {
            val dao = Room.databaseBuilder(application.applicationContext, DbConnection::class.java, "db")
                .build()
                .entityDao()
            repository = JacketsRepository(dao)
        }

    fun getAll(): LiveData<List<JacketsData>>?{
        if(jackets == null){
            jackets = repository.getAll()
        }
        return jackets
    }

    fun insert(jacketsData: JacketsData){

        viewModelScope.launch {
            repository.insert(jacketsData)
        }
    }

    fun getById(Id: Int){
        viewModelScope.launch {
            val jackets = repository.getById(Id)
            selectedJackets.value = jackets
        }
    }
}