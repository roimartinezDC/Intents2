package com.example.intents2

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private val REQ_IMG_CAP = 1
    private val REQ_NUM = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.imageView)

        if (requestCode == REQ_IMG_CAP && data != null) {
            val imageBitMap = data.extras!!.get("data") as Bitmap
            imageView.setImageBitmap(imageBitMap)
        }

    }
}