package com.example.intents2

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val REQ_IMG_CAP = 1
    private val REQ_NUM = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFoto = findViewById<Button>(R.id.button1)
        btnFoto.setOnClickListener {
            //se genera un Intent que abre la cámara del teléfono
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, REQ_IMG_CAP)
        }

        val btnNum = findViewById<Button>(R.id.button2)
        btnNum.setOnClickListener {
            //se salta a la SecondActivity
            val intent = Intent(this, SecondActivity::class.java)
            val random = kotlin.random.Random
            //se dan los valores de los números por parámetros Extra del Intent
            intent.putExtra("num1", random.nextInt(1,100))
            intent.putExtra("num2", random.nextInt(1,100))
            startActivityForResult(intent, REQ_NUM)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.imageView)

        // si el código es el que envía el botón1, se coge la foto y se pone en el imageView
        if (requestCode == REQ_IMG_CAP && data != null) {
            val imageBitMap = data.extras!!.get("data") as Bitmap
            imageView.setImageBitmap(imageBitMap)
        }

        if (resultCode != Activity.RESULT_OK || data == null) return

        //si el código es el que envía el boton2, se recoge el valor que puso el usuario y se comprueba
        if (requestCode == REQ_NUM) {
            val textView = findViewById<TextView>(R.id.textView)

            val num1 = data.getIntExtra("num1", 0)
            val num2 = data.getIntExtra("num2", 0)
            val suma = num1 + num2
            val res = data.getIntExtra("suma", 0)

            //comprobación de la suma manual
            if (suma == res) {
                textView.text = "SUMA CORRECTA"
            } else {
                textView.text = "SUMA INCORRECTA"
            }
        }

    }
}