package br.com.alura.guilherme_rm88080_mateus_rm89205.view

import CatAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.guilherme_rm88080_mateus_rm89205.R
import br.com.alura.guilherme_rm88080_mateus_rm89205.viewmodel.CatViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val catViewModel = CatViewModel(application)


        val btnGetCats = findViewById<Button>(R.id.btnGetCats)
        btnGetCats.setOnClickListener {
            val apiKey = "live_eqTciCIVivLvdJYupaTiB4Wg4KS3KYS0wwJyc1uwqVI5JbG1WjhBBSXHngNOhZql" // Substitua pela sua chave de API
            val limit = 10 // Defina o limite desejado

            // Usando uma coroutine para chamar a função suspensa
            CoroutineScope(Dispatchers.Main).launch {
                catViewModel.getCats(apiKey, limit)
            }        }

        catViewModel.cats.observe(this, Observer { cats ->
            cats?.let { catList ->
                val recyclerViewCats = findViewById<RecyclerView>(R.id.recyclerViewCats)

                val catAdapter = CatAdapter(catList) // Suponha que você tenha um adaptador (CatAdapter) para o RecyclerView
                recyclerViewCats.adapter = catAdapter
            }
        })

    }
}
