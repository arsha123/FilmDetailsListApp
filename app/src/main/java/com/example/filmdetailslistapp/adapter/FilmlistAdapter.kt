package com.example.filmdetailslistapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmdetailslistapp.MainActivity
import com.example.filmdetailslistapp.R
import com.example.filmdetailslistapp.model.Filmlistmodel
import com.example.filmdetailslistapp.ui.DetailsFragment
import kotlinx.android.synthetic.main.icon_list.view.*

class FilmlistAdapter(val context: Context, val chapList: ArrayList<Filmlistmodel>) :
    RecyclerView.Adapter<FilmlistAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.icon_list,
                parent,
                false
            )
        )
    }


    override fun getItemCount(): Int {
        return chapList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name?.text = chapList.get(position).title
        holder.rootview.setOnClickListener {

            val detailsFragment =
                DetailsFragment(chapList.get(position).title,chapList.get(position).producer,chapList.get(position).desc,chapList.get(position).director,chapList.get(position).date)

            val manager: FragmentManager =
                (context as AppCompatActivity).supportFragmentManager
            manager.beginTransaction()
                .replace(R.id.main_container, detailsFragment, "detailsFragment")
                .addToBackStack("stack")
                .commit()
            }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.tvChapterName
        val rootview = view.root_view
    }


}
