package com.retobcp.core.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.retobcp.core.data.db.AppDatabase.Companion.DB_VERSION
import com.retobcp.core.data.entity.CurrencyEntity
import com.retobcp.core.data.entity.ExchangeEntity
import com.retobcp.core.data.repository.data.CurrencyDao
import com.retobcp.core.data.repository.data.ExchangeDao


@Database(
    entities = [ExchangeEntity::class, CurrencyEntity::class],
    version = DB_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exchangeDao(): ExchangeDao
    abstract fun currencyDao(): CurrencyDao

    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "retoBCP.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                .build()


    }

}