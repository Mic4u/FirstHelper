package ib.firsthelper.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ib.firsthelper.R
import ib.firsthelper.Utilities.Path
import ib.firsthelper.activities.steps.ChoiceStepActivity
import ib.firsthelper.activities.steps.FinishStepActivity
import ib.firsthelper.activities.steps.HeartStepActivity
import ib.firsthelper.activities.steps.SimpleStepActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resource=resources.getString(R.string.path)
        val path = Path(resource)
        Log.e("ib.log", resource)

    }

    fun onStartBtnClick(view: View) {
        val resource=resources.getString(R.string.path)
        val path = Path(resource)

        val type=path.path[0].stepType

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

        intent.putExtra("stepId", 0)
        startActivity(intent)

    }
    fun onInstructionBtnClick(view: View) {

        val intent = Intent(this, InstructionActivity::class.java)
        startActivity(intent)

    }
}