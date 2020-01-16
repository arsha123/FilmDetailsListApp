package com.example.filmdetailslistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmdetailslistapp.ui.FilmlistFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filmlistfragment: FilmlistFragment  = FilmlistFragment()
        supportFragmentManager.beginTransaction().add(R.id.main_container,filmlistfragment,"filmlistfragment").commit()
    }
}
