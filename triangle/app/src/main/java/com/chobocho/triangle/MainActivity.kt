package com.chobocho.triangle

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.inputmethod.InputMethodManager
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
    fun init() {
        val cornerA = findViewById<EditText>(R.id.triCornerA)
        val cornerB = findViewById<EditText>(R.id.triCornerB)
        val cornerC = findViewById<TextView>(R.id.triCornerC)
        val angleA = findViewById<TextView>(R.id.triAngleA)
        val angleB = findViewById<TextView>(R.id.triAngleB)
        val area = findViewById<TextView>(R.id.area)

        val btnClear = findViewById<Button>(R.id.clear)
        val stringUtil = StringUtil()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        btnClear.setOnClickListener() {
            cornerA.setText("")
            cornerB.setText("")
            cornerC.setText("")
            cornerC.setHint("C")
            angleA.setText("")
            angleB.setText("")
        }

        val btnAnswer = findViewById<Button>(R.id.answer)

        btnAnswer.setOnClickListener {
            val triA = cornerA.getText()
            val triB = cornerB.getText()

            imm.hideSoftInputFromWindow(cornerA.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(cornerB.getWindowToken(), 0);

            if (TextUtils.isEmpty(triA) || TextUtils.isEmpty(triB) ) {
                Toast.makeText(this, R.string.input_a_and_b, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val nTriA = triA.toString().toDouble()
            val nTriB = triB.toString().toDouble()

            if(nTriA <= 0 || nTriB <= 0) {
                Toast.makeText(this, R.string.input_a_and_b, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Log.d(LOG_TAG, "Tri A: " + triA + " Tri B: " + triB)

            val nTriC = Math.sqrt( nTriA * nTriA + nTriB*nTriB)
            val strTriC =  stringUtil.removeZero(String.format("%.3f", nTriC))

            cornerC.setText(strTriC)

            val nAngleA = Math.toDegrees(Math.atan(nTriB /nTriA))
            val strAngleA = stringUtil.removeZero(String.format("%.3f", nAngleA))
            angleA.setText(strAngleA)

            val nAngleB = 90 - nAngleA
            val strAngleB = stringUtil.removeZero(String.format("%.3f", nAngleB))
            angleB.setText(strAngleB)

            val nRound = nTriA + nTriB + nTriC
            val strRound = stringUtil.removeZero(String.format("%.3f", nRound))
            val nArea = (nTriA * nTriB)/2
            val strArea = stringUtil.removeZero(String.format("%.3f", nArea))
            val strResult = getText(R.string.round).toString() + strRound + "\n" + getText(R.string.area).toString() + strArea
            area.setText(strResult)
        }
    }
}