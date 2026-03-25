package fr.mastersid.stackoverflow.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Transformation de la dataClass Question en une structure de table avec @Entity
@Entity(tableName = "question_table")
data class Question(@PrimaryKey val id: Int, val title: String, val body: String, val answerCount: Int)

//Autre facon
//@Entity(tableName = "question_table", primaryKeys = ["id"])
//data class Question(val id: int, val title: String, val body: String, val answerCount: Int)