package com.example.fitnessconstructor.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.fitnessconstructor.domain.entities.Rest

@Entity(
    tableName = "workout_rest",
    foreignKeys = [
        ForeignKey(
            entity = WorkoutEntity::class,
            parentColumns = ["id"],
            childColumns = ["workout_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class WorkoutRestEntity(
    @PrimaryKey(autoGenerate = true)//Идентификатор будет генерироваться первая колонка автоматически
    val id: Int = 0,

    @ColumnInfo(name = "workout_id") // номер программы из списка программ тренировок
    val workoutId: Int?,     //здесь всегда будет 1

    @ColumnInfo(name = "appr_rest") // время отдыха между подходами в упражнении
    val apprRest: Int,

    @ColumnInfo(name = "exercise_rest")// время отдыха между упражнениями
    val exerciseRest: Int
) {

    fun toListRest(): List<Rest> {
        return listOf(
            Rest(id = this.id, count = apprRest),
            Rest(id = this.id, count = exerciseRest)
        )
    }
}