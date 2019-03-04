package com.carlosgub.resume.utils

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics

class AnalyticsBundle(private var firebaseAnalytics:FirebaseAnalytics, private var context:Context){

    fun createMenuEvent(eventName: String){
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, eventName)
        firebaseAnalytics.logEvent("menu_item", bundle)
        Toast.makeText(context, "Se presiono la categoria $eventName", Toast.LENGTH_SHORT).show()
    }

    fun createPressEventImage(imageName: String){
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, imageName)
        firebaseAnalytics.logEvent("Image_Pressed", bundle)
        Toast.makeText(context, "Se presiono la imagen $imageName", Toast.LENGTH_SHORT).show()
    }
}