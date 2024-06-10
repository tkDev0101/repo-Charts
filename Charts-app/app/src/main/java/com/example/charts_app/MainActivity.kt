package com.example.charts_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //VARIABLES
    lateinit var btnStaticPie: Button
    lateinit var btnDynamicPie: Button
    lateinit var btnBarGraph: Button
    lateinit var btnLineGraph: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //TYPECASTING -> Linked to design XML
        btnBarGraph = findViewById(R.id.btnDynamicBar)
        btnLineGraph = findViewById(R.id.btnDynamicLine)
        btnDynamicPie  = findViewById(R.id.btnDynamicPie)
        btnStaticPie = findViewById(R.id.btnStaticPie)


        //Declare && Assign Variables
        //val name : Type = findViewById(R.id)


        //Navigate to Dynamic Bar Graph Activity

        btnBarGraph.setOnClickListener{
            val intentOne = Intent(this, Dynamic_BarGraph:: class.java)
            startActivity(intentOne)
        }


        //Navigate to Dynamic Line Chart Activity

        btnLineGraph.setOnClickListener{
            val intentOne = Intent(this, Dynamic_LineChart:: class.java)
            startActivity(intentOne)
        }


        //Navigate to Dynamic Pie Chart Activity

        btnDynamicPie.setOnClickListener{
            val intentOne = Intent(this, Dynamic_PieChart:: class.java)
            startActivity(intentOne)
        }


        //Navigate to Static Pie Chart Activity

        btnStaticPie.setOnClickListener{
            val intentOne = Intent(this, Static_PieChart:: class.java)
            startActivity(intentOne)
        }






    }
}