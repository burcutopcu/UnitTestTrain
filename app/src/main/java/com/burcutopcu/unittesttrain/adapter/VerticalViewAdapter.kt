package com.burcutopcu.unittesttrain.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.burcutopcu.unittesttrain.R
import com.burcutopcu.unittesttrain.model.Pokemon
import kotlinx.android.synthetic.main.list_item.view.*


class VerticalViewAdapter(private val pokemonList: List<Pokemon>) :
    RecyclerView.Adapter<VerticalViewAdapter.VerticalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return VerticalViewHolder(v)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        holder.bindItems(pokemonList[position])
    }

    class VerticalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: Pokemon) {
            itemView.user_id.text = user.id
            itemView.user_name.text = user.name
            itemView.user_type.text = user.type.toString()
            itemView.created_at.text = user.createdAt
        }
    }
}