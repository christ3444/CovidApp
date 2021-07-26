package com.christ.covidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class PrecautionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precaution)



        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val precautionListe =ArrayList<Model>()
        precautionListe.add(Model(R.mipmap.cover,"masque","blablablabalblablablablablablablablablablabla"))
        precautionListe.add(Model(R.mipmap.distance,"distance de securité","blablablabalblablablablablablablablablablabla"))
        precautionListe.add(Model(R.mipmap.home,"rester confiner","blablablabalblablablablablablablablablablabla"))
        precautionListe.add(Model(R.mipmap.hand,"laver les mains","blablablabalblablablablablablablablablablabla"))

        val precautionAdapter = PrecautionAdapter(precautionListe)
        recyclerView.adapter= precautionAdapter

    }
}
