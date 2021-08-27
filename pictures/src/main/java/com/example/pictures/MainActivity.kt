package com.example.pictures


import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception


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

                val res = resources.getIdentifier(
                    p0.toString(), "drawable", "com.example.pictures")

                try {
                    if (res == 0)
                        throw Exception("There is no such file")
                    imageView.setImageResource(res)
                }
                catch (e:Exception){
                    Toast.makeText(this@MainActivity, e.message,Toast.LENGTH_SHORT).show()
                }

                editText.addTextChangedListener(this)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}