package com.example.digitalhousefoods.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R

class RestauranteDetalhes : AppCompatActivity() {

    val recycler by lazy { findViewById<RecyclerView>(R.id.rv_menu) }
    val nome_restaurante by lazy { findViewById<TextView>(R.id.tv_restaurant) }
    val imagem_restaurante by lazy { findViewById<ImageView>(R.id.img_restaurant) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante_detalhes)

        val info = intent.extras
        val menu = info?.getSerializable("MENU") as MutableList<Menu>
        val nome = info.getString("NOME")
        val imagem = info.getInt("IMAGEM")


        if (nome!=null && imagem != null){
        nome_restaurante.text = nome
        imagem_restaurante.setImageResource(imagem)}

        recycler.layoutManager = GridLayoutManager(this,2)

        val adapter = com.example.digitalhousefoods.adapter.MenuAdapter (menu)
        recycler.adapter = adapter

    }
}