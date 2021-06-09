package com.example.kmmconfdemoapp.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kmmconfdemoapp.shared.Greeting
import android.widget.TextView
import com.example.kmmconfdemoapp.shared.CoroutineRandomizer
import kotlinx.coroutines.runBlocking

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.text_view)

        var text: String = ""
        val randomizer = CoroutineRandomizer()
        runBlocking {
            text = randomizer.generate()
        }
        textView.text = text
    }
}
