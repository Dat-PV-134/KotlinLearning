package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
        private var personList: List<Person>,
        private val onClick: (person: Person) -> Unit
    ) : RecyclerView.Adapter<MyViewHoler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHoler {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItemView = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHoler(listItemView)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: MyViewHoler, position: Int) {
        val person = personList[position]
        holder.bind(person, onClick)
    }
}

class MyViewHoler(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(person: Person, onClick: (person: Person) -> Unit) {
        val tvName = view.findViewById<TextView>(R.id.tvName)
        tvName.text = person.name

//        view.setOnClickListener {
//            Toast.makeText(
//                view.context,
//                "This is ${person.age}",
//                Toast.LENGTH_LONG
//            ).show()
//        }
        view.setOnClickListener {
            onClick(person)
        }
    }
}


