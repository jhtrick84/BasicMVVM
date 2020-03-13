package kr.co.yjh.mvvmyjh.util

import android.util.Log

/**
 * LogUtil
 * @author 윤준혁
 * @date 2020/03/13
 */
class LogUtil {
    companion object {
        private const val TAG = "yjh_test"
        fun e(msg: String?) {
            Log.e(TAG, msg)
        }
    }
}