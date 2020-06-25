package com.retobcp.core.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

@Entity
class ExchangeEntity (
    @PrimaryKey
    @SerialName("id")
    val id: String,

    @ColumnInfo(name = "countryName")
    val countryName: String?,

    @ColumnInfo(name = "countryISO")
    val countryISO: String?,

    @ColumnInfo(name = "exchangeCurrency")
    val exchangeCurrency: String?,

    @ColumnInfo(name = "description")
    val description: String?
)