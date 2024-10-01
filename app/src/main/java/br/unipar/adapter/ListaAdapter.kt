package br.unipar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListaAdapter(private val context: Context,
                   private val listaPlantas: MutableList<Plantas>) :
    ArrayAdapter<Plantas>(context, 0, listaPlantas) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_plantas, parent, false)

        val planta = listaPlantas[position]

        val txtAgua = view.findViewById<TextView>(R.id.txtAguaTotal)
        val txtPlantas = view.findViewById<TextView>(R.id.txtPlantas)
        val txtCuidados = view.findViewById<TextView>(R.id.txtPlantasCuidado)
        val txtData = view.findViewById<TextView>(R.id.txtData)

        txtPlantas.text = planta.nome
        txtCuidados.text = planta.cuidados
        txtData.text = planta.agua
        txtAgua.text = planta.date

        return view
    }
}
