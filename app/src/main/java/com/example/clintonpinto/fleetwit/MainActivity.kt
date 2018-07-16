package com.example.clintonpinto.fleetwit

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.util.Log
import com.example.clintonpinto.fleetwit.fragments.QuizFragment
import com.example.clintonpinto.fleetwit.model.Question
import com.example.clintonpinto.fleetwit.utils.FleetwitUtils
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class MainActivity : AppCompatActivity(),QuizFragment.QuizFragmentCallback{

    /* Increase this number to increase the number of questions asked */
    companion object {
        val QUESTION_SET_SIZE:Int = 5
    }

    private val BUNDLE_QUESTIONS_KEY:String="bundle_questions_key"
    private val BUNDLE_QUESTIONS_SET_INDEX_KEY:String="bundle_questions_indexes_key"
    private val BUNDLE_COUNTER_KEY:String="bundle_counter_key"
    private val BUNDLE_SCORE_KEY:String="bundle_score_key"


    var questions: ArrayList<Question>? = null

    var questionSetIndexes:IntArray ?= null

    var counter = 0
    var currentScore = 0


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(savedInstanceState==null){

            questions = FleetwitUtils.populateLists(this)

            GenerateQuestionsTask().execute()

//            Log.d("MainActivity","Created Fragment")

        }else{
            questions = savedInstanceState.getParcelableArrayList(BUNDLE_QUESTIONS_KEY)
            questionSetIndexes = savedInstanceState.getIntArray(BUNDLE_QUESTIONS_SET_INDEX_KEY)
            counter = savedInstanceState.getInt(BUNDLE_COUNTER_KEY)
            currentScore = savedInstanceState.getInt(BUNDLE_SCORE_KEY)
        }


    }

    override fun onAnswerSelected(isRight: Boolean) {

        if(isRight)
            currentScore++

        counter++

        Handler().postDelayed({

            if(counter<QUESTION_SET_SIZE){

                val nextQuestion = getNextQuestion()

                val bundle = Bundle()

                val fragment = QuizFragment()

                var level = counter+1

                bundle.putParcelable(QuizFragment.BUNDLE_QUESTION_KEY,nextQuestion)
                bundle.putString(QuizFragment.BUNDLE_NUMBER_KEY,level.toString())
                bundle.putString(QuizFragment.BUNDLE_SCORE_KEY,currentScore.toString())

                fragment.arguments = bundle

                supportFragmentManager.beginTransaction()
                        .replace(R.id.quiz_holder,fragment)
                        .commit()

            }else{
                val resultsIntent = Intent(this,ResultsActivity::class.java)
                resultsIntent.putExtra(ResultsActivity.SCORE_EXTRA,currentScore)
                startActivity(resultsIntent)
                finish()
            }


        },1000)


    }




    private fun getNextQuestion():Question{
        return questions!![questionSetIndexes!![counter]]
    }




    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putParcelableArrayList(BUNDLE_QUESTIONS_KEY,questions)
        outState?.putIntArray(BUNDLE_QUESTIONS_SET_INDEX_KEY,questionSetIndexes)
        outState?.putInt(BUNDLE_COUNTER_KEY,counter)
        outState?.putInt(BUNDLE_SCORE_KEY,currentScore)

    }





    inner class GenerateQuestionsTask : AsyncTask<Void,Void,IntArray>(){

        override fun doInBackground(vararg params: Void?): IntArray {

            return populateQuestionSet()
        }


        override fun onPostExecute(result: IntArray) {

            questionSetIndexes = result

            val fragment = QuizFragment()

            val bundle = Bundle()
            val level = counter+1

            bundle.putParcelable(QuizFragment.BUNDLE_QUESTION_KEY,getNextQuestion())

            bundle.putString(QuizFragment.BUNDLE_NUMBER_KEY,level.toString())
            bundle.putString(QuizFragment.BUNDLE_SCORE_KEY,currentScore.toString())

            fragment.arguments=bundle

            supportFragmentManager.beginTransaction()
                    .add(R.id.quiz_holder,fragment)
                    .commit()

        }


        private fun populateQuestionSet() : IntArray{
            val questionSet = HashSet<Int>()
            val random = Random()
            while (questionSet.size < QUESTION_SET_SIZE) {
                questionSet.add(random.nextInt(questions!!.size))
            }

            return questionSet.toIntArray()
        }
    }








}
