package ru.ulian.helloandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstHabitText = findViewById<TextView>(R.id.FirstHabit)
        val btnIncrease = findViewById<Button>(R.id.completedButton)
        val btnReset = findViewById<Button>(R.id.resetButton)

        counter = savedInstanceState?.getInt("counter") ?: 0
        updateCounterText(firstHabitText)

        btnIncrease.setOnClickListener()
        {
            counter++
            updateCounterText(firstHabitText)
        }
        btnReset.setOnClickListener()
        {
            counter = 0
            updateCounterText(firstHabitText)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)
    }


    private fun updateCounterText(textView: TextView)
    {
        textView.text = "Ложиться рано спать: $counter"
    }

}