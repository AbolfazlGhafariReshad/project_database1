package com.agh.projectdatabase1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Activitylistph : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activitylistph)

        val db = AppDatabase(this)
        var phons= db.phonedao().getAll()

        val recycler = findViewById<RecyclerView>(R.id.rec_phlist)
        recycler.layoutManager=LinearLayoutManager(this)
        val adapter=ListAdapter(phons)
        recycler.adapter=adapter

    }
}