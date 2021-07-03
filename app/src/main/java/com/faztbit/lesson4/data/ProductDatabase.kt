package com.faztbit.lesson4.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.faztbit.lesson4.data.dao.ProductsDao
import com.faztbit.lesson4.models.Products

private const val NAME_DATABASE = "Lesson4.db"

@Database(entities = [Products::class], version = 3)
abstract class ProductDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: ProductDatabase? = null
        fun getDataBaseInstance(context: Context): ProductDatabase {
            return INSTANCE ?: synchronized(ProductDatabase::class.java) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, ProductDatabase::class.java,
                    NAME_DATABASE
                )
//                    .addMigrations(MIGRATION_1_2)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE PRODUCTS ADD COLUMN Igv REAL")
            }

        }

        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE PRODUCTS ADD COLUMN Igv REAL")
            }

        }
    }


    abstract fun productDao(): ProductsDao
}