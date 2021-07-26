package com.christ.covidapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PrecautionAdapter(var liste: ArrayList<Model>): RecyclerView.Adapter<PrecautionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrecautionAdapter.ViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        return  ViewHolder(inflater,parent)

    }

    override fun getItemCount(): Int {
return liste.size
    }

    override fun onBindViewHolder(holder: PrecautionAdapter.ViewHolder, position: Int) {

       val symptomesModel = liste[position]
        holder.bind(symptomesModel)

    }
    class ViewHolder(inflater: LayoutInflater,viewGroup: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_precaution,viewGroup,false)){

        fun bind(model: Model){

            val precautionText= itemView.findViewById<TextView>(R.id.txtprecaution)
            val imageView= itemView.findViewById<ImageView>(R.id.imageView)
      imageView.setImageResource(model.imageView)
            precautionText.text=  model.precautionText
        }


    }








}