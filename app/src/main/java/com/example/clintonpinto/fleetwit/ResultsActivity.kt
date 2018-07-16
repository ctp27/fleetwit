package com.example.clintonpinto.fleetwit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_results.*

class ResultsActivity : AppCompatActivity() {

    companion object {
        val SCORE_EXTRA="results_score_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val theScore = intent.getIntExtra(SCORE_EXTRA,-1)

        resultScore.text = theScore.toString()


        result_play_again.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()

        }

        result_main_menu.setOnClickListener{
            startActivity(Intent(this,LandingActivity::class.java))
            finish()

        }
    }
}
