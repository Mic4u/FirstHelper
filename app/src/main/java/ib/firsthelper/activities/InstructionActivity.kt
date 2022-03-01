package ib.firsthelper.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ib.firsthelper.R

class InstructionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instruction)

        val txtInstruction = findViewById<TextView>(R.id.txtInstruction)

        val instruction = resources.getString(R.string.placeholder_text)

        txtInstruction.text = instruction

    }
}