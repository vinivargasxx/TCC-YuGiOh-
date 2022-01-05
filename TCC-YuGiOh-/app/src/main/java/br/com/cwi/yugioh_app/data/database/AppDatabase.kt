package br.com.cwi.yugioh_app.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.cwi.yugioh_app.data.database.dao.CardDao
import br.com.cwi.yugioh_app.data.database.entity.CardEntity

@Database(entities = [CardEntity::class], version = 1)
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