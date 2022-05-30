package com.danscoding.evenity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danscoding.evenity.Chats
import com.danscoding.evenity.ChatsAdapter
import com.danscoding.evenity.R


class MessageFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var chatList: ArrayList<Chats>
    private lateinit var chatsAdapter: ChatsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)

        initRecyclerView(view)
        return view
    }

    private fun initRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.rvChats)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        chatList = ArrayList()

        chatList.add(Chats(R.drawable.team3, "Mamans Entertaintment", "Hello How Aare yout today?","13.00 AM"))
        chatList.add(Chats(R.drawable.team3, "Y3 Organizer", "Our Team is checking your document, so please be kindly wait information from us","12.30 AM"))

        chatsAdapter = ChatsAdapter(chatList)
        recyclerView.adapter = chatsAdapter
    }


}