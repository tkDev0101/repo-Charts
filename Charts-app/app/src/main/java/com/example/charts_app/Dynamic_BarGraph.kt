package com.example.charts_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class Dynamic_BarGraph : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_bar_graph)



        //Declare && Assign Variables
        //val name : Type = findViewById(R.id)

        val edText1 : EditText = findViewById(R.id.edOne)
        val edText2 : EditText = findViewById(R.id.edTwo)
        val edText3 : EditText = findViewById(R.id.edThree)
        val edText4 : EditText = findViewById(R.id.edFour)

        val edTextSpinner : EditText = findViewById(R.id.edSpinner)
        val btnChart : Button = findViewById(R.id.btnChart)
        val spinner : Spinner = findViewById(R.id.spinner)

        val btnB2Main : Button = findViewById(R.id.btnB2Main)



        //ArrayList to hold spinner values
        val spinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mutableListOf())

        //setting the drop down view for the spinner
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //save to adapter
        spinner.adapter = spinnerAdapter


        //BTN Click event-> Chart
        btnChart.setOnClickListener{

            val data1 = edText1.text.toString().toFloat()
            val data2 = edText2.text.toString().toFloat()
            val data3 = edText3.text.toString().toFloat()
            val data4 = edText4.text.toString().toFloat()
            val newData = edTextSpinner.text.toString()

            if(newData.isNotBlank())
            {
                spinnerAdapter.add(newData)
                spinnerAdapter.notifyDataSetChanged()
            }

            //nb        x, y
            val barEntries = arrayListOf(   BarEntry(0f, data1),
                BarEntry(1f, data2),
                BarEntry(2f, data3),
                BarEntry(3f, data4) )

            //now pass the info onto the chart design box

            //creates a bar dataset object
            val barDataSet = BarDataSet(barEntries, "Data")

            //pass it into its constructor
            val barData = BarData(barDataSet)

            // retrieve the design from the xml
            val chart = findViewById<BarChart>(R.id.barChart)

            //set the data
            chart.data = barData

            //clears the chart every time the data set changes
            // and redraws itself
            chart.invalidate()

        }//end_btn_click




        //Navigate to Main Activity

        btnB2Main.setOnClickListener{
            val intentOne = Intent(this, MainActivity:: class.java)
            startActivity(intentOne)
        }




    }
}