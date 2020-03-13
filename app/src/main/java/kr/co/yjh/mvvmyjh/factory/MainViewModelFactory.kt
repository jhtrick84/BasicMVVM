package kr.co.yjh.mvvmyjh.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.co.yjh.mvvmyjh.repo.InputMsgRepository
import kr.co.yjh.mvvmyjh.viewmodel.MainViewModel

/**
 *
 * @author 윤준혁
 * @date 2020/03/12
 */
class MainViewModelFactory (private val inputMsgRepository: InputMsgRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(inputMsgRepository) as T
    }
}