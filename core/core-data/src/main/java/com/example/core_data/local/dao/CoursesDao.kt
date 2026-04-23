package com.example.core_data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_data.constant.DataBaseConstant.USER_ID
import com.example.core_data.local.model.CoursesEntity
import com.example.core_data.local.model.UserEntity

@Dao
interface CoursesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCourse(course: CoursesEntity)
    @Query("""
        UPDATE courses SET 
            title = :title,
            text = :text,
            price = :price,
            rate = :rate,
            startDate = :startDate,
            publishDate = :publishDate
        WHERE id = :id
    """)
    suspend fun updateCourseExceptLike(
        id: Int,
        title: String,
        text: String,
        price: String,
        rate: String,
        startDate: String,
        publishDate: String
    )

    @Query("SELECT * FROM courses LIMIT :pageSet OFFSET :offset")
    suspend fun getAllCourses(offset: Int, pageSet: Int): List<CoursesEntity>

    @Query("SELECT * FROM courses WHERE hasLike = :hasLike LIMIT :pageSet OFFSET :offset")
    suspend fun getCoursesByLike( offset: Int,pageSet: Int,hasLike: Boolean=true, ): List<CoursesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: UserEntity)

    @Query("SELECT * FROM user WHERE id = :userId")
    suspend fun getUser(userId: Int=USER_ID): UserEntity
    @Query("SELECT * FROM courses WHERE id = :id")
    suspend fun getCourseById(id:Int): CoursesEntity?
}