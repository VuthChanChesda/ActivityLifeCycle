package com.example.activitylifecycle

import User
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    fun getData () : User {
        val id = binding.editTextId.text.toString().toInt()
        val name = binding.editTextName.text.toString()
        val gender = if (binding.radioMale.isChecked) "Male" else "Female"
        val score = binding.editTextScore.text.toString().toDouble()
        return User(id, name, gender, score)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            if (binding.editTextId.text.isEmpty() || binding.editTextName.text.isEmpty() || binding.editTextScore.text.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("user", getData())
            startActivity(intent)
            finish()
        }
    }




    //        binding.btnImplicit.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = "http://www.google.com/".toUri()
//            startActivity(intent)
//        }


    //        explicit intent
//        val intent = Intent(this, MainActivity2::class.java)
//        startActivity(intent)

//        implicit intent
//        val intent = Intent(Intent.ACTION_VIEW)
//        intent.data = "http://www.google.com/".toUri()
//        startActivity(intent)

    override fun onStart() {
        super.onStart()
        Log.d("activity", "onStart invoke")
    }

    override fun onResume() {
        super.onResume()
        Log.d("activity", "onResume invoke")
    }

    override fun onPause() {
        super.onPause()
        Log.d("activity", "onPause invoke")
    }


    override fun onStop() {
        super.onStop()
        Log.d("activity", "onStop invoke")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("activity", "onRestart invoke")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("activity", "onDestroy invoke")
    }
}