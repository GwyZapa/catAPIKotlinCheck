package br.com.alura.guilherme_rm88080_mateus_rm89205.models
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class CatModel(
    val id: String,
    val url: String,
    val breeds: List<CatBreed>
)

@Parcelize
data class CatBreed(
    val id: String,
    val name: String,
    val temperament: String,
    val origin: String,
    val life_span: String,
    val wikipedia_url: String
): Parcelable
