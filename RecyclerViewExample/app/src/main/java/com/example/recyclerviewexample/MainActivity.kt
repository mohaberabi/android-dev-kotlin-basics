package com.example.recyclerviewexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val items =
        listOf<String>("MOHAB DUMMY", "MOHAB LOSER", "MOHAB IS LIE", "MOHAB IS NOTHING ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = MyAdapter(items)
        val recView = findViewById<RecyclerView>(R.id.recView)


        recView.setBackgroundColor(Color.YELLOW)



        recView.layoutManager = LinearLayoutManager(this)

        recView.adapter = adapter

    }
}