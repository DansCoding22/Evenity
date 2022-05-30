package com.danscoding.evenity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danscoding.evenity.Notification
import com.danscoding.evenity.NotificationAdapter
import com.danscoding.evenity.R

class NotificationFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var notifList: ArrayList<Notification>
    private lateinit var notificationAdapter: NotificationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_notification, container, false)

        initRecyclerView(view)
        return view
    }

    private fun initRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.rvNotification)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        notifList = ArrayList()

        notifList.add(Notification(R.drawable.success_notification, "Your Appointment Has Been Received", "Your appointment id A2020001 has been checked by our team, you will be contacted by our team", "10.00 AM"))
        notifList.add(Notification(R.drawable.success_notification, "Your Appointment Has Been Received", "Your appointment id A2020001 has been checked by our team, you will be contacted by our team", "10.00 AM"))
        notifList.add(Notification(R.drawable.failed_notification, "Oops! there is a mistake, your appointment is not received", "your appointment id A2020001 is not not received, try to check your form appointment", "13.00 PM"))
        notifList.add(Notification(R.drawable.success_notification, "Your Appointment Has Been Received", "Your appointment id A2020001 has been checked by our team, you will be contacted by our team", "10.00 AM"))
        notifList.add(Notification(R.drawable.success_notification, "Your Appointment Has Been Received", "Your appointment id A2020001 has been checked by our team, you will be contacted by our team", "10.00 AM"))
        notifList.add(Notification(R.drawable.failed_notification, "Oops! there is a mistake, your appointment is not received", "your appointment id A2020001 is not not received, try to check your form appointment", "13.00 PM"))
        notifList.add(Notification(R.drawable.success_notification, "Your Appointment Has Been Received", "Your appointment id A2020001 has been checked by our team, you will be contacted by our team", "10.00 AM"))
        notifList.add(Notification(R.drawable.success_notification, "Your Appointment Has Been Received", "Your appointment id A2020001 has been checked by our team, you will be contacted by our team", "10.00 AM"))
        notifList.add(Notification(R.drawable.failed_notification, "Oops! there is a mistake, your appointment is not received", "your appointment id A2020001 is not not received, try to check your form appointment", "13.00 PM"))

        notificationAdapter = NotificationAdapter(notifList)
        recyclerView.adapter = notificationAdapter
    }

}