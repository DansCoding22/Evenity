package com.danscoding.evenity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(private val categoriesList : List<Categories>) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    class CategoriesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val categoriesImageView : ImageView = itemView.findViewById(R.id.categoriesImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_categories , parent , false)

        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val categories = categoriesList[position]
        holder.categoriesImageView.setImageResource(categories.categoriesImage)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

}