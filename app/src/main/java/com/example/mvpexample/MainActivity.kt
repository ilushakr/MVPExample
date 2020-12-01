package com.example.mvpexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpexample.api.PostResponse
import com.example.mvpexample.base.App
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Contract.MainView {

    @Inject
    lateinit var presenter: Contract.ContractPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App[this].injector?.inject(this)


        presenter.attach(this)
        presenter.get()

    }

    override fun setData(data: ArrayList<PostResponse>) {
        progressBar.visibility = View.GONE
        recyclerView.adapter = Adapter(data)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


}