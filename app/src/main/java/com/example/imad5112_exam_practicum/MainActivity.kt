package com.example.imad5112_exam_practicum

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {

    private lateinit var splashLayout: LinearLayout
    private lateinit var main: ScrollView
    private lateinit var detailsLayout: ScrollView

    private lateinit var txtTotal: TextView
    private lateinit var txtDetails: TextView

    private lateinit var editItem: EditText
    private lateinit var editCategory: EditText
    private lateinit var editQuantity: EditText

    private lateinit var spinnerGear: Spinner

    private val items = arrayOf(
        "Tent", "Lighter", "Marshmallow", "Flashlight", "Cookies"
    )

    private val Total = IntArray(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        splashLayout = findViewById(R.id.splash_Layout)
        main = findViewById(R.id.main)
        detailsLayout = findViewById(R.id.detailsLayout)

        txtTotal = findViewById(R.id.txtTotal)
        txtDetails = findViewById(R.id.txtDetails)

        editItem = findViewById(R.id.editItem)
        editCategory = findViewById(R.id.editCategory)
        editQuantity = findViewById(R.id.editQuantity)

        spinnerGear = findViewById(R.id.spinnerGear)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            items
        )

        spinnerGear.adapter = adapter

        //Buttons
        val btnWelcome = findViewById<Button>(R.id.btnWelcome)
        val btnNext = findViewById<Button>(R.id.btnExitSplash)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnAddGear = findViewById<Button>(R.id.btnAddGear)
        val btnTotal = findViewById<Button>(R.id.btnTotal)

        val btnDetails = findViewById<Button>(R.id.btnDetails)
        val btnBack = findViewById<Button>(R.id.btnBack)

        //Splash Screen Navigation
        btnWelcome.setOnClickListener {
            splashLayout.visibility = View.GONE
            main.visibility = View.VISIBLE
        }

        btnNext.setOnClickListener {
            finish()
        }

        //Save Data
        btnSave.setOnClickListener {
            if (editItem.text.isEmpty() ||
                editCategory.text.isEmpty() ||
                editQuantity.text.isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Please fill in all the fields",
                    Toast.LENGTH_LONG
                ).show()
            } else {

                val index = spinnerGear.selectedItemPosition

                editItem[index] = editItem.text.toString().toInt()
                editCategory[index] = editCategory.text.toString().toInt()
                editQuantity[index] = editQuantity.text.toString().toInt()

                Toast.makeText(
                    this,
                    "Data Saved Successfully",
                    Toast.LENGTH_LONG
                ).show()

                editItem.text.clear()
                editCategory.text.clear()
                editQuantity.text.clear()
            }
        }

        //Calculate Total
        btnTotal.setOnClickListener {

            var total = 0

            for (i in editItem.indices) {
                total += editItem[i]
            }

            val sumtotal = editItem.textSize

            txtTotal.text = "The Total Items Packed: $sumtotal"
        }

        //View Details
        btnDetails.setOnClickListener {
            var display = ""

            for (i in items.indices)
                display += "${items[i]}\n"
            display += "Items: ${editItem[i]}\n"
            "Category: ${editCategory[i]}\n"
            "Quantity: ${editQuantity[i]}\n\n"
        }

        txtDetails.text = display

        main.visibility = View.GONE
        detailsLayout.visibility = View.VISIBLE

    }
        //Back Button
        btnBack.setOnClickListener {
            detailsLayout.visibility = View.GONE
            main.visibility = View.VISIBLE
        }

        //Save Data
    btnAddGear.setOnClickListener
    {
            for (i in editItem.indices) {
            editItem[i] = 0
            editCategory[i] = 0
            editQuantity[i] = ""
        }
        txtTotal.text = "Th e Total Items Packed"

        Toast.makeText(
            this,
            "Data Cleared",
            Toast.LENGTH_SHORT
        ).show()
    }

        //Exit App
        btnBack.setOnClickListener {
            finish()
        }
    }
}