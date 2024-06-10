package com.example.charts_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class Dynamic_LineChart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_line_chart)


        //Declare && Assign Variables
        //val name : Type = findViewById(R.id)

        val lineChart : LineChart = findViewById(R.id.lineChart)
        val buttonPlot: Button =  findViewById(R.id.btnPlot)
        val ed1 : EditText =  findViewById(R.id.editTextText)
        val ed2 : EditText =  findViewById(R.id.editTextText2)
        val ed3 : EditText =  findViewById(R.id.editTextText3)
        val ed4 : EditText =  findViewById(R.id.editTextText4)

        val btnB2Main : Button = findViewById(R.id.btnB2Main)



        //BTN Click event-> PLOT -> Draw
        buttonPlot.setOnClickListener{

            //create an object of arraylist
            val entries = ArrayList<Entry>()

            //to add items or Slices onto the graph --> .add
            entries.add(Entry(1f, ed1.text.toString().toFloatOrNull() ?: 0f ))
            entries.add(Entry(2f, ed2.text.toString().toFloatOrNull() ?: 0f ))
            entries.add(Entry(3f, ed3.text.toString().toFloatOrNull() ?: 0f ))
            entries.add(Entry(4f, ed4.text.toString().toFloatOrNull() ?: 0f ))


            //create the dataset and place it on the graph
            val dataSet = LineDataSet(entries, "ICE Task")

            /*
                        dataSet.colors = ColorTemplate.MATERIAL_COLORS.asList()
                        dataSet.valueTextSize = 12f
                        dataSet.sliceSpace = 5f
            */

            //pass it into its constructor
            val data = LineData(dataSet)

            //set the data
            lineChart.data = data
            lineChart.animateXY(4000,4000)

        }//end_Btn_Click


        //Navigate to Main Activity

        btnB2Main.setOnClickListener{
            val intentOne = Intent(this, MainActivity:: class.java)
            startActivity(intentOne)
        }



    }
}