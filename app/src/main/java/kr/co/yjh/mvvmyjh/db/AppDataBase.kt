package kr.co.yjh.mvvmyjh.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kr.co.yjh.mvvmyjh.model.InputMsg

/**
 * DB Scheme
 * @author 윤준혁
 * @date 2020/03/12
 */
@Database(entities = [InputMsg::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun inputMsgDao(): InputMsgDao

    companion object {
        private const val DB_NAME = "mvvm-yjh"

        private var instance: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDataBase {
            return Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    DB_NAME
                )
                .fallbackToDestructiveMigration()
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                })
                .build()
        }
    }
}