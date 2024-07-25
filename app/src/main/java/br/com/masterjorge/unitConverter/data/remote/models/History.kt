package br.com.masterjorge.unitConverter.data.remote.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class History(
    val unit1: String,
    val unit2: String,
    val value: Float,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
