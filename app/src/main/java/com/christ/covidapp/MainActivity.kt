package com.christ.covidapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /** AFFICHAGE DES DIFFERENTS SYMPTOMES EN RECYCLERVIEW VERTICALE**/
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        val symmtomesListe =ArrayList<SymptomsModel>()
        symmtomesListe.add(SymptomsModel(R.mipmap.couth,"toux seche","toux sèche souvent plus fréquente chez les personnes ayant déjà souffert de maladies respiratoires"))
        symmtomesListe.add(SymptomsModel(R.mipmap.fever,"Fievre","augmentation de la température corporelle"))
        symmtomesListe.add(SymptomsModel(R.mipmap.fatigue,"fatigue","présence d'une fatigue intense sans effort préalable"))
        symmtomesListe.add(SymptomsModel(R.mipmap.nose,"ecoulement nasal","vous avez des liquides qui sortent de vos nez"))

        val symptomesAdapter = SymptomsAdapter(symmtomesListe)
        recyclerView.adapter= symptomesAdapter


        /** AFFICHAGE DES DIFFERENTS MOYENS DE PRECAUTION EN RECYCLERVIEW VERTICALE**/
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        val precautionListe =ArrayList<Model>()
        precautionListe.add(Model(R.mipmap.cover,"masque","blablablabalblablablablablablablablablablabla"))
        precautionListe.add(Model(R.mipmap.distance,"distance de securité","blablablabalblablablablablablablablablablabla"))
        precautionListe.add(Model(R.mipmap.home,"rester confiner","blablablabalblablablablablablablablablablabla"))
        precautionListe.add(Model(R.mipmap.hand,"laver les mains","blablablabalblablablablablablablablablablabla"))

        val precautionAdapter = PrecautionAdapter(precautionListe)
        recyclerViewPrecaution.adapter= precautionAdapter
        /** BUTTON POUR LIRE PLUS D'INFO**/
        btnKnowMore.setOnClickListener{
            var intent = Intent (this@MainActivity,KnowMoreActivity::class.java)
            startActivity(intent)
        }
        /** BUTTON POUR LIRE PLUS DE SYMPTOME**/
        viewSymptom.setOnClickListener{
            var intent = Intent (this@MainActivity,SymptomActivity::class.java)
            startActivity(intent)
        }

        /** BUTTON POUR LIRE PLUS DE PRECAUTION **/
        viewPrecaution.setOnClickListener{
            var intent = Intent (this@MainActivity,PrecautionActivity::class.java)
            startActivity(intent)
        }

        getGlobalData()

    }
    /** METHODE POUR GENERER LES NOMBRE DE CAS , MORTS ET GUERRIE DU COVID EN TEMP REEL**/
    fun getGlobalData(){
        var url: String  ="https://corona.lmao.ninja/v2/all"

        var StringRequest = StringRequest(Request.Method.GET,
            url,

                Response.Listener<String> {
                    var jsonObject=  JSONObject(it.toString())
                    txtinfecté.text= jsonObject.getString("cases")
                    txtrecovered.text = jsonObject.getString("recovered")
                    txtdeceased.text = jsonObject.getString("deaths")

                },
                Response.ErrorListener {
                  Toast.makeText(this@MainActivity,"Erreur",Toast.LENGTH_LONG).show()
                    txtinfecté.text= "-"
                    txtrecovered.text = "-"
                    txtdeceased.text = "-"

                  }
        )

   var requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(StringRequest)


    }
}
