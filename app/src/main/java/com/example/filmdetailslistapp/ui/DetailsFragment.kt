package com.example.filmdetailslistapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmdetailslistapp.R
import com.example.filmdetailslistapp.adapter.FilmlistAdapter
import kotlinx.android.synthetic.main.details.view.*
import kotlinx.android.synthetic.main.filmlist.*
import kotlinx.android.synthetic.main.filmlist.view.*

class DetailsFragment(
    var title: String,
    var producer: String,
    var des: String,
    var director: String,
    var date: String
) : Fragment() {

    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var chaptersList: ArrayList<String> = ArrayList()

    companion object {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val v = inflater.inflate(R.layout.details, container, false)





        return v
    }

}