package ib.firsthelper.activities.steps

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import ib.firsthelper.R
import ib.firsthelper.activities.MainActivity
import ib.firsthelper.Utilities.Path

class ChoiceStepActivity : AppCompatActivity() {

    private lateinit var mPlayer2: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice_step)

        val path = Path(resources.getString(R.string.path))

        val bundle = intent.extras
        val stepId = bundle!!.getInt("stepId")
        val step=path.path[stepId]

        val txtDesciption = findViewById<TextView>(R.id.txtDescription)
        val txtTitle = findViewById<TextView>(R.id.txtTitle)

        val image=findViewById<ImageView>(R.id.imageView4)
        val uri = "@drawable/"+step.imageName
        val imageResource = resources.getIdentifier(uri, null, packageName)
        val res = resources.getDrawable(imageResource)
        image.setImageDrawable(res)

        mPlayer2 = MediaPlayer.create(this, resources.getIdentifier(step.audioName,"raw", packageName))
        mPlayer2.start()

        val title = step.title
        val description = step.description

        txtDesciption.text = description
        txtTitle.text=title
    }


    fun doA() {

        mPlayer2.stop()

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
    fun doB() {

        mPlayer2.stop()

        val path = Path(resources.getString(R.string.path))

        val bundle = intent.extras
        val stepId = bundle!!.getInt("stepId")

        val step=path.path[stepId]

        val type=path.path[step.nextStepB].stepType

        var intent=Intent(this, MainActivity::class.java)


        when (type) {                                                                               //when, for determining which kind of step will be next
            "Simple" -> intent = Intent(this, SimpleStepActivity::class.java)
            "Choice" -> intent = Intent(this, ChoiceStepActivity::class.java)
            "Heart" -> intent = Intent(this, HeartStepActivity::class.java)
            "Finish" -> intent = Intent(this, FinishStepActivity::class.java)
            else -> { // Note the block
                print("ERROR IN ACCESING NEXT STEP")
            }
        }

        intent.putExtra("stepId", step.nextStepB)
        startActivity(intent)
    }

    fun onABtnClick(view: View) { doA() }

    fun onBBtnClick(view: View) { doB() }

    fun onFakeAClick(view: View) { doA() }
    fun onFakeBClick(view: View) { doB() }

    fun replay(view: View) {
        val path = Path(resources.getString(R.string.path))

        val bundle = intent.extras
        val stepId = bundle!!.getInt("stepId")

        val step=path.path[stepId]
        mPlayer2.stop()
        mPlayer2 = MediaPlayer.create(this, resources.getIdentifier(step.audioName,"raw", packageName))
        mPlayer2.start()

    }
}