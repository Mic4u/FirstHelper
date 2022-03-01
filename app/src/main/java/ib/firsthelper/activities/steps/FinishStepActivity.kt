package ib.firsthelper.activities.steps

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ib.firsthelper.R
import ib.firsthelper.activities.MainActivity

class FinishStepActivity : AppCompatActivity() {

    private lateinit var mPlayer2: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_step)

    }

    fun onFinishBtnClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}