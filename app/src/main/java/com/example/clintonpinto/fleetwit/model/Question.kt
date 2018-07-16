package com.example.clintonpinto.fleetwit.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Question(var question:String,
               var option1:String,
               var option2:String,
               var option3:String,
               var option4:String,
               var answer:String) :Parcelable