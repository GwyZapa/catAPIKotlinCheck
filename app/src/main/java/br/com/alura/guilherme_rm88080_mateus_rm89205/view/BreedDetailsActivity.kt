package br.com.alura.guilherme_rm88080_mateus_rm89205.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.guilherme_rm88080_mateus_rm89205.R
import br.com.alura.guilherme_rm88080_mateus_rm89205.models.CatBreed

class BreedDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_details) // Use o layout que você criou
        val name = intent.getStringExtra("name")
        val temperament = intent.getStringExtra("temperament")
        val origin = intent.getStringExtra("origin")
        val life_span = intent.getStringExtra("life_span")
        // Recupere os dados da raça da Intent
        val catBreed: CatBreed? = intent.getParcelableExtra("catBreedKey")

        if (catBreed != null) {
            val nameTextView = findViewById<TextView>(R.id.breedNameTextView)
            val temperamentTextView = findViewById<TextView>(R.id.temperamentTextView)
            val originTextView = findViewById<TextView>(R.id.originTextView)
            val lifeSpanTextView = findViewById<TextView>(R.id.lifeSpanTextView)


            nameTextView.text = name
            temperamentTextView.text = temperament
            originTextView.text = origin
            lifeSpanTextView.text = life_span
        } else {
            // Lide com o caso em que o objeto CatBreed é nulo
        }
    }
}
