package kr.co.yjh.mvvmyjh.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kr.co.yjh.mvvmyjh.model.InputMsg

/**
 * Database DAO
 * @author 윤준혁
 * @date 2020/03/12
 */
@Dao
interface InputMsgDao {
    @Query("select * from inputMsg")
    fun getAll(): LiveData<List<InputMsg>>

    @Insert
    fun insertMsg(inputMsg: InputMsg)
}