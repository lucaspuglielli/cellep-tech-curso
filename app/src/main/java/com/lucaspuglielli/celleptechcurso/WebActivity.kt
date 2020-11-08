package com.lucaspuglielli.celleptechcurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        wbvWeb.settings.javaScriptEnabled = true

        wbvWeb.loadUrl("http://br.cellep.com/estacaohack/")

        wbvWeb.webViewClient = WebViewClient()

    }
}