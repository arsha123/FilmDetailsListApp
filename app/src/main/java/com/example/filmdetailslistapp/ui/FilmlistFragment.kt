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
        fetchData()
        layoutManager = LinearLayoutManager(activity)
        v.rvChapterList.layoutManager = layoutManager
        v.rvChapterList.adapter = FilmlistAdapter(activity as Context, chaptersList)



        return v
    }

    private fun fetchData() {
        val mClient = OkHttpClient();
        val request:Request = Request.Builder()
            .url("https://swapi.co/api/films/?format=json")
            .addHeader("Content-Type", " application/x-www-form-urlencoded")
            .build()

        mClient.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: okhttp3.Call, e: IOException) {
                activity!!.runOnUiThread {
                    Log.d("loga", "succ: " + e)

                }

                e.printStackTrace()
            }

            override fun onResponse(call: okhttp3.Call, response: Response) {
                if (response.isSuccessful) {
                    val responseString = response.body!!.string()
                    Log.d("loga", "succ: " + responseString)

                    activity!!.runOnUiThread {

                        try {
                            val jObject = JSONObject(responseString)
                            val events = jObject.getJSONArray("results")
                            Log.d("loga", "succ: " + events)
                            for (i in 0 until events.length()) {
                                var jsonObj = events.getJSONObject(i)

                                val titleValue = jsonObj.getString("title")
                                val producer = jsonObj.getString("producer")
                                val openingcrawl = jsonObj.getString("opening_crawl")
                                val director = jsonObj.getString("director")
                                val date = jsonObj.getString("release_date")

                                val model = Filmlistmodel(
                                    titleValue,
                                    producer,
                                    openingcrawl,
                                    director,
                                    date
                                )

                                chaptersList.add(model)
                            }
                            view!!.rvChapterList.adapter =
                                FilmlistAdapter(activity as Context, chaptersList)


                        } catch (e: Exception) {
                            e.printStackTrace()
                        }

                    }
                }
            }

        })

    }

}
