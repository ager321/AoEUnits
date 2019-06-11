package com.example.aoeunits.model

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup


class ListAdapter(private val list: List<AoEUnitValue>)
    : RecyclerView.Adapter<UnitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UnitViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: UnitViewHolder, position: Int) {
        val aoeunit: AoEUnitValue = list[position]
        holder.bind(aoeunit)
    }

    override fun getItemCount(): Int = list.size

}