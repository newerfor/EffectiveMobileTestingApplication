package com.example.core_data.local.database

import android.content.Context
import androidx.room.Room
import com.example.core_data.constant.DataBaseConstant.DATABASE_NAME

object DataBaseProvider {
    private var instance: CoursesDatabase? = null
    fun getDatabase(context: Context): CoursesDatabase {
        return instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(
                context.applicationContext,
                CoursesDatabase::class.java,
                DATABASE_NAME
            ).fallbackToDestructiveMigration().build().also { instance = it }
        }
    }
}