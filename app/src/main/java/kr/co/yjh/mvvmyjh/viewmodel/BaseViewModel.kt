package kr.co.yjh.mvvmyjh.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * Main ViewModel
 * @author 윤준혁
 * @date 2020/03/12
 */
abstract class BaseViewModel: ViewModel() {
    private val viewModelJob = Job()
    val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)
}