package com.ryandf.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private lateinit var result: TextView
//
//    private lateinit var newNumber: EditText
//
//    private val displayOperation by lazy(LazyThreadSafetyMode.NONE) {findViewById<EditText>(R.id.operation)}

    //Variables to hold the operands and type of calculation
    private var operand1: Double? = null
    private var operand2: Double = 0.0
    private var pendingOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        result = findViewById(R.id.result)
//        newNumber = findViewById(R.id.newNumber)
//        newNumber.setInputType(InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_SIGNED or InputType.TYPE_NUMBER_FLAG_DECIMAL)
//
//        //Input buttons

//        Use kotlinx import to access all activity widgets
//
//        val button0: Button = findViewById(R.id.button0)
//        val button1: Button = findViewById(R.id.button1)
//        val button2: Button = findViewById(R.id.button2)
//        val button3: Button = findViewById(R.id.button3)
//        val button4: Button = findViewById(R.id.button4)
//        val button5: Button = findViewById(R.id.button5)
//        val button6: Button = findViewById(R.id.button6)
//        val button7: Button = findViewById(R.id.button7)
//        val button8: Button = findViewById(R.id.button8)
//        val button9: Button = findViewById(R.id.button9)
//
//        val buttonDot: Button = findViewById(R.id.buttonDot)
//        val buttonPlus: Button = findViewById(R.id.buttonPlus)
//        val buttonMinus: Button = findViewById(R.id.buttonSubtraction)
//        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
//        val buttonDivide: Button = findViewById(R.id.buttonDivide)
//        val buttonEquals: Button = findViewById(R.id.buttonEquals)

        val listener = View.OnClickListener { viewObject ->
            val b = viewObject as Button
            newNumber.append(b.text)
        }



        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)

        buttonPlus.setOnClickListener(listener)
        buttonSubtraction.setOnClickListener(listener)
        buttonMultiply.setOnClickListener(listener)
        buttonDivide.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)
        buttonEquals.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            val op = (v as Button).text.toString()

            try {
                val value = newNumber.text.toString().toDouble()
                performOperation(value,op)
            }
            catch(e: NumberFormatException) {
                newNumber.setText("")
            }

            pendingOperation = op
            operation.setText(pendingOperation)
        }

        buttonEquals.setOnClickListener(opListener)
        buttonPlus.setOnClickListener(opListener)
        buttonSubtraction.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
    }

    private fun performOperation(value: Double, operation: String) {
        if (operand1 == null) {
            operand1 = value
        } else {
            operand2 = value

            if (pendingOperation == "=") {
                pendingOperation = operation
            }

            when (pendingOperation) { // Is equal to...
                "=" -> operand1 = operand2
                "/" -> if (operand2 == 0.0) {
                    operand1 = Double.NaN   // handle attempt to divide by zero
                } else {
                    operand1 = operand1!! / operand2
                }
                "*" -> operand1 = operand1!! * operand2
                "-" -> operand1 = operand1!! - operand2
                "+" -> operand1 = operand1!! + operand2
            }
        }
        result.text = this.operand1.toString()
        newNumber.setText("")
    }


}
