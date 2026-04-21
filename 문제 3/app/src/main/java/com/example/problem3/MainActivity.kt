package com.example.problem3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.problem3.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    private val photos = listOf(
        Photo(1, "산", R.drawable.photo_mountain),
        Photo(2, "바다", R.drawable.photo_sea),
        Photo(3, "노을", R.drawable.photo_sunset),
        Photo(4, "꽃", R.drawable.photo_flower),
        Photo(5, "도시", R.drawable.photo_city),
        Photo(6, "숲", R.drawable.photo_forest),
        Photo(7, "사막", R.drawable.photo_desert),
        Photo(8, "호수", R.drawable.photo_lake),
        Photo(9, "벚꽃", R.drawable.photo_cherry_blossom)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewPhotos.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerViewPhotos.adapter = PhotoAdapter(photos) { photo ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("title", photo.title)
                putExtra("imageRes", photo.imageRes)
                putExtra("photoId", photo.id)
            }
            startActivity(intent)
        }
    }
}
