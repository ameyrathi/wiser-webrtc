package com.robin.wiser_wrtc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class MingleAddParticipantRecyclerAdapter(val onClickItem: () -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_mingle_add_participant_layout, parent, false)
        return MingleAddParticipantViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
    override fun getItemCount(): Int {
        return 1
    }
    inner class MingleAddParticipantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                onClickItem() //Return object
            }
        }
    }
}