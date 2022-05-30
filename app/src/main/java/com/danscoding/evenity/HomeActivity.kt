package com.danscoding.evenity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var teamList : ArrayList<Team>
    private lateinit var teamAdapter: TeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.rvAvailableTeam)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        teamList = ArrayList()

        teamList.add(Team(R.drawable.team1, "Y3 Organizer", "Rp 10.000.000", "4.5", "Weeding Organizer"))
        teamList.add(Team(R.drawable.team2, "Aline Organizer", "Rp 9.000.000", "4.5", "Weeding Organizer"))
        teamList.add(Team(R.drawable.team3, "Mamans Organizer", "Rp 20.000.000", "5.0", "Weeding Organizer"))
        teamList.add(Team(R.drawable.team4, "Ogie Entertainment", "Rp 15.000.000", "4.4", "Weeding Organizer & Music"))
        teamList.add(Team(R.drawable.team5, "Belleza Entertainment", "Rp 7.000.000", "4.6", "Weeding Organizer"))
        teamList.add(Team(R.drawable.team6, "VECHA Event Organizer", "Rp 5.000.000", "4.4", "Weeding Organizer"))

        teamAdapter = TeamAdapter(teamList)
        recyclerView.adapter = teamAdapter

    }
}