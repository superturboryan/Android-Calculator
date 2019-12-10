package com.ryandf.calculator

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var result: EditText

    private lateinit var newNumber: EditText

    private val displayOperation by lazy(LazyThreadSafetyMode.NONE) {findViewById<TextView>(R.id.operation)}

    //Variables to hold the operands and type of calculation
    private var operand1: Double = null
    private var operand2: Double = 0.0
    private var pendingOperation = "="



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         result = findViewById(R.id.re)
    }


}
