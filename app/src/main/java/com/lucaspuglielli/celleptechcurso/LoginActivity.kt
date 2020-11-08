package com.lucaspuglielli.celleptechcurso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLoginEntrar.setOnClickListener{
            val email = edtLoginEmail.text.toString().trim()
            val senha = edtLoginPassword.text.toString()

            if (email.isEmpty()) {
                edtLoginEmail.error = "Campo obrigatório"
                edtLoginEmail.requestFocus()
            }
            else if (senha.isEmpty()) {
                edtLoginPassword.error = "Campo obrigatório"
                edtLoginPassword.requestFocus()
            }
            else {

                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                val emailPrefs = sharedPrefs.getString("EMAIL", "")
                val senhaPrefs = sharedPrefs.getString("SENHA", "")

                if (email == emailPrefs && senha == senhaPrefs) {
                    Toast.makeText(this, "Usuário Logado", Toast.LENGTH_LONG).show()
                    val mIntent = Intent(this, MainActivity::class.java)

                    mIntent.putExtra("INTENT_EMAIL", email)

                    startActivity(mIntent)
                    finishAffinity()
                }
                else {
                    Toast.makeText(this, "Email ou Senha inválidos", Toast.LENGTH_LONG).show()
                }
            }
        }
        btnLoginCadastrar.setOnClickListener {
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)
        }
    }
}