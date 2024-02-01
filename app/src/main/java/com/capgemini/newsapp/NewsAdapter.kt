package com.capgemini.newsapp

import android.text.Selection
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(val newsList: List<News>,
                  val onSelection: (Int) -> Unit) : RecyclerView.Adapter<NewsAdapter.NewsHolder>(){

     inner class  NewsHolder(inflated: View): RecyclerView.ViewHolder(inflated){

         val img: ImageView = inflated.findViewById(R.id.img)
         val titlTextView: TextView = inflated.findViewById(R.id.titleT)
         val dateTextView: TextView = inflated.findViewById(R.id.dateT)
         val authorTextView: TextView = inflated.findViewById(R.id.authorT)
         val descriptionTextView: TextView = inflated.findViewById(R.id.descriptionT)

         init {
             itemView.setOnClickListener{
               onSelection(adapterPosition)
             }
         }

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)

        return NewsHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val news = newsList[position]

        holder.authorTextView.text = news.author
        holder.dateTextView.text = news.publishedAt
        holder.descriptionTextView.text = news.description
        holder.titlTextView.text = news.title
    }

}