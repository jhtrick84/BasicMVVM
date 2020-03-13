package kr.co.yjh.mvvmyjh.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kr.co.yjh.mvvmyjh.db.InputMsgDao
import kr.co.yjh.mvvmyjh.model.InputMsg

/**
 * Repository
 * @author 윤준혁
 * @date 2020/03/12
 */
class InputMsgRepository private constructor(private val inputMsgDao: InputMsgDao) {
    fun getAllMsg() = inputMsgDao.getAll()  // select *

    /**
     * DB에 메시지 입력
     * suspend는 coroutines이 언제든 지연되었다가 재개될 수 있도록 해준다.
     */
    suspend fun insert(inputMsg: InputMsg) {
        withContext(Dispatchers.IO) {
            inputMsgDao.insertMsg(inputMsg)
        }
    }

    companion object {
        @Volatile
        private var instance: InputMsgRepository? = null

        fun getInstance(inputMsgDao: InputMsgDao) =
            instance?: synchronized(this) { // instance가 null이 아니라면 instance를 반환하고, 아니면 synchronized 수행
                // null 체크 한번 더 하고, InputMsgRepository 객체 생성 -> instance에 세
                instance?: InputMsgRepository(inputMsgDao).also { instance = it }
            }
    }
}