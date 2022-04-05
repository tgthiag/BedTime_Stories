package com.app.apitry

import android.content.Context
import android.content.Intent
import android.graphics.Color.GREEN
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(var ctx : Context,var listss : List<Posts>) : RecyclerView.Adapter<Adapter.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
         var view = LayoutInflater.from(ctx).inflate(R.layout.item_view, parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var title = listss[position].title?.replace("Ass","Donkey")?.replace("Cock","Rooster")
        holder.textT.text = title
        holder.textDesc.text = "Moral: " + listss[position].moral
        holder.textT.setOnClickListener {(holder.textT.setTextColor(GREEN))} // click event
        holder.textT.setOnClickListener {
            val intent = Intent(ctx, ReadStorie::class.java)
            intent.putExtra("titulo",listss[position].title)
            intent.putExtra("body",listss[position].story)
        ctx.startActivity(intent)
        } // click event


    }

    override fun getItemCount(): Int {
        return listss.size
    }
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       var textT : TextView = itemView.findViewById(R.id.textTitle)
        var textDesc : TextView = itemView.findViewById(R.id.textDesc)


    }
}