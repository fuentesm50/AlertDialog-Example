package com.example.jesusflistas

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.app.AlertDialog
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
//import android.widget.Toast


class MainActivity : AppCompatActivity() {

    var arreglo = arrayOf("JESUS", "RICARDO", "JESSICA", "JOANNA", "MARCELO", "NELLY")


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this,
            R.layout.lista_item, arreglo)

        val VistaLista:ListView = findViewById(R.id.listadetalle)
        VistaLista.setAdapter(adapter)

        VistaLista.onItemClickListener = object : OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {

                // valor del elemento en el que se hace clic
                val itemValor = VistaLista.getItemAtPosition(position) as String

                //mensaje toast
                /*Toast.makeText(applicationContext,
                    "Nombre : $itemValue", Toast.LENGTH_LONG)
                    .show()*/

                // Valores del dialog
                    val dialogo = AlertDialog.Builder(this@MainActivity)

                    dialogo.setMessage("\n $itemValor")

                        //.setIcon(android.R.drawable.ic_dialog_alert)
                        .setIcon(R.mipmap.iconlista)
                        .setCancelable(false)
                        .setNegativeButton("Aceptar", DialogInterface.OnClickListener {
                            dialog, id -> dialog.cancel()
                    })

                //Creando el dialogo
                    val alert = dialogo.create()
                    alert.setTitle("Selección de la Lista")
                    alert.show()
                }
        }
    }
}