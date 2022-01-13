package br.com.cwi.yugioh_app.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.cwi.yugioh_app.data.database.dao.CardDao
import br.com.cwi.yugioh_app.data.database.entity.CardEntity

const val DATABASE_VERSION = 2

@Database(entities = [CardEntity::class], version = DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCardDao(): CardDao

    companion object {
        private const val DATABASE_NAME = "yugioh-db"
        fun create(application: Application): AppDatabase {
            return Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                DATABASE_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}