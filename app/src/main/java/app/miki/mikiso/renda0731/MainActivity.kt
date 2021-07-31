package app.miki.mikiso.renda0731

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //タップを数える変数を準備する
        var tapCount = 0

        //レイアウトのtap_buttonをtapButtonという名前で使えるようにする
        val tapButton : Button = findViewById(R.id.tap_button)
        //レイアウトのcount_textをcountTextという名前で使えるようにする
        val countText : TextView = findViewById(R.id.count_text)


        //ボタンがタップされたときに
        tapButton.setOnClickListener{
            //タップを数える変数にプラス1をする
            tapCount = tapCount + 1
            //タップされた数をテキストビューに反映する
            countText.text = tapCount.toString()
        }
    }
}