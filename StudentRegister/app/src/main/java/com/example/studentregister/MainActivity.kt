package com.example.studentregister

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentregister.db.Student
import com.example.studentregister.db.StudentDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnSave: Button
    private lateinit var btnClear: Button

    private lateinit var viewModel: StudentViewModel
    private lateinit var rvStudent: RecyclerView
    private lateinit var rvStudentAdapter: StudentRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        btnSave = findViewById(R.id.btnSave)
        btnClear = findViewById(R.id.btnClear)

        rvStudent = findViewById(R.id.rvStudent)

        val dao = StudentDatabase.getInstance(application).studentDao()
        val factory = StudentViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(StudentViewModel::class.java)

        btnSave.setOnClickListener {
            saveStudentData()
            clearInput()
        }

        initRecyclerView()
    }

    private fun saveStudentData() {
       viewModel.insertStudent(
           Student(
               0,
               etName.text.toString(),
               etEmail.text.toString()
           )
       )
    }

    private fun clearInput() {
        etName.setText("")
        etEmail.setText("")
    }

    private fun initRecyclerView() {
        rvStudent.layoutManager = LinearLayoutManager(this)
        rvStudentAdapter = StudentRecyclerViewAdapter()
        rvStudent.adapter = rvStudentAdapter
        displayStudentList()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayStudentList() {
        viewModel.student.observe(this) {
            rvStudentAdapter.setList(it)
            rvStudentAdapter.notifyDataSetChanged()
        }
    }
}