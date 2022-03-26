package com.robin.wiser_wrtc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MingleParticipantRecyclerAdapter (val context: Context, var userList: ArrayList<User>, val onClickItem: (User) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_mingle_participant_layout, parent, false)
        return MingleParticipantUserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MingleParticipantUserViewHolder){
            val profile: User = userList[position]
            Picasso.get().load(profile.displayPictureUrl).into(holder.item_imgDisplayPicture)
            println(profile.displayPictureUrl)
            holder.item_lblName.text = profile.name
            println("Loading ${profile.name}")
        }
    }

    inner class MingleParticipantUserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val item_imgDisplayPicture: ImageView
        val item_lblName: TextView

        init {
            item_imgDisplayPicture = itemView.findViewById(R.id.item_imgDisplayPicture)
            item_lblName = itemView.findViewById(R.id.item_lblName)
            itemView.setOnClickListener {
                val position: Int = bindingAdapterPosition
                val user = userList[position]
                onClickItem(user)
            }
        }
    }

}