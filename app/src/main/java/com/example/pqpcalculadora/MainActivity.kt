package com.example.pqpcalculadora

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* Constantes */
        val pi = Math.PI
        val euler = Math.E

        /* Variáveis */
        var memoria = 0.0


        /* Imports Botões */
        val displayNumberHistory = findViewById<TextView>(R.id.display_number_history)
        val displayNumber = findViewById<TextView>(R.id.display_number)

        val btMC = findViewById<MaterialButton>(R.id.btMC)
        val btMR = findViewById<MaterialButton>(R.id.btMR)
        val btMmais = findViewById<MaterialButton>(R.id.btMmais)
        val btMmenos = findViewById<MaterialButton>(R.id.btMmenos)

        val btTrig = findViewById<MaterialButton>(R.id.bttrig)
        val btFunc = findViewById<MaterialButton>(R.id.btFunc)

        val bt2nd = findViewById<MaterialButton>(R.id.bt2nd)
        val btPi = findViewById<MaterialButton>(R.id.btpi)
        val btEuler = findViewById<MaterialButton>(R.id.bteuler)
        val btCE = findViewById<MaterialButton>(R.id.btCE)
        val btC = findViewById<MaterialButton>(R.id.btc)

        val btXquadrado = findViewById<MaterialButton>(R.id.btxquadrado)
        val bt1sobrex = findViewById<MaterialButton>(R.id.btumsobrex)
        val btAbs = findViewById<MaterialButton>(R.id.btabs)
        val btExp = findViewById<MaterialButton>(R.id.btexp)
        val btMod = findViewById<MaterialButton>(R.id.btmod)

        val btRaiz = findViewById<MaterialButton>(R.id.btraiz)
        val btPaberto = findViewById<MaterialButton>(R.id.btpaberto)
        val btPfechado = findViewById<MaterialButton>(R.id.btpfechado)
        val btFatorial = findViewById<MaterialButton>(R.id.btfatorial)
        val btDiv = findViewById<MaterialButton>(R.id.btdiv)

        val btPotencia = findViewById<MaterialButton>(R.id.btpotencia)
        val bt7 = findViewById<MaterialButton>(R.id.bt7)
        val bt8 = findViewById<MaterialButton>(R.id.bt8)
        val bt9 = findViewById<MaterialButton>(R.id.bt9)
        val btVezes = findViewById<MaterialButton>(R.id.btvezes)

        val btNotacao = findViewById<MaterialButton>(R.id.btnotacao)
        val bt4 = findViewById<MaterialButton>(R.id.bt4)
        val bt5 = findViewById<MaterialButton>(R.id.bt5)
        val bt6 = findViewById<MaterialButton>(R.id.bt6)
        val btMenos = findViewById<MaterialButton>(R.id.btmenos)

        val bt1 = findViewById<MaterialButton>(R.id.bt1)
        val bt2 = findViewById<MaterialButton>(R.id.bt2)
        val bt3 = findViewById<MaterialButton>(R.id.bt3)
        val btSoma = findViewById<MaterialButton>(R.id.btsoma)

        val bt0 = findViewById<MaterialButton>(R.id.bt0)
        val btVirgula = findViewById<MaterialButton>(R.id.btvirgula)
        val btResultado = findViewById<MaterialButton>(R.id.btresultado)

        /* Botões de memoria */

        btMC.listener




    }
}