package com.robin.wiser_wrtc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class GameRecyclerAdapter (val context: Context, var gameList: ArrayList<Game>, val onClickItem: (Game) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_game_layout, parent, false)
        return GameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gameList.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is GameViewHolder){
            val game: Game = gameList[position]

            //holder.item_ctnWrapper.setBackgroundResource(game.backgroundId)
            //holder.item_imgDisplayPicture.setImageResource(game.imageId)
            holder.item_lblTitle.text = game.title
        }
    }

    inner class GameViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var item_ctnWrapper: LinearLayout
        var item_imgDisplayPicture: ImageView
        var item_lblTitle: TextView

        init {
            //Declare item components
            item_ctnWrapper = itemView.findViewById(R.id.item_ctnWrapper)

            item_imgDisplayPicture = itemView.findViewById(R.id.item_imgDisplayPicture)
            item_lblTitle = itemView.findViewById(R.id.item_lblTitle)

            itemView.setOnClickListener {
                //ONCLICK Listener <<<
                val position: Int = bindingAdapterPosition //index of clicked item
                val game = gameList[position]

                onClickItem(game) //Return object
            }
        }
    }

}