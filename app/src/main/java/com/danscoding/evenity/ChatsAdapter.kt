package com.danscoding.evenity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class ChatsAdapter(private val chatsList:ArrayList<Chats>) : RecyclerView.Adapter<ChatsAdapter.ChatsViewHolder>() {

    class ChatsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageChats : CircleImageView = itemView.findViewById(R.id.circleChatsImage)
        val nameChats : TextView = itemView.findViewById(R.id.textViewNameChats)
        val chats : TextView = itemView.findViewById(R.id.textViewChats)
        val timeStampChats : TextView = itemView.findViewById(R.id.textViewTimeStampChats)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_chats, parent, false)
        return ChatsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        val chats = chatsList[position]
        holder.imageChats.setImageResource(chats.image)
        holder.nameChats.text = chats.name
        holder.chats.text = chats.chats
        holder.timeStampChats.text = chats.time
    }

    override fun getItemCount(): Int {
        return chatsList.size
    }
}