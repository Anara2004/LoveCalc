package com.example.lovecalc.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.lovecalc.data.models.LoveModel

interface Dao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_model ORDER by firstName ASC")
    fun getAll(): LiveData<List<LoveModel>>

}