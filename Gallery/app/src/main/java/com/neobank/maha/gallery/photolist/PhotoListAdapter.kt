package com.neobank.maha.gallery.photolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neobank.maha.gallery.R
import com.neobank.maha.gallery.takephoto.Photo
import com.neobank.maha.gallery.utils.loadImage
import kotlinx.android.synthetic.main.list_item_photo.view.*
import java.text.SimpleDateFormat
import java.util.Locale

class PhotoListAdapter(private var context: Context) : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    lateinit var clickListener: (String) -> Unit
    private var photoList: List<Photo> = emptyList()

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name: TextView = v.name;
        val date: TextView = v.date;
        val image: ImageView = v.image;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val row = inflater.inflate(R.layout.list_item_photo, parent, false)

        return ViewHolder(row)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val photo = photoList[position]

        holder.name.text = photo.name
        holder.date.text = SimpleDateFormat("MMM d, hh:mm aa", Locale.ENGLISH).format( photo.createdAt)

        loadImage(holder.itemView.context, photo.url, holder.image)

        holder.itemView.setOnClickListener { clickListener(photo.url) }
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    fun updatePhotos(photoList: List<Photo>) {
        this.photoList = photoList
        notifyDataSetChanged()
    }
}