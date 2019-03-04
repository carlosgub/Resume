package com.carlosgub.resume.ui

import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import com.carlosgub.resume.R
import com.carlosgub.resume.utils.AnalyticsBundle
import com.carlosgub.resume.utils.Tools
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    //Crear la variable
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    //Crear la clase AnalyticsBundle
    private lateinit var analyticsBundle: AnalyticsBundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initToolbar()
        initComponent()
        initNavigationMenu()

        //Instanciar Analytics
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        //Instanciar AnalyticsBundle
        analyticsBundle = AnalyticsBundle(firebaseAnalytics,applicationContext)

    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.ic_menu)
        setSupportActionBar(toolbar)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.title = "Perfil"
    }

    private fun initComponent() {
        Tools.displayImageOriginal(this,image_1, R.drawable.image_5)
        Tools.displayImageOriginal(this,image_2, R.drawable.image_6)
        Tools.displayImageOriginal(this,image_3, R.drawable.image_7)
        Tools.displayImageOriginal(this,image_4, R.drawable.image_8)
        Tools.displayImageOriginal(this,image_5, R.drawable.image_9)

        image_1.setOnClickListener { analyticsBundle.createPressEventImage("Ulima") }
        image_2.setOnClickListener { analyticsBundle.createPressEventImage("Mapsalud") }
        image_3.setOnClickListener { analyticsBundle.createPressEventImage("Antamina") }
        image_4.setOnClickListener { analyticsBundle.createPressEventImage("SPSA") }
        image_5.setOnClickListener { analyticsBundle.createPressEventImage("Firefly") }
    }

    private fun initNavigationMenu() {
        val toggle = object : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
        }
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener { item ->
            analyticsBundle.createMenuEvent(item.title.toString())
            drawer_layout.closeDrawers()
            true
        }
    }
}