package com.wbd.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var numero: Double = 0.0
    lateinit var tvNum: TextView
    lateinit var tvSave: TextView
    var op: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNum = findViewById(R.id.tvNum)
        tvSave = findViewById(R.id.tvSave)

        val btnSymResult: Button = findViewById(R.id.btnSymResult)
        val btnClear: Button = findViewById(R.id.btnClear)

        btnSymResult.setOnClickListener {
            var numero2: Double = tvNum.text.toString().toDouble()
            var res = 0.0

            when (op) {
                1 -> res = numero + numero2
                2 -> res = numero - numero2
                3 -> res = numero * numero2
                4 -> res = numero / numero2
            }

            tvNum.setText(res.toString())
            tvSave.setText("")
        }

        btnClear.setOnClickListener {
            tvSave.setText("")
            tvNum.setText("")
            numero = 0.0
            op = 0
        }
    }

    fun pressDigit(view: View) {
        var num: String = tvNum.text.toString()

        when (view.id) {
            R.id.btnNum0 -> tvNum.setText(num + "0")
            R.id.btnNum1 -> tvNum.setText(num + "1")
            R.id.btnNum2 -> tvNum.setText(num + "2")
            R.id.btnNum3 -> tvNum.setText(num + "3")
            R.id.btnNum4 -> tvNum.setText(num + "4")
            R.id.btnNum5 -> tvNum.setText(num + "5")
            R.id.btnNum6 -> tvNum.setText(num + "6")
            R.id.btnNum7 -> tvNum.setText(num + "7")
            R.id.btnNum8 -> tvNum.setText(num + "8")
            R.id.btnNum9 -> tvNum.setText(num + "9")
            R.id.btnSymDot -> tvNum.setText(num + ".")
        }
    }

    fun clickOperation(view: View) {
        numero = tvNum.text.toString().toDouble()
        var numero2: String = tvNum.text.toString()
        tvNum.setText("")

        when (view.id) {
            R.id.btnSymAdd -> {
                tvSave.setText(numero2 + "+")
                op = 1
            }
            R.id.btnSymSubt -> {
                tvSave.setText(numero2 + "-")
                op = 2
            }
            R.id.btnSymMult -> {
                tvSave.setText(numero2 + "×")
                op = 3
            }
            R.id.btnSymDiv -> {
                tvSave.setText(numero2 + "÷")
                op = 4
            }
        }
    }
}