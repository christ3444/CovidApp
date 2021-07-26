package com.christ.covidapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SymptomsAdapter(var symptomesListe: ArrayList<SymptomsModel>): RecyclerView.Adapter<SymptomsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomsAdapter.ViewHolder {

        val inflater= LayoutInflater.from(parent.context)
        return  ViewHolder(inflater,parent)

    }

    override fun getItemCount(): Int {
return symptomesListe.size
    }

    override fun onBindViewHolder(holder: SymptomsAdapter.ViewHolder, position: Int) {

       val symptomsModel = symptomesListe[position]
        holder.bind(symptomsModel)

    }
    class ViewHolder(inflater: LayoutInflater,viewGroup: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_symptomes,viewGroup,false)){

        fun bind(symptomsModel: SymptomsModel){

            val symptomsText= itemView.findViewById<TextView>(R.id.txtsymptomes)
            val symptomsDetail=itemView.findViewById<TextView>(R.id.txtsymptomesDetails)
            val imageView = itemView.findViewById<ImageView>(R.id.imageView)

            imageView.setImageResource(symptomsModel.imageView)
            symptomsText.text=  symptomsModel.symptomsText
            symptomsDetail.text=  symptomsModel.symptomsDetails
        }

    }








}