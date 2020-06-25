package com.retobcp.core.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

@Entity
class CurrencyEntity(
    @PrimaryKey
    @SerialName("id")
    val id: String,

    @ColumnInfo(name = "originCurrency")
    val originCurrency: String?,

    @ColumnInfo(name = "destCurrency")
    val destCurrency: String?,

    @ColumnInfo(name = "exchangeCurrencyValue")
    val exchangeCurrency: Double?,

    @ColumnInfo(name = "inchangeCurrencyValue")
    val inchangeCurrency: Double?
)