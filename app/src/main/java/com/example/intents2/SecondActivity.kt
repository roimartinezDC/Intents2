package com.example.intents2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val txtVnum1 = findViewById<TextView>(R.id.textView2_1)
        val txtVnum2 = findViewById<TextView>(R.id.textView2_2)
        val txtResult = findViewById<EditText>(R.id.editTextResult)

        //recojo los números enviados en el intent
        val num1 = intent.getIntExtra("num1", 0)
        val num2 = intent.getIntExtra("num2", 0)

        txtVnum1.text = num1.toString()
        txtVnum2.text = num2.toString()

        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        btnEnviar.setOnClickListener {
            intent.putExtra("suma", txtResult.text)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}