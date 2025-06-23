package com.example.activitylifecycle

import User
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activitylifecycle.databinding.ActivityMain2Binding
import com.example.activitylifecycle.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>("user")
        if (user != null) {
            binding.textViewId.text = "ID: ${user.id}"
            binding.textViewName.text = "Name: ${user.name}"
            binding.textViewGender.text = "Gender: ${user.gender}"
            binding.textViewScore.text = "Score: ${user.score}"
        }
        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}