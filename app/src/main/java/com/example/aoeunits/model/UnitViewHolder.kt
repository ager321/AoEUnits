package com.example.aoeunits.model

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.aoeunits.R

class UnitViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_unit, parent, false)) {
    private var mListNameView: TextView? = null
    private var mDescriptionView: TextView? = null
    private var mHitpointsView: TextView? = null
    private var mAttackView: TextView? = null

    init {
        mListNameView = itemView.findViewById(R.id.list_name)
        mDescriptionView = itemView.findViewById(R.id.list_description)
        mHitpointsView = itemView.findViewById(R.id.hitPoints)
        mAttackView = itemView.findViewById(R.id.attack)
    }

    fun bind(aoe_unit: AoEUnitValue) {
        mListNameView?.text = aoe_unit.name
        mDescriptionView?.text = aoe_unit.description
        mHitpointsView?.text = "HP: " + aoe_unit.hitPoints.toString()
        mAttackView?.text = "Attack value: : " + aoe_unit.attack.toString()
    }

}
