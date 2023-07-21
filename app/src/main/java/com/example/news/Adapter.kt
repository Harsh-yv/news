package com.example.news


import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.news.Article
import com.example.news.R
import com.squareup.picasso.Picasso

class Adapter(val List: List<Article>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val news= List[position]
        Picasso.get().load(news.urlToImage).into(holder.image);
        holder.title.text = news.title
        val context = holder.itemView.getContext()
        holder.itemView.setOnClickListener()
        {val Intent= Intent(Intent.ACTION_VIEW,Uri.parse(news.url))
            context.startActivity(Intent)
        }

    }

    override fun getItemCount(): Int {
        return List.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title: TextView = itemView.findViewById(R.id.title_list)
        val image:ImageView=itemView.findViewById(R.id.img)
    }
}