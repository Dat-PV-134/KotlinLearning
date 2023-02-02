package com.example.studentregister

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.studentregister.db.Student

class StudentRecyclerViewAdapter() : RecyclerView.Adapter<StudentViewHoler>() {
    val listItem = ArrayList<Student>()

    fun setList(listItem: List<Student>) {
        this.listItem.clear()
        this.listItem.addAll(listItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHoler {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return StudentViewHoler(listItem)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: StudentViewHoler, position: Int) {
        holder.bind(listItem[position])
    }

}

class StudentViewHoler(private val view: View) : ViewHolder(view) {
    fun bind(student: Student) {
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvEmail = view.findViewById<TextView>(R.id.tvEmail)
        tvName.text = student.name
        tvEmail.text = student.email
    }
}
