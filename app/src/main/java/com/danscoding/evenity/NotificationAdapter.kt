package com.danscoding.evenity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotificationAdapter(private val notifList:ArrayList<Notification>) : RecyclerView.Adapter<NotificationAdapter.NotifViewHolder>() {

    class NotifViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageNotif : ImageView = itemView.findViewById(R.id.imageNotification)
        val titleNotif : TextView = itemView.findViewById(R.id.textViewTitleNotification)
        val descNotif : TextView = itemView.findViewById(R.id.textViewDescNotification)
        val timeStampNotif : TextView = itemView.findViewById(R.id.textViewTimeStamp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_notification, parent, false)
        return NotifViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotifViewHolder, position: Int) {
        val notif = notifList[position]
        holder.imageNotif.setImageResource(notif.imageNotification)
        holder.titleNotif.text = notif.titleNotification
        holder.descNotif.text = notif.descNotification
        holder.timeStampNotif.text = notif.timeNotification
    }

    override fun getItemCount(): Int {
        return notifList.size
    }
}