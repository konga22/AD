package com.example.problem1

import android.app.Activity
import android.os.Bundle
import com.example.problem1.databinding.ActivityProfileBinding

class ProfileActivity : Activity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name").orEmpty()
        val age = intent.getIntExtra("age", 0)
        val intro = intent.getStringExtra("intro").orEmpty()

        binding.textName.text = name
        binding.textAge.text = "${age}세"
        binding.textIntro.text = intro
        binding.textAvatar.text = name.firstOrNull()?.toString() ?: "?"

        binding.buttonBack.setOnClickListener {
            finish()
        }
    }
}
