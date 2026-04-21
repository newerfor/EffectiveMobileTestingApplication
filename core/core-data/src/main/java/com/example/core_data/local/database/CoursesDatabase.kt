package com.example.core_data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_data.constant.DataBaseConstant.DATABASE_VERSION
import com.example.core_data.local.dao.CoursesDao
import com.example.core_data.local.model.CoursesEntity
import com.example.core_data.local.model.UserEntity

@Database(
    entities = [CoursesEntity::class, UserEntity::class],
    version = DATABASE_VERSION
)
abstract class CoursesDatabase : RoomDatabase() {
    abstract fun coursesDao(): CoursesDao
}