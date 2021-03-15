package com.example.digitalhousefoods.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.digitalhousefoods.R
import com.google.android.material.textfield.TextInputEditText

class CadastroActivity : AppCompatActivity() {

    val txt_email: TextInputEditText by lazy { findViewById<TextInputEditText>(R.id.txt_email) }
    val txt_senha: TextInputEditText by lazy { findViewById<TextInputEditText>(R.id.txt_senha) }
    val btn_cadastrar: Button by lazy { findViewById<Button>(R.id.btn_cadastrar) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        btn_cadastrar.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}