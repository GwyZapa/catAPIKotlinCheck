import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import br.com.alura.guilherme_rm88080_mateus_rm89205.models.CatModel
import br.com.alura.guilherme_rm88080_mateus_rm89205.R
import android.content.Context  // Importe o contexto
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import br.com.alura.guilherme_rm88080_mateus_rm89205.models.CatBreed
import br.com.alura.guilherme_rm88080_mateus_rm89205.view.BreedDetailsActivity

// ...

class CatAdapter(private val catList: List<CatModel>) :
    RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view)
    }

    override fun getItemCount(): Int = catList.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = catList[position]
        holder.bind(cat)
    }

    inner class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var context: Context

        val catImageView: ImageView = itemView.findViewById(R.id.catImageView)
        val breedNameTextView: TextView = itemView.findViewById(R.id.breedNameTextView)  // TextView para exibir o nome da raça

        fun bind(cat: CatModel) {
            // Use a biblioteca Picasso para carregar a imagem da URL em um ImageView
            Picasso.get()
                .load(cat.url)
                .placeholder(R.drawable.placeholder) // Use um placeholder se desejar
                .error(R.drawable.error) // Use uma imagem de erro se ocorrer um erro no carregamento
                .into(catImageView)

            if (cat.breeds.isNotEmpty()) {
                Log.d("CatAdapter", "Cat Breed ID: ${cat.breeds[0].id}")
                breedNameTextView.text = cat.breeds[0].name
            } else {
                breedNameTextView.text = "Raça desconhecida"  // Se a lista de raças estiver vazia
            }


            // Use itemView.context para obter o contexto
            catImageView.setOnClickListener {
                if (cat.breeds.isNotEmpty()) {
                    val catBreed = cat.breeds[0] // Obtenha a raça do gato da fonte de dados

                    val breedDetailsIntent = Intent(itemView.context, BreedDetailsActivity::class.java)

                    // Passe os dados da raça para a próxima atividade usando putExtra
                    breedDetailsIntent.putExtra("name", catBreed.name)
                    breedDetailsIntent.putExtra("temperament", catBreed.temperament)
                    breedDetailsIntent.putExtra("origin", catBreed.origin)
                    breedDetailsIntent.putExtra("life_span", catBreed.life_span)

                    // Inicie a nova atividade
                    itemView.context.startActivity(breedDetailsIntent)
                }
            }


        }
    }
}
