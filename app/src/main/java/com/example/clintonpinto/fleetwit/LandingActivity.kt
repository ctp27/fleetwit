package com.example.clintonpinto.fleetwit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_landing.*

class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        startGame.setOnClickListener{

            startActivity(Intent(this,MainActivity::class.java))

        }

    }
}
