package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.data.Data

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    var data = Data()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        data.loadData()
        initRecyclerView()


    }
    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(data.dataSource)
        recyclerView.adapter = adapter
        adapter.setOnClickListener(object : MyAdapter.OnClickListener{
            override fun onClick(index: Int, model: MyDataModel) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("name", model.name)
                intent.putExtra("profile", model.profile)
                intent.putExtra("number", model.phone)
                startActivity(intent)
            }

        })

    }
}