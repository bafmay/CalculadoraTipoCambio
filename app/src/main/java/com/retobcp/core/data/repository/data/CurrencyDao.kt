package com.retobcp.core.data.repository.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.retobcp.core.data.entity.CurrencyEntity

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM currencyentity")
    fun getAll(): List<CurrencyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(options: List<CurrencyEntity>)

    @Query("DELETE FROM currencyentity")
    fun deleteAll()

}