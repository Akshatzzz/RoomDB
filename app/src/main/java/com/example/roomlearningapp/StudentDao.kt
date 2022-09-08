package com.example.roomlearningapp

import androidx.room.*

@Dao
interface StudentDao {
    @Query("SELECT * FROM Student_Details")
    fun getAll(): List<Student>

    @Query("SELECT * FROM Student_Details WHERE roll_no LIKE :roll LIMIT 1")
    suspend fun findByRoll(roll:Int): Student

    @Insert(onConflict=OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("DELETE FROM student_details")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM student_details where roll_no LIKE :roll")
    suspend fun cnt(roll:Int):Int
}