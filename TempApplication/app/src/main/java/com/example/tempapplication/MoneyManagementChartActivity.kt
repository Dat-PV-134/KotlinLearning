package com.example.tempapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.its.calculator.R
import com.its.calculator.constaint.Constants
import com.its.calculator.databinding.ActivityMoneyManagementBinding
import com.its.calculator.databinding.ActivityMoneyManagementChartBinding

class MoneyManagementChartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoneyManagementChartBinding
    private val things = arrayOf("Food", "Travel", "Pet", "Home", "Others")
    var costs = doubleArrayOf(120.0, 86.0, 50.0, 15.0, 40.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoneyManagementChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupPieChart()
        loadPieChartData()
    }

    private fun setupView() {
    }

    private fun setupPieChart() {
        binding.apply {
            moneyManagentChart.isDrawHoleEnabled = true
            moneyManagentChart.setUsePercentValues(true)
            moneyManagentChart.setDrawEntryLabels(false)
            moneyManagentChart.centerText = Constants.TOTAL_SPENDING
            moneyManagentChart.setCenterTextSize(10f)
            moneyManagentChart.description.isEnabled = false

            val legend: Legend = moneyManagentChart.legend
            legend.verticalAlignment = Legend.LegendVerticalAlignment.CENTER
            legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
            legend.orientation = Legend.LegendOrientation.VERTICAL
            legend.setDrawInside(false)
            legend.isEnabled = true
        }
    }

    private fun loadPieChartData() {
        val entries = ArrayList<PieEntry>()
        var total = 0.0;
        for (cost in costs) {
            total += cost
        }
        entries.add(PieEntry(costs[0].toFloat(), String.format("%-20s%.2f%1s", things[0], (costs[0]*100/total), "%")))
        entries.add(PieEntry(costs[1].toFloat(), String.format("%-20s%.2f%1s", things[1], (costs[1]*100/total), "%")))
        entries.add(PieEntry(costs[2].toFloat(), String.format("%-20s%.2f%1s", things[2], (costs[2]*100/total), "%")))
        entries.add(PieEntry(costs[3].toFloat(), String.format("%-20s%.2f%1s", things[3], (costs[3]*100/total), "%")))
        entries.add(PieEntry(costs[4].toFloat(), String.format("%-20s%.2f%1s", things[4], (costs[4]*100/total), "%")))

        val colors = ArrayList<Int>()
        colors.add(ColorTemplate.VORDIPLOM_COLORS[4])
        colors.add(ColorTemplate.VORDIPLOM_COLORS[2])
        colors.add(ColorTemplate.VORDIPLOM_COLORS[1])
        colors.add(ColorTemplate.VORDIPLOM_COLORS[0])
        colors.add(Color.parseColor("#8C8C9D"))

        val dataSet = PieDataSet(entries, "")
        dataSet.colors = colors
        val data = PieData(dataSet)
        data.setDrawValues(false)
        data.setValueFormatter(PercentFormatter(binding.moneyManagentChart))
        data.setValueTextSize(12f)
        data.setValueTextColor(Color.BLACK)
        binding.moneyManagentChart.data = data
        binding.moneyManagentChart.invalidate()
        binding.moneyManagentChart.animateY(2000, Easing.EaseInOutQuad)
    }
}