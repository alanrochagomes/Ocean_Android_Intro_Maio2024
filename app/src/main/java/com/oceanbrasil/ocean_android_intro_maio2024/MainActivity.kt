package com.oceanbrasil.ocean_android_intro_maio2024

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buscar o Botão pelo ID
        // <> -> Informa o tipo da informação que queremos obter
        // () -> Informa o ID do elemento que está no layout XML
        //    Obtemos o ID usando a declaração R.id.
        // val ou var
        // val -> uma variável que não muda o seu valor depois de inicializada
        // var -> uma variável que pode mudar o valor depois de inicializada
        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etNome = findViewById<EditText>(R.id.etNome)

        btEnviar.setOnClickListener {
            // Dentro desse bloco { }, o código só
            // será executado quando o botão for clicado
            val nome = etNome.text

            if (nome.isBlank()) {
                // Exibimos a mensagem de erro
                etNome.error = "Digite o seu nome"
            } else {
                tvResultado.text = nome
            }
        }

        // Abrir Nova Tela
        val btAbrirNovaTela = findViewById<Button>(R.id.btAbrirNovaTela)
        btAbrirNovaTela.setOnClickListener {
            val resultadoActivityIntent = Intent(this, ResultadoActivity::class.java)

            resultadoActivityIntent.putExtra("NOME_DIGITADO", etNome.text.toString())

            startActivity(resultadoActivityIntent)
        }
    }
}
