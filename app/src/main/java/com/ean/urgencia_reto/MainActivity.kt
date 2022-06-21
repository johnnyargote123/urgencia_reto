package com.ean.urgencia_reto


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val card_agregar_ambulacia=findViewById<CardView>(R.id.card_ingresar_ambulancia_card)
        card_agregar_ambulacia.setOnClickListener {
            val intent= Intent(this,ingresar_ambulancia::class.java)
            startActivity(intent)
        }

        val card_agregar_hospital=findViewById<CardView>(R.id.card_ingresar_nuevo_hospital_card)
        card_agregar_hospital.setOnClickListener {
            val intent= Intent(this,ingresar_hospital::class.java)
            startActivity(intent)
        }

        val card_actualizar_ambulancia=findViewById<CardView>(R.id.card_actualizar_ambulancia_card)
        card_actualizar_ambulancia.setOnClickListener {
            val intent= Intent(this,actualizar_ambulacia::class.java)
            startActivity(intent)
        }

        val card_agregar_accidente=findViewById<CardView>(R.id.card_informar_accidente_card)
        card_agregar_accidente.setOnClickListener {
            val intent= Intent(this,ingresar_informacion_accidente::class.java)
            startActivity(intent)
        }

        val card_dar_alta=findViewById<CardView>(R.id.card_dar_alta_paciente_card)
        card_dar_alta.setOnClickListener {
            val intent= Intent(this,dar_alta::class.java)
            startActivity(intent)
        }

        val card_mostrar_informacion=findViewById<CardView>(R.id.card_mostar_informacion_general_card)
        card_mostrar_informacion.setOnClickListener {
            val intent= Intent(this,mostrar_informacion::class.java)
            startActivity(intent)
        }

    }
}