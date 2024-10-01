package br.unipar.adapter

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val listaDePlantas = mutableListOf<Plantas>()
    private var contagemPlantas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edPlanta = findViewById<EditText>(R.id.edPlanta)
        val edCuidado = findViewById<EditText>(R.id.edCuidado)
        val edAgua = findViewById<EditText>(R.id.edAgua)
        val edDate = findViewById<EditText>(R.id.edDate)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val listView = findViewById<ListView>(R.id.listViewAlunos)
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val btnZerar = findViewById<Button>(R.id.btnZerar)

        val adapter = ListaAdapter(this, listaDePlantas)
        listView.adapter = adapter

        btnInserir.setOnClickListener {
            val nomePlanta = edPlanta.text.toString()
            val cuidado = edCuidado.text.toString()
            val agua = edAgua.text.toString()
            val date = edDate.text.toString()

            //val dataAtual = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

            if (nomePlanta.isNotEmpty() && cuidado.isNotEmpty() &&agua.isNotEmpty() &&date.isNotEmpty()) {
                val novaPlanta = Plantas(nomePlanta, cuidado, agua, date)
                listaDePlantas.add(novaPlanta)
                contagemPlantas++
                adapter.notifyDataSetChanged()

                Log.d("MainActivity", "Planta adicionada: ${novaPlanta.nome}")
                resultado.text = "Quantidade de Plantas: $contagemPlantas"
                edPlanta.text.clear()
                edCuidado.text.clear()
                edAgua.text.clear()
                edDate.text.clear()
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        btnZerar.setOnClickListener {
            listaDePlantas.clear()
            adapter.notifyDataSetChanged()
            contagemPlantas = 0
            resultado.text = "Quantidade de Plantas: $contagemPlantas"
            edPlanta.text.clear()
            edCuidado.text.clear()
            edAgua.text.clear()
            edDate.text.clear()
            Toast.makeText(this, "Lista zerada", Toast.LENGTH_SHORT).show()
        }
    }
}

