package com.agh.projectdatabase1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class phone(
    @PrimaryKey var ph: String,
    var name: String,
    var jen: String)
