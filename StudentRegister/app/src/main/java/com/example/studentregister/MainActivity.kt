package com.example.studentregister

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

    private lateinit var selectedStudent: Student
    private var isSelectedItem = false

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
            if (isSelectedItem) {
                updateStudentData()
                clearInput()
            } else {
                saveStudentData()
                clearInput()
            }
        }

        btnClear.setOnClickListener {
            if (isSelectedItem) {
                deleteStudentData()
                clearInput()
            } else clearInput()
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

    private fun updateStudentData() {
        viewModel.updateStudent(
            Student(
                selectedStudent.id,
                etName.text.toString(),
                etEmail.text.toString()
            )
        )
        isSelectedItem = false
        btnSave.text = "Save"
        btnClear.text = "Clear"
    }

    private fun deleteStudentData() {
        viewModel.deleteStudent(
            Student(
                selectedStudent.id,
                etName.text.toString(),
                etEmail.text.toString()
            )
        )
        isSelectedItem = false
        btnSave.text = "Save"
        btnClear.text = "Clear"
    }

    private fun clearInput() {
        etName.setText("")
        etEmail.setText("")
    }

    private fun initRecyclerView() {
        rvStudent.layoutManager = LinearLayoutManager(this)
        rvStudentAdapter = StudentRecyclerViewAdapter {
            selectedItem:Student -> onClickItemStudent(selectedItem)
        }
        rvStudent.adapter = rvStudentAdapter
        displayStudentList()
    }

    private fun onClickItemStudent(student: Student) {
        selectedStudent = student
        isSelectedItem = true
        btnSave.text = "Update"
        btnClear.text = "Delete"

        etName.setText(selectedStudent.name)
        etEmail.setText(selectedStudent.email)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayStudentList() {
        viewModel.student.observe(this) {
            rvStudentAdapter.setList(it)
            rvStudentAdapter.notifyDataSetChanged()
        }
    }
}