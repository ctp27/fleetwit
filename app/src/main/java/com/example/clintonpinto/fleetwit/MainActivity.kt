package com.example.clintonpinto.fleetwit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.clintonpinto.fleetwit.model.Question
import com.example.clintonpinto.fleetwit.utils.FleetwitUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    var questions: List<Question>? = null

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questions = FleetwitUtils.populateLists(this)

        option1.setOnClickListener{
            showAnswer(option1)
        }

        option2.setOnClickListener{
            showAnswer(option2)
        }

        option3.setOnClickListener{
            showAnswer(option3)
        }

        option4.setOnClickListener{
            showAnswer(option4)
        }

    }




    private fun nextQuestion(){




    }

    private fun showAnswer(ansView:TextView){



    }







}
