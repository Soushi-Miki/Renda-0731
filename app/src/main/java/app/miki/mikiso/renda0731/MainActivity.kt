package app.miki.mikiso.renda0731

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //タップを数える変数を準備する
        var tapCount = 0
        //残り秒数を10秒にする
        var second = 10


        //レイアウトのtap_buttonをtapButtonという名前で使えるようにする
        val tapButton : Button = findViewById(R.id.tap_button)
        //レイアウトのcount_textをcountTextという名前で使えるようにする
        val countText : TextView = findViewById(R.id.count_text)
        val secondText : TextView = findViewById(R.id.second_text)
        val startButton : Button  = findViewById(R.id.start_button)


        //タイマーを設定する
        val timer : CountDownTimer = object : CountDownTimer (10000,1000){
            override fun onFinish() {
                //スタートボタンを見える状態にする
                startButton.isVisible = true
                //TAPボタンを灰色に設定する
                tapButton.backgroundTintList = ContextCompat.getColorStateList(this@MainActivity,R.color.gray)
                //残り秒数を0秒に戻す
                second = 10
                //タップを数える変数を0秒に戻す
                tapCount = 0

            }

            override fun onTick(millisUntilFinished: Long) {
                //TAPボタンをピンク色に設定
                tapButton.backgroundTintList = ContextCompat.getColorStateList(this@MainActivity,R.color.pink)
                //残り秒数にマイナス1する
                second = second - 1
                //残り数字をテキストビューに反映する
                secondText.text = second.toString()
            }

        }
        //スタートボタンがタップされたときに
        startButton.setOnClickListener{
            //タップされた数をテキストビューに反映する
            countText.text = tapCount.toString()
            //スタートボタンを見えない状態にする
            startButton.isVisible = false
            //タイマーを開始する
            timer.start()
        }
        //ボタンがタップされたときに
        tapButton.setOnClickListener{
            if ( second < 10){
                //タップを数える変数にプラス1をする
                tapCount = tapCount + 1
                //タップされた数をテキストビューに反映する
                countText.text = tapCount.toString()

            }

        }
    }
}