package com.example.mealsuggester

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTime: EditText = findViewById(R.id.inputTime)
        val btnSuggest: Button = findViewById(R.id.btnSuggest)
        val btnReset: Button = findViewById(R.id.btnReset)
        val txtSuggestion: TextView = findViewById(R.id.txtSuggestion)
        val imgMeal: ImageView = findViewById(R.id.imgMeal)

        btnSuggest.setOnClickListener {
            val time = inputTime.text.toString().lowercase().trim()

            val meal = when (time) {
                "morning" -> Pair("Breakfast: Eggs", R.drawable.breakfast)
                "mid-morning" -> Pair("Snack: Fruit", R.drawable.snack)
                "afternoon" -> Pair("Lunch: Sandwich", R.drawable.lunch)
                "mid-afternoon" -> Pair("Snack: Cake", R.drawable.cake)
                "dinner" -> Pair("Dinner: Pasta", R.drawable.dinner)
                "after dinner" -> Pair("Dessert: Ice Cream", R.drawable.dessert)
                else -> Pair("Invalid time entered. Please try again!", 0)
            }

            txtSuggestion.text = meal.first
            if (meal.second != 0) imgMeal.setImageResource(meal.second)
        }

        btnReset.setOnClickListener {
            inputTime.text.clear()
            txtSuggestion.text = ""
            imgMeal.setImageResource(0)
        }
    }
}
