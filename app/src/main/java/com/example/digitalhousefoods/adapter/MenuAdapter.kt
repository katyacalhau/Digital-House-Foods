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
import com.example.digitalhousefoods.model.MenuRestaurante
import com.example.digitalhousefoods.view.MenuDetalhes


class MenuAdapter (private val menuRestauranteList: MutableList<MenuRestaurante>):
        RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        val view = LayoutInflater.from (parent.context).inflate(R.layout.prato_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount() = menuRestauranteList.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

        val image: ImageView = holder.imageView
        image.setImageResource(menuRestauranteList[position].imgMenu)

        val nome = holder.nome
        nome.text = menuRestauranteList[position].nome

        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, MenuDetalhes::class.java)
            intent.putExtra("NOME", menuRestauranteList[position].nome)
            intent.putExtra("IMAGEM", menuRestauranteList[position].imgMenu)
            intent.putExtra("DESCRICAO", menuRestauranteList[position].descricao)
            it.context.startActivity(intent)

        }
    }

    inner class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome: TextView by lazy { view.findViewById<TextView>(R.id.textView) }
        val cardView: CardView by lazy { view.findViewById<CardView>(R.id.card_view_prato_menu) }
        val imageView: ImageView by lazy {view.findViewById<ImageView>(R.id.img_menu) }

    }
}