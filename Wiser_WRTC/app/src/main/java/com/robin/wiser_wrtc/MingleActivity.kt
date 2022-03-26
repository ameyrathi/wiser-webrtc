package com.robin.wiser_wrtc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Toast
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.robin.wiser_wrtc.databinding.ActivityMingleBinding

class MingleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMingleBinding

    //Participants
    val userList: ArrayList<User> = arrayListOf<User>(User.dummy_user_1, User.dummy_user_2, User.dummy_user_3)
    private val MAX_MINGLE_PARTICIPANTS = 5

    private lateinit var participantsLayoutManager: RecyclerView.LayoutManager
    private lateinit var participantsAdapter: MingleParticipantRecyclerAdapter

    //Mic
    var isMicOn = false

    //Games
    val gameList: ArrayList<Game> = arrayListOf<Game>(Game.PAIR_THE_CARDS, Game.FASTEST_HANDS)
    private lateinit var gameLayoutManager: RecyclerView.LayoutManager
    private lateinit var gameAdapter: GameRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMingleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        //Close Button
        binding.btnClose.setOnClickListener {
            finish()
        }

        //Participants Recycle View
        participantsLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvParticipants.layoutManager = participantsLayoutManager
        refreshParticipantsRecycleView()

        //Video call
        binding.ctnVideoCall.setOnClickListener {

        }

        //Mic
        binding.ctnMicControl.setOnClickListener {
            isMicOn = !isMicOn
            refreshMic()
        }
        refreshMic()

        //Games Recycle View
        gameLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvGames.layoutManager = gameLayoutManager
        refreshGameRecycleView()

        //Room Id
        binding.lblRoomId.text = "Room id: 20321"
    }
    fun refreshMic(){
        if(isMicOn){
            binding.imgMicControl.setImageResource(R.drawable.mic_on)
            binding.lblMicControl.text = "Mic on"
        }else{
            binding.imgMicControl.setImageResource(R.drawable.mic_off)
            binding.lblMicControl.text = "Mic muted"
        }
    }

    //Participants Recycle View
    fun refreshParticipantsRecycleView(){
        participantsAdapter = MingleParticipantRecyclerAdapter(this, userList, {
            Toast.makeText(this, "Clicked ${it.name}", Toast.LENGTH_SHORT).show()
        })
        if(userList.count() < MAX_MINGLE_PARTICIPANTS){
            val addParticipantAdapter = MingleAddParticipantRecyclerAdapter {
                Toast.makeText(this, "Clicked add", Toast.LENGTH_SHORT).show()
            }
            val concatAdapter = ConcatAdapter(participantsAdapter, addParticipantAdapter)
            binding.rvParticipants.adapter = concatAdapter
        }else{
            binding.rvParticipants.adapter = participantsAdapter
        }
        refreshParticipantsCounter()
    }
    fun refreshParticipantsCounter(){
        if(userList.count() <= MAX_MINGLE_PARTICIPANTS){
            binding.lblParticipantsCounter.text = "${userList.count()} / ${MAX_MINGLE_PARTICIPANTS} people"
        }else{
            binding.lblParticipantsCounter.text = "${userList.count()} / ${userList.count()} people"
        }
    }

    //Games Recycle View
    fun refreshGameRecycleView(){
        gameAdapter = GameRecyclerAdapter(this, gameList) {
            if (it.type == GameType.PAIR_THE_CARDS) {
                val myIntent = Intent(this, GamePairCardActivity::class.java)
                startActivity(myIntent)
            } else if (it.type == GameType.FASTEST_HANDS) {
                val myIntent = Intent(this, GameFastestHandsActivity::class.java)
                startActivity(myIntent)
            } else {
                Toast.makeText(this, "${it.title}'s coming soon", Toast.LENGTH_SHORT).show()
            }
        }
        binding.rvGames.adapter = gameAdapter
    }


}