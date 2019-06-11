package com.example.aoeunits.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.aoeunits.R
import com.example.aoeunits.model.AoEDataReciver
import com.example.aoeunits.model.AoEUnitValue
import com.example.aoeunits.model.ListAdapter
import kotlinx.android.synthetic.main.unit_fragment.*
import java.util.*


//data class Movie(val title: String, val year: Int)
class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.unit_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataReciver = AoEDataReciver()
        val listOfUnits =  dataReciver.getUnits()!!.toList()
        list_recycler_view.apply {

            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(listOfUnits)
        }
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}