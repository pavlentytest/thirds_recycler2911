package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class MyAdapter(val list: List<Book>) : RecyclerView.Adapter<MyAdapter.MyView>() {

    class MyView(view: View) : RecyclerView.ViewHolder(view) {
        val view_name : TextView = view.findViewById(R.id.bookName)
        val view_year: TextView = view.findViewById(R.id.bookYear)
        val view_image: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item,parent,false)
        return MyView(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.view_name.text = list.get(position).name
        holder.view_year.text = list.get(position).year.toString()
        Picasso.get().load(list.get(position).image).into(holder.view_image)

        holder.itemView.setOnClickListener {
            Snackbar.make(holder.itemView,"N $position",Snackbar.LENGTH_LONG).show()
        }
    }
}