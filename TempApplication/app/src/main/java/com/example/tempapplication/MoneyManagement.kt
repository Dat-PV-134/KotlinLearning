package com.example.tempapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.its.calculator.R
import com.its.calculator.databinding.ActivityMoneyManagementBinding


class MoneyManagement : AppCompatActivity() {
    private lateinit var binding: ActivityMoneyManagementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoneyManagementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
        setupNavigationDrawer()
        setupOnClickEvent()
    }

    private fun setupOnClickEvent() {
        binding.btnDrawer.setOnClickListener {
            openDrawer()
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.btnSetting -> {
                    startActivity(Intent(this@MoneyManagement, ClassificationSettingsActivity::class.java))
                }

                R.id.btnOpenPieChart -> {
                    startActivity(Intent(this@MoneyManagement, MoneyManagementChartActivity::class.java))
                }
            }
            false
        }

        binding.fabAddNew.setOnClickListener {
            startActivity(Intent(this@MoneyManagement, AddNewSpendingItem::class.java))
        }
    }

    private fun setupNavigationDrawer() {
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.amount_of_water_needed_to_drink -> {
                    startActivity(Intent(this@MoneyManagement, WaterNeedActivity::class.java))
                    closeDrawer()
                }

                R.id.todoList -> {
                    startActivity(Intent(this@MoneyManagement, TodoListActivity::class.java))
                    closeDrawer()
                }

                R.id.moneyManagent -> {
                    startActivity(Intent(this@MoneyManagement, MoneyManagement::class.java))
                    closeDrawer()
                }
            }
            true
        }
    }

    private fun closeDrawer() {
        if (binding.moneyManagementDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.moneyManagementDrawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    private fun openDrawer() {
        if (!binding.moneyManagementDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.moneyManagementDrawerLayout.openDrawer(GravityCompat.START)
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(1).isEnabled = false
    }
}