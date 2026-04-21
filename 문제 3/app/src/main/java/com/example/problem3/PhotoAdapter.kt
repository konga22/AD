package com.example.problem3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.problem3.databinding.ItemPhotoBinding

class PhotoAdapter(
    private val photos: List<Photo>,
    private val onPhotoClick: (Photo) -> Unit
) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    inner class PhotoViewHolder(
        private val binding: ItemPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentPhoto: Photo? = null

        init {
            binding.root.setOnClickListener {
                currentPhoto?.let(onPhotoClick)
            }
        }

        fun bind(photo: Photo) {
            currentPhoto = photo
            binding.imagePhoto.setImageResource(photo.imageRes)
            binding.imagePhoto.contentDescription = photo.title
            binding.textPhotoTitle.text = photo.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPhotoBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int = photos.size
}
