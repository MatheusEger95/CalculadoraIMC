package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RECUPERAR OS COMPONENTES EDITTEXT
        // Criar uma variavel e associar (=)o componente de UI
        // Recuperar botao da tela
        // Recuperar o texto digitado no edt peso

        val edtpeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtaltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btncalcular = findViewById<Button>(R.id.btn_calcular)

        btncalcular.setOnClickListener {

            val pesoStr: String = edtpeso.text.toString()
            val alturaStr: String = edtaltura.text.toString()

            if (pesoStr == "" || alturaStr == "" ) {
                // Mostrar mensagem para o usuario

                Snackbar
                    .make(
                      edtpeso,
                     "Preecha todos os campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()

            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2

                // Navegar para proxima tela
                // Criar layout da proxima tela
                // Passar dados para a proxima tela ( resultado )

                // Intent - Classe do proprio android

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, resultado)
                startActivity(intent)

                // Cores
                // EditText background + Icone
                // Gradiente + icone + titulo + descricao
            }
        }
    }
}