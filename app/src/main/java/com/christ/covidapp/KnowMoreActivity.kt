package com.christ.covidapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_know_more.*

class KnowMoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_know_more)
/** ACTIVITE POUR PLUS D'INFO**/
        btnLearnMore.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.who.int/emergencies/diseases/novel-coronavirus-2019"))
                startActivity(intent) }

        btncarte.setOnClickListener{
            var intent = Intent (this@KnowMoreActivity,Carte::class.java)
            startActivity(intent)
        }


    }
}
