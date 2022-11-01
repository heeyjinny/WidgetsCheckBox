package com.heeyjinny.widgetscheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import com.heeyjinny.widgetscheckbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //뷰바인딩
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰바인딩
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        //xml체크박스 id에 연결
        //setOnCheckedChangeListener 사용
        //첫 번째 파라미터 : 상태변화가 있는 체크박스 위젯
        //두 번째 파라미터 : 체크여부, Boolean타입으로 전달 / 기존에 b였으나 알아보기 쉽게 isChecked 로 변경

        //코드1
//        binding.checkApple.setOnCheckedChangeListener { compoundButton, isChecked ->
//
//            if (isChecked){
//                Log.d("CheckBox","사과가 선택되었습니다")
//            }else{
//                Log.d("CheckBox","사과가 해제되었습니다")
//            }
//
//        }

        //코드2
        //코드1처럼 작성하면 모든 체크박스에 리스너를 달아줘야 하므로 코드량이 늘어나게 됨
        //하나의 코드블록에서 처리하기 위해 listener프로퍼티 작성하여
        //setOnCheckedChangeListener 메서드 초기화

        //첫 번째 파라미터 : 상태변화가 있는 체크박스 위젯
        //두 번째 파라미터 : 체크여부, Boolean타입으로 전달 / 기존에 b였으나 알아보기 쉽게 isChecked 로 변경
        val listener by lazy {
            CompoundButton.OnCheckedChangeListener { compoundButton, isChecked ->

                //만약 체크되었다면
                if (isChecked){

                    //체크박스 위젯의 아이디가 일치할 때 이벤트 실행
                    when(compoundButton.id){
                        R.id.checkApple -> Log.d("CheckBox","사과가 선택되었습니다")
                        R.id.checkBanana -> Log.d("CheckBox","사과가 선택되었습니다")
                        R.id.checkOrange -> Log.d("CheckBox","사과가 선택되었습니다")
                    }

                //체크되지 않았다면
                }else{

                    //체크박스 위젯의 아이디가 일치할 때 이벤트 실행
                    when(compoundButton.id){
                        R.id.checkApple -> Log.d("CheckBox","사과가 선택 해제되었습니다")
                        R.id.checkBanana -> Log.d("CheckBox","사과가 선택 해제되었습니다")
                        R.id.checkOrange -> Log.d("CheckBox","사과가 선택 해제되었습니다")
                    }

                }

            }
        }//listener

        //listener프로퍼티 사용
        binding.checkApple.setOnCheckedChangeListener(listener)
        binding.checkBanana.setOnCheckedChangeListener(listener)
        binding.checkOrange.setOnCheckedChangeListener(listener)

    }//onCreate
}//class MainActivity