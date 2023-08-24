package com.its.calculator.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.its.calculator.adapter.ClassificationAdapter
import com.its.calculator.databinding.FragmentExpenseBinding
import com.its.calculator.model.Classification

class ExpenseFragment : Fragment() {
    private lateinit var binding: FragmentExpenseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExpenseBinding.inflate(inflater, container, false)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        val adapter = ClassificationAdapter(
            onClickEdit = {
               editClassification(it)
        },
            onClickDelete = {
                deleteClassification(it)
        })
        val layoutManager = LinearLayoutManager(context)

        binding.rvExpenseClassification.layoutManager = layoutManager
        binding.rvExpenseClassification.adapter = adapter
    }

    private fun deleteClassification(classification: Classification) {

    }

    private fun editClassification(classification: Classification) {

    }


}