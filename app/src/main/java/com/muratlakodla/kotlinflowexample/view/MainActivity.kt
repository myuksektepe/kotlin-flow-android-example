package com.muratlakodla.kotlinflowexample.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.muratlakodla.kotlinflowexample.R
import com.muratlakodla.kotlinflowexample.model.ResultData
import com.muratlakodla.kotlinflowexample.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val txtMain = findViewById<TextView>(R.id.txtMain)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)


        viewModel.fetchAllComments()
        viewModel.comments.observe(this, {
            when (it) {
                is ResultData.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    txtMain.text = "Yükleniyor.."
                }
                is ResultData.SUCCESS -> {
                    txtMain.text = it.data[0].toString()
                    progressBar.visibility = View.GONE
                }
                is ResultData.FAIL -> {
                    txtMain.text = it.message
                    progressBar.visibility = View.GONE
                }
            }
        })

    }
}