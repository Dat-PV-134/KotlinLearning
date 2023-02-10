package com.example.studentregister

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.studentregister.databinding.ListItemBinding
import com.example.studentregister.db.Student

class StudentRecyclerViewAdapter(private val onClickItem:(Student) -> Unit) : RecyclerView.Adapter<StudentViewHoler>() {
    val listItem = ArrayList<Student>()

    fun setList(listItem: List<Student>) {
        this.listItem.clear()
        this.listItem.addAll(listItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHoler {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHoler(binding)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: StudentViewHoler, position: Int) {
        holder.bind(listItem[position], onClickItem)
    }

}

class StudentViewHoler(private val binding: ListItemBinding) : ViewHolder(binding.root) {
    fun bind(student: Student, onClickItem:(Student) -> Unit) {
        binding.apply {
            tvName.text = student.name
            tvEmail.text = student.email

            root.setOnClickListener {
                onClickItem(student)
            }
        }
    }
}
