package com.danscoding.evenity.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danscoding.evenity.*
import com.danscoding.evenity.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var teamList : ArrayList<Team>
    private lateinit var teamAdapter: TeamAdapter
    private lateinit var categoriesList : ArrayList<Categories>
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var binding: FragmentHomeBinding

    lateinit var textViewViewAllAvailableTeam : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        initRecyclerView(view)
        initCategoriesRecycler(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewViewAllAvailableTeam = view.findViewById(R.id.textViewViewAllAvailableTeam)

        textViewViewAllAvailableTeam.setOnClickListener {
            val intent = Intent(requireActivity(), EventOrganizerListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initCategoriesRecycler(view: View) {
        recyclerView = view.findViewById(R.id.rvCategories)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL , false)

        categoriesList = ArrayList()

        categoriesList.add(Categories(R.drawable.bride, "Weeding"))
        categoriesList.add(Categories(R.drawable.music, "Music"))
        categoriesList.add(Categories(R.drawable.video, "Video"))
        categoriesList.add(Categories(R.drawable.camera, "Photo"))

        categoriesAdapter = CategoriesAdapter((categoriesList))
        categoriesAdapter = CategoriesAdapter((categoriesList))
        categoriesAdapter = CategoriesAdapter((categoriesList))
        categoriesAdapter = CategoriesAdapter((categoriesList))


        recyclerView.adapter = categoriesAdapter
    }

    private fun initRecyclerView(view: View) {

        recyclerView = view.findViewById(R.id.rvAvailableTeam)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

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