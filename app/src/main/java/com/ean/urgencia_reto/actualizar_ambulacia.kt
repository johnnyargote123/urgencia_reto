package com.ean.urgencia_reto

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class actualizar_ambulacia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_informacion_ambulancia)


        //Botones-----------------------------------------------------------------------------------

        val boton_volver = findViewById<ImageView>(R.id.Bn_back)



        // Funciones botones------------------------------------------------------------------------
        boton_volver.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}