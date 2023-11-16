package com.example.apiapplication

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiapplication.Models.NewsHeadlines
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), SelectListener {
    private var recyclerView: RecyclerView? = null
    private var adapter: CustomAdapter? = null
    private var dialog: ProgressDialog? = null
    private val viewModel : MainActivityViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dialog = ProgressDialog(this)
        dialog!!.setTitle("Получение новостных статей.")
        dialog!!.show()

        viewModel.newsHeadlinesLiveData.observe(this) { list: List<NewsHeadlines> ->
            showNews(list) }
        viewModel.fetchNewsHeadlines("general", null)
    }

    private fun showNews(list: List<NewsHeadlines>) {
        recyclerView = findViewById(R.id.recycler_main)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = GridLayoutManager(this, 1)
        adapter = CustomAdapter(this, list, this)
        recyclerView?.adapter = adapter
        dialog!!.dismiss()
    }

    override fun OnNewsClicked(headlines: NewsHeadlines) {
        startActivity(Intent(this@MainActivity, DetailsActivity::class.java)
                .putExtra("data", headlines))
        // data - ключ для получения данных в активности
    }
}