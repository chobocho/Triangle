package com.chobocho.triangle

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

   val LOG_TAG = "Triangle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    @SuppressLint("SetTextI18n")
    fun init() {
        val cornerA = findViewById<EditText>(R.id.triCornerA)
        val cornerB = findViewById<EditText>(R.id.triCornerB)
        val cornerC = findViewById<TextView>(R.id.triCornerC)
        val btnClear = findViewById<Button>(R.id.clear)
        val stringUtil = StringUtil()

        btnClear.setOnClickListener() {
            cornerA.setText("")
            cornerB.setText("")
            cornerC.setText("")
            cornerC.setHint("C")
        }

        val btnAnswer = findViewById<Button>(R.id.answer)

        btnAnswer.setOnClickListener {
               val triA = cornerA.getText()
               val triB = cornerB.getText()

               if (TextUtils.isEmpty(triA) || TextUtils.isEmpty(triB) ) {
                   Toast.makeText(this, "Please input A and B!", Toast.LENGTH_SHORT).show()
               }
               Log.d(LOG_TAG, "Tri A: " + triA + " Tri B: " + triB)

               val nTriA = triA.toString().toDouble()
               val nTriB = triB.toString().toDouble()
               val triC = Math.sqrt( nTriA * nTriA + nTriB*nTriB)
               val strTriC =  stringUtil.removeZero(String.format("%.3f", triC))

               cornerC.setText(strTriC)
        }
    }
}


