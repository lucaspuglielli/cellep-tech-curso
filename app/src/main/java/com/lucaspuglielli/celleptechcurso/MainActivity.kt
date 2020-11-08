package com.lucaspuglielli.celleptechcurso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("INTENT_EMAIL")

        var sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

        val nome = sharedPrefs.getString("NOME", "")
        val sobrenome = sharedPrefs.getString("SOBRENOME", "")
        val genero = sharedPrefs.getString("GENERO", "")

        txvMainNome.text = "$nome $sobrenome"
        txvMainEmail.text = email
        txvMainGenero.text = genero

        btnMainSair.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Atenção")
            alert.setMessage("Deseja mesmo sair?")
            alert.setPositiveButton("Sair") { _, _ ->
                val mIntent = Intent(this, LoginActivity::class.java)
                startActivity(mIntent)
                finishAffinity()
            }
            alert.setNeutralButton("Cancelar") { _, _ -> }
            alert.setCancelable(false)
            alert.show()
        }

        btnMainSite.setOnClickListener {
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }

    }
}