package kr.co.yjh.mvvmyjh.viewmodel

import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import kr.co.yjh.mvvmyjh.model.InputMsg
import kr.co.yjh.mvvmyjh.repo.InputMsgRepository
import kr.co.yjh.mvvmyjh.util.LogUtil

/**
 * Main ViewModel : Repository로부터 데이터를 저장, 로드한다
 * @author 윤준혁
 * @date 2020/03/12
 */
class MainViewModel(private val inputMsgRepository: InputMsgRepository): BaseViewModel() {
    // Repository로부터 저장된 msg들
    var inputMsgs: LiveData<List<InputMsg>> = inputMsgRepository.getAllMsg()

    /**
     * msg를 repository에 저장
     */
    fun insertMsg(inputMsg: InputMsg) {
        LogUtil.e("MainViewModel - insertMsg : $inputMsg")
        viewModelScope.launch { inputMsgRepository.insert(inputMsg) }
    }
}