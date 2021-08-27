package com.example.pictures


import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ColorSpace.get
import android.media.CamcorderProfile.get
import android.nfc.tech.Ndef.get
import android.nfc.tech.NdefFormatable.get
import android.nfc.tech.NfcA.get
import android.nfc.tech.NfcB.get
import android.nfc.tech.NfcBarcode.get
import android.nfc.tech.NfcF.get
import android.nfc.tech.NfcV.get
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.ProfileSyncState.get
import android.provider.ContactsContract.SyncState.get
import android.provider.SyncStateContract.Helpers.get
import android.text.AutoText.get
import android.text.Editable
import android.text.TextWatcher
import android.view.ViewConfiguration.get
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionBarPolicy.get
import androidx.appcompat.widget.AppCompatDrawableManager.get
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.lang.Exception
import java.lang.reflect.Array.get
import java.net.HttpURLConnection
import java.net.URL
import java.nio.file.Paths.get
import kotlin.coroutines.EmptyCoroutineContext.get


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
                try {
                    Picasso.with(this@MainActivity).load(p0.toString()).into(imageView)
                }
                catch (e:Exception){
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                }

                editText.addTextChangedListener(this)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}