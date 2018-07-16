package com.example.clintonpinto.fleetwit.utils

import android.content.Context
import com.example.clintonpinto.fleetwit.R
import com.example.clintonpinto.fleetwit.model.Question

class FleetwitUtils{

    companion object {

        fun populateLists(context:Context) : ArrayList<Question>{

            val questions = arrayListOf<Question>()

            questions.add(Question(context.getString(R.string.question1),
                    context.getString(R.string.option1),
                    context.getString(R.string.option2),
                    context.getString(R.string.option3),
                    context.getString(R.string.option4),
                    context.getString(R.string.answer1)))//

            questions.add(Question(context.getString(R.string.question2),
                    context.getString(R.string.option21),
                    context.getString(R.string.option22),
                    context.getString(R.string.option23),
                    context.getString(R.string.option24),
                    context.getString(R.string.answer2)))//

            questions.add(Question(context.getString(R.string.question3),
                    context.getString(R.string.option31),
                    context.getString(R.string.option32),
                    context.getString(R.string.option33),
                    context.getString(R.string.option34),
                    context.getString(R.string.answer3)))//


            questions.add(Question(context.getString(R.string.question4),
                    context.getString(R.string.option41),
                    context.getString(R.string.option42),
                    context.getString(R.string.option43),
                    context.getString(R.string.option44),
                    context.getString(R.string.answer4)))//


            questions.add(Question(context.getString(R.string.question5),
                    context.getString(R.string.option51),
                    context.getString(R.string.option52),
                    context.getString(R.string.option53),
                    context.getString(R.string.option54),
                    context.getString(R.string.answer5)))


            questions.add(Question(context.getString(R.string.question6),
                    context.getString(R.string.option61),
                    context.getString(R.string.option62),
                    context.getString(R.string.option63),
                    context.getString(R.string.option64),
                    context.getString(R.string.answer6)))

            questions.add(Question(context.getString(R.string.question7),
                    context.getString(R.string.option71),
                    context.getString(R.string.option72),
                    context.getString(R.string.option73),
                    context.getString(R.string.option74),
                    context.getString(R.string.answer7)))

            questions.add(Question(context.getString(R.string.question8),
                    context.getString(R.string.option81),
                    context.getString(R.string.option82),
                    context.getString(R.string.option83),
                    context.getString(R.string.option84),
                    context.getString(R.string.answer8)))


            questions.add(Question(context.getString(R.string.question9),
                    context.getString(R.string.option91),
                    context.getString(R.string.option92),
                    context.getString(R.string.option93),
                    context.getString(R.string.option94),
                    context.getString(R.string.answer9)))

            questions.add(Question(context.getString(R.string.question10),
                    context.getString(R.string.option101),
                    context.getString(R.string.option102),
                    context.getString(R.string.option103),
                    context.getString(R.string.option104),
                    context.getString(R.string.answer10)))

            questions.add(Question(context.getString(R.string.question11),
                    context.getString(R.string.option111),
                    context.getString(R.string.option112),
                    context.getString(R.string.option113),
                    context.getString(R.string.option114),
                    context.getString(R.string.answer11)))

            questions.add(Question(context.getString(R.string.question12),
                    context.getString(R.string.option121),
                    context.getString(R.string.option122),
                    context.getString(R.string.option123),
                    context.getString(R.string.option124),
                    context.getString(R.string.answer12)))

            questions.add(Question(context.getString(R.string.question13),
                    context.getString(R.string.option131),
                    context.getString(R.string.option132),
                    context.getString(R.string.option133),
                    context.getString(R.string.option134),
                    context.getString(R.string.answer13)))

            questions.add(Question(context.getString(R.string.question14),
                    context.getString(R.string.option141),
                    context.getString(R.string.option142),
                    context.getString(R.string.option143),
                    context.getString(R.string.option144),
                    context.getString(R.string.answer14)))

            questions.add(Question(context.getString(R.string.question15),
                    context.getString(R.string.option151),
                    context.getString(R.string.option152),
                    context.getString(R.string.option153),
                    context.getString(R.string.option154),
                    context.getString(R.string.answer15)))

            questions.add(Question(context.getString(R.string.question16),
                    context.getString(R.string.option161),
                    context.getString(R.string.option162),
                    context.getString(R.string.option163),
                    context.getString(R.string.option164),
                    context.getString(R.string.answer16)))

            questions.add(Question(context.getString(R.string.question17),
                    context.getString(R.string.option171),
                    context.getString(R.string.option172),
                    context.getString(R.string.option173),
                    context.getString(R.string.option174),
                    context.getString(R.string.answer17)))


            questions.add(Question(context.getString(R.string.question18),
                    context.getString(R.string.option181),
                    context.getString(R.string.option182),
                    context.getString(R.string.option183),
                    context.getString(R.string.option184),
                    context.getString(R.string.answer18)))

            questions.add(Question(context.getString(R.string.question19),
                    context.getString(R.string.option191),
                    context.getString(R.string.option192),
                    context.getString(R.string.option193),
                    context.getString(R.string.option194),
                    context.getString(R.string.answer19)))

            questions.add(Question(context.getString(R.string.question20),
                    context.getString(R.string.option201),
                    context.getString(R.string.option202),
                    context.getString(R.string.option203),
                    context.getString(R.string.option204),
                    context.getString(R.string.answer20)))

            return questions
        }
    }
}