package com.example.tempapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.its.calculator.R
import com.its.calculator.adapter.ViewPagerAdapter
import com.its.calculator.databinding.ActivityClassificationSettingsBinding
import com.its.calculator.fragment.ExpenseFragment
import com.its.calculator.fragment.IncomeFragment

class ClassificationSettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClassificationSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassificationSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabLayout.setupWithViewPager(binding.viewPager)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        viewPagerAdapter.addFragment(ExpenseFragment(), resources.getString(R.string.expense))
        viewPagerAdapter.addFragment(IncomeFragment(), resources.getString(R.string.income))
        binding.viewPager.adapter = viewPagerAdapter
    }
}