package com.example.charts_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class Static_PieChart : AppCompatActivity() {

    //VARIABLES
    lateinit var pieChartVar: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_pie_chart)


        //DO IT ALL, 1 TIME
        //val name : Type = findViewById(R.id)
        val pieChartVar: PieChart = findViewById(R.id.pieChartone)

        val btnB2Main : Button = findViewById(R.id.btnB2Main)


        //create an object of arraylist
        val values = ArrayList<PieEntry>()

        //to add items or Slices onto the graph --> .add
        values.add(PieEntry ( 500f, "Min"))
        values.add(PieEntry( 100f, "Cat 1"))
        values.add(PieEntry ( 756f, "Cat 2"))
        values.add(PieEntry ( 1506f, "Cat 3"))
        values.add(PieEntry ( 50f, "Cat 4"))
        values.add (PieEntry ( 2342f, "Max"))


        //create the dataset and place it on the graph
        val dataSet = PieDataSet(values,  "Set of values")

        dataSet.colors = ColorTemplate.MATERIAL_COLORS.asList()
        dataSet.valueTextSize = 12f
        dataSet.sliceSpace = 5f

        //pass it into its constructor
        val data = PieData(dataSet)

        //set the data
        pieChartVar.data = data
        pieChartVar.description.isEnabled = false //to give graph name -> enable true
        pieChartVar.animateXY(3500, 3500)




        //Navigate to Main Activity

        btnB2Main.setOnClickListener{
            val intentOne = Intent(this, MainActivity:: class.java)
            startActivity(intentOne)
        }



    }
}