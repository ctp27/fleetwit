package com.example.clintonpinto.fleetwit.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.INotificationSideChannel
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.clintonpinto.fleetwit.MainActivity
import com.example.clintonpinto.fleetwit.R
import com.example.clintonpinto.fleetwit.R.id.question
import com.example.clintonpinto.fleetwit.model.Question
import kotlinx.android.synthetic.main.quiz_fragment.*
import kotlinx.android.synthetic.main.quiz_fragment.view.*

class QuizFragment : Fragment(),View.OnClickListener{

    companion object {
        val BUNDLE_QUESTION_KEY: String = "bundle_question_key"
        val BUNDLE_SCORE_KEY: String = "bundle_score_key"
        val BUNDLE_NUMBER_KEY:String ="bundle_number_key"
    }


    var currentAns : TextView? = null

    var optionViews = arrayListOf<TextView>()


    private var callback:QuizFragmentCallback? = null


    interface QuizFragmentCallback{
        fun onAnswerSelected(isRight:Boolean)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.quiz_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)

        val b:Bundle = arguments!!

        val thisQuestion = b.get(BUNDLE_QUESTION_KEY) as Question

        val theCounter = b.get(BUNDLE_NUMBER_KEY) as String
        val theScore = b.get(BUNDLE_SCORE_KEY) as String

        score.text = getString(R.string.score_text,theScore,MainActivity.QUESTION_SET_SIZE.toString())
        level.text = getString(R.string.level_text,theCounter,MainActivity.QUESTION_SET_SIZE.toString())

        setQuestionViews(thisQuestion)
        optionViews.add(option1)
        optionViews.add(option2)
        optionViews.add(option3)
        optionViews.add(option4)


    }

    override fun onClick(v: View?) {

        val theId:Int = v!!.id

        when(theId){

            R.id.option1 ->
                    showAnswer(option1)
            R.id.option2->
                    showAnswer(option2)
            R.id.option3->
                    showAnswer(option3)
            R.id.option4->
                    showAnswer(option4)

        }

    }



    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is QuizFragmentCallback) {
            callback = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement FragmentCallback")
        }

    }

    private fun setQuestionViews(thisQuestion: Question){

        question.text = thisQuestion.question
        option1.text = thisQuestion.option1
        option2.text = thisQuestion.option2
        option3.text = thisQuestion.option3
        option4.text = thisQuestion.option4

        if(thisQuestion.answer.equals(thisQuestion.option1))
            currentAns = option1
        else if(thisQuestion.answer.equals(thisQuestion.option2))
            currentAns = option2
        else if(thisQuestion.answer.equals(thisQuestion.option3))
            currentAns = option3
        else
            currentAns = option4

    }

    private fun showAnswer(ansView: TextView){


        if(ansView == currentAns){
            showAnswerView(true,ansView)
            callback?.onAnswerSelected(true)
        }
        else{
            showAnswerView(false,ansView)
            callback?.onAnswerSelected(false)
        }


    }


    private fun showAnswerView(isRight:Boolean, ansView:TextView){

        for (i in 0 until optionViews.size){
            val thisView = optionViews[i]
            if(thisView!=ansView){
                val color = ContextCompat.getColor(context!!,R.color.colorDark)
                thisView.setBackgroundColor(color)
            }
        }


        if(!isRight){
            ansView.setBackgroundColor(ContextCompat.getColor(context!!,R.color.colorWrong))
            currentAns?.setBackgroundColor(ContextCompat.getColor(context!!,R.color.colorRight))
        }else{
            ansView.setBackgroundColor(ContextCompat.getColor(context!!,R.color.colorRight))
        }
    }


}