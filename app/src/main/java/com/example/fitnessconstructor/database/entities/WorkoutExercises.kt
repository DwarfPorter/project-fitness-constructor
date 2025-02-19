package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "workout_exercises",
    foreignKeys = [
        ForeignKey(
            entity = WorkoutEntity::class,
            parentColumns = ["id"],
            childColumns = ["workout_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = AllExercisesEntity::class,
            parentColumns = ["id"],
            childColumns = ["exercise_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class WorkoutExercises(
    @PrimaryKey(autoGenerate = true)//Идентификатор будет генерироваться первая колонка автоматически
    val id: Int = 0,

    @ColumnInfo(name = "workout_id") // номер программы из списка программ тренировок
    val workoutId: Int,

    @ColumnInfo(name = "day") // какой день тренировки. Всего 3 дня тренировки в неделю
    val day: String,

    @ColumnInfo(name = "exercise_id") // номер упражнения из списка упражнений
    val exerciseId: Int,

    @ColumnInfo(name = "count") // количество , секунды или до отказа (-1)
    val count: Int,
)
