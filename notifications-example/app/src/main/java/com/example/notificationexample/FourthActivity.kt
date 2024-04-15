package com.example.notificationexample

import android.app.RemoteInput
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FourthActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        textView = findViewById(R.id.textVeiw)

        receiveInput()

    }


    private fun receiveInput() {
        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if (remoteInput != null) {

            val input = remoteInput.getCharSequence(MainActivity.replyKey).toString()

            textView.text = input

        } else {

        }
    }
}