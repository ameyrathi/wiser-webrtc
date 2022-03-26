package com.robin.wiser_wrtc.splash

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.robin.wiser_wrtc.R
import com.robin.wiser_wrtc.signin.SignInActivity
import com.robin.wiser_wrtc.util.BaseActivity
import java.util.*

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@SplashActivity, SignInActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, SPLASH_INTERVAL)
    }

    companion object {
        const val SPLASH_INTERVAL = 2000L
    }
}
