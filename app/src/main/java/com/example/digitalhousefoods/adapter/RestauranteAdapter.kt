package com.example.digitalhousefoods.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.model.Restaurante
import com.example.digitalhousefoods.view.RestauranteDetalhes
import java.io.Serializable

class RestauranteAdapter (private val listaRestaurante: MutableList<Restaurante>):
        RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteAdapter.RestauranteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurante_item, parent,false)
        return RestauranteViewHolder(view)
    }

    override fun getItemCount() = listaRestaurante.size

    override fun onBindViewHolder(holder: RestauranteAdapter.RestauranteViewHolder, position: Int) {

        val image = holder.imageView
        image.setImageResource(listaRestaurante[position].imagemRest)

        val nome = holder.nome
        nome.text = listaRestaurante[position].nome

        val endereco = holder.endereco
        endereco.text = listaRestaurante[position].endereco

        val horario = holder.horario
        horario.text = listaRestaurante[position].horario


        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, RestauranteDetalhes::class.java)
            intent.putExtra("NOME", listaRestaurante[position].nome)
            intent.putExtra("IMAGEM", listaRestaurante [position].imagemRest)
            intent.putExtra("MENU", listaRestaurante [position].menu as Serializable)
            it.context.startActivity(intent)
        }
    }




    inner class RestauranteViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nome by lazy { view.findViewById<TextView>(R.id.tv_nome) }
        val endereco by lazy { view.findViewById<TextView>(R.id.tv_endereco) }
        val horario by lazy { view.findViewById<TextView>(R.id.tv_horario) }
        val cardView by lazy { view.findViewById<CardView>(R.id.card_view_restaurante) }
        val imageView by lazy { view.findViewById<ImageView>(R.id.imageView) }

    }
}
