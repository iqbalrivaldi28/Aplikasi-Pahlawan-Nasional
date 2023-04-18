package com.example.recyclerviewapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AdapterHero(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<AdapterHero.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

    }

    // terhubung ke layout item (item_row_hero.xml)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    // Menetapkan data source ke view holder sesuai posisinya
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Kamu Memilih " + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }

    }

    // menetapkan panjang recyler viewnya
    override fun getItemCount(): Int = listHero.size

}