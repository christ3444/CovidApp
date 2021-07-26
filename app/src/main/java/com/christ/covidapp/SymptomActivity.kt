package com.christ.covidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class SymptomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptom)


        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val symmtomesListe =ArrayList<SymptomsModel>()
        symmtomesListe.add(SymptomsModel(R.mipmap.couth,"toux seche","toux sèche souvent plus fréquente chez les personnes ayant déjà souffert de maladies respiratoires"))
        symmtomesListe.add(SymptomsModel(R.mipmap.fever,"Fievre","augmentation de la température corporelle"))
        symmtomesListe.add(SymptomsModel(R.mipmap.fatigue,"fatigue","présence d'une fatigue intense sans effort préalable"))
        symmtomesListe.add(SymptomsModel(R.mipmap.nose,"ecoulement nasal","vous avez des liquides qui sortent de vos nez"))

        val symptomesAdapter = SymptomsAdapter(symmtomesListe)
        recyclerView.adapter= symptomesAdapter

    }
}
