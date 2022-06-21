package com.ean.urgencia_reto

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ingresar_ambulancia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_informacion_ambulancia)


        //Botones-----------------------------------------------------------------------------------

        val boton_volver = findViewById<ImageView>(R.id.Bn_back)
    


        // Funciones botones------------------------------------------------------------------------
        boton_volver.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}