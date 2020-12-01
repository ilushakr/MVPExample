package com.example.mvpexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpexample.api.PostResponse
import kotlinx.android.synthetic.main.item.view.*

class Adapter(private val dataSet: ArrayList<PostResponse>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val id: TextView = view.Id
        val userId: TextView = view.userId
        val title: TextView = view.title
        val body: TextView = view.body

//        fun bind(position : Int){
//            view.setOnClickListener {
//            }
//        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.id.text = dataSet[position].id.toString()
        viewHolder.userId.text = dataSet[position].userId.toString()
        viewHolder.body.text = dataSet[position].body
        viewHolder.title.text = dataSet[position].title

//        viewHolder.bind(position)
    }

    override fun getItemCount() = dataSet.size

}