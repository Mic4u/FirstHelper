package ib.firsthelper.activities.steps

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ib.firsthelper.R
import ib.firsthelper.Utilities.Path
import ib.firsthelper.activities.MainActivity
import java.lang.Thread.sleep


class HeartStepActivity : AppCompatActivity() {

    private lateinit var mPlayer2: MediaPlayer

    var next=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heart_step)

        val path = Path(resources.getString(R.string.path))

        val bundle = intent.extras
        val stepId = bundle!!.getInt("stepId")
        val step=path.path[stepId]

        val txtDesciption = findViewById<TextView>(R.id.txtDescription)
        val txtTitle = findViewById<TextView>(R.id.txtTitle)

        val title = step.title
        val description = step.description



        txtDesciption.text = description
        txtTitle.text=title


    }

    override fun onStart() {
        super.onStart()

        startTimeCounter()
    }

    private fun startTimeCounter() {

        val pushDur=550L;
        val pushesAmount=30;

        var pushesDone=0

        val txtCounter = findViewById<TextView>(R.id.txtCounter)

        val soundPool = SoundPool(5, AudioManager.STREAM_MUSIC, 0)
        val soundId = soundPool.load(this, R.raw.beep, 1)



        object : CountDownTimer(pushDur * (pushesAmount), pushDur) {

            override fun onTick(millisUntilFinished: Long) {
                if(!next){

                        txtCounter.text = "$pushesDone/$pushesAmount"
                        soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                        pushesDone++

                }else{
                    cancel()
                }
            }
            override fun onFinish() {
                soundPool.play(soundId, 1f, 1f, 0, 0, 1f)
                txtCounter.text = "$pushesAmount/$pushesAmount"
            }
        }.start()
    }

    fun onHeartBtnClick(view: View) {
        next=true;

        val path = Path(resources.getString(R.string.path))

        val bundle = intent.extras
        val stepId = bundle!!.getInt("stepId")

        val step=path.path[stepId]

        val type=path.path[step.nextStepA].stepType

        var intent=Intent(this, MainActivity::class.java)


        when (type) {                                                                               //when, for determining which kind of step will be next
            "Simple" -> intent = Intent(this, SimpleStepActivity::class.java)
            "Choice" -> intent = Intent(this, ChoiceStepActivity::class.java)
            "Heart" -> intent = Intent(this, HeartStepActivity::class.java)
            "Finish" -> intent = Intent(this, FinishStepActivity::class.java)
            else -> {
                print("ERROR IN ACCESING NEXT STEP")
            }
        }

        intent.putExtra("stepId", step.nextStepA)
        startActivity(intent)

    }

    fun replay(view: View) {

        val path = Path(resources.getString(R.string.path))

        val bundle = intent.extras
        val stepId = bundle!!.getInt("stepId")



        val step=path.path[stepId]
        mPlayer2.stop()
        mPlayer2 = MediaPlayer.create(
            this, resources.getIdentifier(
                step.audioName,
                "raw",
                packageName
            )
        )
        mPlayer2.start()

    }
}