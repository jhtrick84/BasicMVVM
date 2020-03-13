package kr.co.yjh.mvvmyjh

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.yjh.mvvmyjh.db.AppDataBase
import kr.co.yjh.mvvmyjh.factory.MainViewModelFactory
import kr.co.yjh.mvvmyjh.model.InputMsg
import kr.co.yjh.mvvmyjh.repo.InputMsgRepository
import kr.co.yjh.mvvmyjh.util.LogUtil
import kr.co.yjh.mvvmyjh.viewmodel.MainViewModel

/**
 * MainActivity는 View의 역할만 수행
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribeUI()
    }

    // UI Subscribe Setting
    private fun subscribeUI() {
        val dao = AppDataBase.getInstance(this).inputMsgDao()
        val repository = InputMsgRepository.getInstance(dao)    // Repository에 DAO 세팅
        val factory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        // viewModel의 inputMsgs에 변화가 생길 때마다 동작
        viewModel.inputMsgs.observe(this, Observer {
            LogUtil.e("MainActivity - Observe $it")
            if (it == null || it.isEmpty())
                return@Observer

            val sb = StringBuffer()
            for (data in it) {
                sb.append(data.msg).append("\n")
            }

            tvResult.text = sb.toString()   // TextView Setting
        })

        btnInput.setOnClickListener {
            val input = etInput.text.toString()
            LogUtil.e("MainActivity - OnClick : $input")
            if (input.isEmpty())
                return@setOnClickListener

            etInput.setText("") // 입력창은 초기
            viewModel.insertMsg(InputMsg(msg = input))  // viewModel에 msg 전달
        }
    }
}
