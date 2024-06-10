package com.example.charts_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class Dynamic_PieChart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_pie_chart)


        //Declare && Assign Variables
        //val name : Type = findViewById(R.id)

        val pieChart : PieChart = findViewById(R.id.pieChartTwo)
        val buttonPlot: Button =  findViewById(R.id.btnPlot)
        val ed1 : EditText =  findViewById(R.id.editTextText)
        val ed2 : EditText =  findViewById(R.id.editTextText2)
        val ed3 : EditText =  findViewById(R.id.editTextText3)
        val ed4 : EditText =  findViewById(R.id.editTextText4)

        val btnB2Main : Button = findViewById(R.id.btnB2Main)


        //BTN Click event-> PLOT -> Draw
        buttonPlot.setOnClickListener{

            //create an object of arraylist
            val values = ArrayList<PieEntry>()

            //to add items or Slices onto the graph --> .add
            values.add(PieEntry(ed1.text.toString().toFloatOrNull() ?: 0f, "Cat 1"))
            values.add(PieEntry(ed2.text.toString().toFloatOrNull() ?: 0f, "Cat 2"))
            values.add(PieEntry(ed3.text.toString().toFloatOrNull() ?: 0f, "Cat 3"))
            values.add(PieEntry(ed4.text.toString().toFloatOrNull() ?: 0f, "Cat 4"))


            //create the dataset and place it on the graph
            val dataSet = PieDataSet(values, "Task 3")

            dataSet.colors = ColorTemplate.MATERIAL_COLORS.asList()
            dataSet.valueTextSize = 12f
            dataSet.sliceSpace = 5f

            //pass it into its constructor
            val data = PieData(dataSet)

            //set the data
            pieChart.data = data
            pieChart.animateXY(4000,4000)

        }//end_Btn_Click



        //Navigate to Main Activity

        btnB2Main.setOnClickListener{
            val intentOne = Intent(this, MainActivity:: class.java)
            startActivity(intentOne)
        }



    }
}