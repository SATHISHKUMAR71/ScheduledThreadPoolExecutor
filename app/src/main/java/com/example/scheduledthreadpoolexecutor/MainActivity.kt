package com.example.scheduledthreadpoolexecutor

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var executor: ScheduledExecutorService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        executor = Executors.newScheduledThreadPool(2)

        executor.scheduleWithFixedDelay({
            println("New Text")
            runOnUiThread{
                findViewById<TextView>(R.id.tv).text = "new Text"
            }
        },2000,2000,TimeUnit.MILLISECONDS)
    }


    override fun onDestroy() {
        super.onDestroy()
        executor.shutdown()
    }
}