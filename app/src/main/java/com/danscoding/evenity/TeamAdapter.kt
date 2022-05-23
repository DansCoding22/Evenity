package com.danscoding.evenity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TeamAdapter(private val teamList:ArrayList<Team>) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageTeam : ImageView = itemView.findViewById(R.id.imageTeam)
        val nameTeam : TextView = itemView.findViewById(R.id.textViewNameTeam)
        val categoryTeam : TextView = itemView.findViewById(R.id.textViewCategoryTeam)
        val priceTeam : TextView = itemView.findViewById(R.id.textViewPrice)
        val ratingTeam : TextView = itemView.findViewById(R.id.textViewRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_avail_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teamList[position]
        holder.imageTeam.setImageResource(team.image)
        holder.nameTeam.text = team.name
        holder.categoryTeam.text = team.category
        holder.priceTeam.text = team.price
        holder.ratingTeam.text = team.rating
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

}