package com.retobcp.core.data.repository.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.retobcp.core.data.entity.ExchangeEntity
import com.retobcp.core.data.entity.ExchangeJoinned

@Dao
interface ExchangeDao {

    @Query("SELECT * FROM exchangeentity")
    fun getAll(): List<ExchangeEntity>

    @Query("SELECT exchangeentity.id,exchangeentity.countryName,exchangeentity.countryISO,currencyentity.exchangeCurrencyValue,currencyentity.inchangeCurrencyValue,exchangeentity.exchangeCurrency,exchangeentity.description FROM exchangeentity INNER JOIN currencyentity ON exchangeentity.exchangeCurrency = currencyentity.destCurrency  WHERE currencyEntity.originCurrency LIKE '%' || :currency || '%' AND currencyEntity.destCurrency NOT LIKE '%' || :currency2 || '%'")
    fun getExchangesList(currency: String,currency2: String): List<ExchangeJoinned>

    @Query("SELECT exchangeentity.id,exchangeentity.countryName,exchangeentity.countryISO,currencyentity.exchangeCurrencyValue,currencyentity.inchangeCurrencyValue,exchangeentity.exchangeCurrency,exchangeentity.description FROM exchangeentity INNER JOIN currencyentity ON exchangeentity.exchangeCurrency = currencyentity.originCurrency  WHERE currencyEntity.originCurrency LIKE '%' || :currency || '%' AND currencyEntity.destCurrency LIKE '%' || :currency2 || '%' ")
    fun getExchange(currency: String,currency2: String): List<ExchangeJoinned>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(options: List<ExchangeEntity>)

    @Query("DELETE FROM exchangeentity")
    fun deleteAll()

}