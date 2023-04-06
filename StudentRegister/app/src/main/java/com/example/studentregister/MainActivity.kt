package com.example.studentregister

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentregister.databinding.ActivityMainBinding
import com.example.studentregister.db.Student
import com.example.studentregister.db.StudentDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: StudentViewModel
    private lateinit var rvStudentAdapter: StudentRecyclerViewAdapter

    private lateinit var selectedStudent: Student
    private var isSelectedItem = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao = StudentDatabase.getInstance(application).studentDao()
        val factory = StudentViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(StudentViewModel::class.java)

        binding.apply {
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
        }

        initRecyclerView()
    }
    private fun saveStudentData() {
        binding.apply {
            viewModel.insertStudent(
                Student(
                    0,
                    etName.text.toString(),
                    etEmail.text.toString()
                )
            )
        }
    }

    private fun updateStudentData() {
        binding.apply {
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
    }

    private fun deleteStudentData() {
        binding.apply {
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
    }

    private fun clearInput() {
        binding.apply {
            etName.setText("")
            etEmail.setText("")
        }
    }

    private fun initRecyclerView() {
        binding.rvStudent.layoutManager = LinearLayoutManager(this)
        rvStudentAdapter = StudentRecyclerViewAdapter {
            selectedItem:Student -> onClickItemStudent(selectedItem)
        }
        binding.rvStudent.adapter = rvStudentAdapter
        displayStudentList()
    }

    private fun onClickItemStudent(student: Student) {
        binding.apply {
            selectedStudent = student
            isSelectedItem = true
            btnSave.text = "Update"
            btnClear.text = "Delete"

            etName.setText(selectedStudent.name)
            etEmail.setText(selectedStudent.email)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayStudentList() {
        viewModel.student.observe(this) {
            rvStudentAdapter.setList(it)
            rvStudentAdapter.notifyDataSetChanged()
        }
    }
}