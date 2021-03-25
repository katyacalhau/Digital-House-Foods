package com.example.digitalhousefoods.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.model.MenuRestaurante

class MenuDetalhes : AppCompatActivity() {

    val nome_menu by lazy { findViewById<TextView>(R.id.tv_menu) }
    val descricao_menu by lazy { findViewById<TextView>(R.id.tv_desc) }
    val imagem_menu by lazy { findViewById<ImageView>(R.id.img_menu) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_detalhes)

        val info = intent.extras

        val nome = info?.getString("NOME")
        val descricao = info?.getString("MENU")
        val imagem = info?.getInt("IMAGEM")

        if (nome != null && descricao != null && imagem != null) {
        val menu = MenuRestaurante(nome, descricao, imagem)

        nome_menu.text = menu.nome
        descricao_menu.text = menu.descricao
        imagem_menu.setImageResource(imagem)}
    }
}