package com.example.emailintent

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.connect_to_email_button)
        button.setOnClickListener {
            writeEmail()
        }
    }
    private fun writeEmail() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("arta.zidele@gmail.com")) // recipients
            putExtra(Intent.EXTRA_SUBJECT, "Email subject")
            putExtra(Intent.EXTRA_TEXT, "Email message text")
//            putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"))
            // You can also attach multiple items by passing an ArrayList of Uris
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Log.d("Email sending error: ", e.localizedMessage)
        }
    }
}