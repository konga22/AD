package com.example.problem3

import android.app.Activity
import android.os.Bundle
import com.example.problem3.databinding.ActivityDetailBinding

class DetailActivity : Activity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title").orEmpty()
        val imageRes = intent.getIntExtra("imageRes", 0)
        val photoId = intent.getIntExtra("photoId", 0)

        if (imageRes != 0) {
            binding.imageDetail.setImageResource(imageRes)
        }
        binding.textDetailTitle.text = title
        binding.textPhotoId.text = "Photo ID: $photoId"

        binding.buttonBack.setOnClickListener {
            finish()
        }
    }
}
