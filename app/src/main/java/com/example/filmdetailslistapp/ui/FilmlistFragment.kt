package com.example.filmdetailslistapp.ui

import android.content.Context
import android.content.Intent
import android.graphics.ColorSpace
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmdetailslistapp.R
import com.example.filmdetailslistapp.adapter.FilmlistAdapter
import com.example.filmdetailslistapp.model.Filmlistmodel
import kotlinx.android.synthetic.main.filmlist.*
import kotlinx.android.synthetic.main.filmlist.view.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class FilmlistFragment : Fragment(){

    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var chaptersList: ArrayList<Filmlistmodel> = ArrayList()

    companion object {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val v = inflater.inflate(R.layout.filmlist, container, false)

        layoutManager = LinearLayoutManager(activity)
        v.rvChapterList.layoutManager = layoutManager
        v.rvChapterList.adapter = FilmlistAdapter(activity as Context, chaptersList)



        return v
    }



}
