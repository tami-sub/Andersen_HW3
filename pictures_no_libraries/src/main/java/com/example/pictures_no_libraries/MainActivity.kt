package com.example.pictures_no_libraries

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.StrictMode
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.net.URL


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                
                editText.removeTextChangedListener(this)

                val policy = StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                try {
                    val url = URL("https://picsum.photos/id/237/200/300")
                    val image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                    imageView.setImageBitmap(image)
                } catch(e: IOException) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                } catch(e: Exception) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                }

                editText.addTextChangedListener(this)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }


}