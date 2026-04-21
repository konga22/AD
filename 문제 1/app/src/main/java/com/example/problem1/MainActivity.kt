package com.example.problem1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.problem1.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonShowProfile.setOnClickListener {
            val name = binding.editTextName.text.toString().trim()
            val ageText = binding.editTextAge.text.toString().trim()
            val intro = binding.editTextIntro.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(this, "이름을 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val age = ageText.toIntOrNull() ?: 0
            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("name", name)
                putExtra("age", age)
                putExtra("intro", intro)
            }
            startActivity(intent)
        }
    }
}
