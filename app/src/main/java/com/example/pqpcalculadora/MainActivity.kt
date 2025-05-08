package com.example.pqpcalculadora

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import net.objecthunter.exp4j.ExpressionBuilder /* Expression Builder */


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

        /* Variáveis Memoria */
        var memoria = 0.0
        var memoryFull = false

        /* Variaveis Contas */
        var isResult = false




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

        val btRaizQd = findViewById<MaterialButton>(R.id.btraizq)
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

        val btLn = findViewById<MaterialButton>(R.id.btln)
        val bt0 = findViewById<MaterialButton>(R.id.bt0)
        val btPonto = findViewById<MaterialButton>(R.id.btponto)
        val btResultado = findViewById<MaterialButton>(R.id.btresultado)


        /* Botões de memoria */

        btMR.isEnabled = memoryFull
        btMC.isEnabled = memoryFull

        btMC.setOnClickListener {
            memoria = 0.0
            memoryFull = false
            btMR.isEnabled = memoryFull
            btMC.isEnabled = memoryFull
        }

        btMR.setOnClickListener {
            displayNumber.setText(memoria.toString())
        }

        btMmais.setOnClickListener {
            memoria += displayNumber.text.toString().toDouble()
            displayNumber.setText("0")
            memoryFull = true
            btMR.isEnabled = memoryFull
            btMC.isEnabled = memoryFull
        }

        btMmenos.setOnClickListener {
            memoria -= displayNumber.text.toString().toDouble()
            displayNumber.setText("0")
            memoryFull = true
            btMR.isEnabled = memoryFull
            btMC.isEnabled = memoryFull
        }

        /* Botões Números */

        bt0.setOnClickListener{
            if (isResult == true)
                displayNumber.setText("0")
            if (!displayNumber.text.toString().equals("0"))
                displayNumber.setText(displayNumber.text.toString().plus("0"))

            isResult = false
        }

        bt1.setOnClickListener{
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("1")
            else
                displayNumber.setText(displayNumber.text.toString().plus("1"))

            isResult = false
        }

        bt2.setOnClickListener{
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("2")
            else
                displayNumber.setText(displayNumber.text.toString().plus("2"))

            isResult = false
        }

        bt3.setOnClickListener{
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("3")
            else
                displayNumber.setText(displayNumber.text.toString().plus("3"))

            isResult = false
        }

        bt4.setOnClickListener{
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("4")
            else
                displayNumber.setText(displayNumber.text.toString().plus("4"))

            isResult = false
        }

        bt5.setOnClickListener{
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("5")
            else
                displayNumber.setText(displayNumber.text.toString().plus("5"))

            isResult = false
        }

        bt6.setOnClickListener{
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("6")
            else
                displayNumber.setText(displayNumber.text.toString().plus("6"))

            isResult = false
        }

        bt7.setOnClickListener{
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("7")
            else
                displayNumber.setText(displayNumber.text.toString().plus("7"))

            isResult = false
        }

        bt8.setOnClickListener{
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("8")
            else
                displayNumber.setText(displayNumber.text.toString().plus("8"))

            isResult = false
        }

        bt9.setOnClickListener{
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("9")
            else
                displayNumber.setText(displayNumber.text.toString().plus("9"))

            isResult = false
        }

        btPonto.setOnClickListener {
            if (!displayNumber.text.contains("."))
                displayNumber.setText(displayNumber.text.toString().plus("."))
            isResult = false
        }

        /* Botão CE/C */

        btCE.setOnClickListener {
            displayNumber.setText("0")
            displayNumberHistory.setText("")

            isResult = false
        }

        btC.setOnClickListener {
            displayNumber.setText(displayNumber.text.dropLast(1))
            if (displayNumber.text == "")
                displayNumber.setText("0")
        }

        /* Botões Euler/Pi */

        btEuler.setOnClickListener {
            if (displayNumber.text.toString().equals("0") || isResult) {
                displayNumber.text = String.format("%.4f", euler)
                displayNumber.text = displayNumber.text.toString().replace(",", ".")
            }
            else {
                displayNumber.text = String.format("%.4f", euler)
                displayNumber.text = displayNumber.text.toString().replace(",", ".")
            }

        }

        btPi.setOnClickListener {
            if (displayNumber.text.toString().equals("0") || isResult){
                displayNumber.text = String.format("%.4f", pi)
                displayNumber.text = displayNumber.text.toString().replace(",", ".")
            }
            else
                displayNumber.text = String.format("%.4f", pi)
                displayNumber.text = displayNumber.text.toString().replace(",", ".")
        }

        /* Botões Operações */

        btSoma.setOnClickListener {

            var tempo = displayNumberHistory.text.toString()

            if (!displayNumberHistory.text.toString().endsWith("+")) {

                if (tempo != "") {
                    displayNumberHistory.setText(tempo + "+" + displayNumber.text.toString())
                }
                else if (tempo == ""){
                    displayNumberHistory.setText(displayNumber.text.toString() + "+")
                }
            }

            else if (displayNumberHistory.text.toString().endsWith("+")){

                displayNumberHistory.setText(tempo + displayNumber.text.toString())

            }

            isResult = true
        }

        btMenos.setOnClickListener {

            var tempo = displayNumberHistory.text.toString()

            if (!displayNumberHistory.text.toString().endsWith("-")) {

                if (tempo != "") {
                    displayNumberHistory.setText(tempo + "-" + displayNumber.text.toString())
                }
                else if (tempo == ""){
                    displayNumberHistory.setText(displayNumber.text.toString() + "-")
                }
            }

            else if (displayNumberHistory.text.toString().endsWith("-")){

                displayNumberHistory.setText(tempo + displayNumber.text.toString())

            }

            isResult = true
        }

        btVezes.setOnClickListener {

            var tempo = displayNumberHistory.text.toString()

            if (!displayNumberHistory.text.toString().endsWith("*")) {

                if (tempo != "") {
                    displayNumberHistory.setText(tempo + "*" + displayNumber.text.toString())
                }
                else if (tempo == ""){
                    displayNumberHistory.setText(displayNumber.text.toString() + "*")
                }
            }

            else if (displayNumberHistory.text.toString().endsWith("*")){

                displayNumberHistory.setText(tempo + displayNumber.text.toString())

            }

            isResult = true
        }

        btDiv.setOnClickListener {

            var tempo = displayNumberHistory.text.toString()

            if (!displayNumberHistory.text.toString().endsWith("/")) {

                if (tempo != "") {
                    displayNumberHistory.setText(tempo + "/" + displayNumber.text.toString())
                }
                else if (tempo == ""){
                    displayNumberHistory.setText(displayNumber.text.toString() + "/")
                }
            }

            else if (displayNumberHistory.text.toString().endsWith("/")){

                displayNumberHistory.setText(tempo + displayNumber.text.toString())

            }

            isResult = true
        }

        btPotencia.setOnClickListener {

            var tempo = displayNumberHistory.text.toString()

            if (!displayNumberHistory.text.toString().endsWith("^")) {

                if (tempo != "") {
                    displayNumberHistory.setText(tempo + "^" + displayNumber.text.toString())
                }
                else if (tempo == ""){
                    displayNumberHistory.setText(displayNumber.text.toString() + "^")
                }
            }

            else if (displayNumberHistory.text.toString().endsWith("^")){

                displayNumberHistory.setText(tempo + displayNumber.text.toString())

            }

            isResult = true
        }

        btXquadrado.setOnClickListener {

            displayNumberHistory.setText(displayNumber.text.toString() + "^2")
            var operacao = ExpressionBuilder(displayNumberHistory.text.toString()).build().evaluate()
            displayNumber.setText(operacao.toString())
            isResult = true
            displayNumberHistory.setText("")

        }

        btRaizQd.setOnClickListener {

            var tempo = displayNumberHistory.text.toString()

            if (!displayNumberHistory.text.toString().endsWith("sqrt()")) {

                if (tempo != "") {
                    displayNumberHistory.setText(tempo + "sqrt(" + displayNumber.text.toString() + ")")
                }
                else if (tempo == ""){
                    displayNumberHistory.setText("sqrt(" + displayNumber.text.toString() + ")")
                }
            }

            else if (displayNumberHistory.text.toString().endsWith("sqrt()")){

                displayNumberHistory.setText(tempo + displayNumber.text.toString())

            }

            isResult = true
        }

        btAbs.setOnClickListener {

            var operacao: Double = Math.abs(displayNumber.text.toString().toDouble())
            displayNumberHistory.setText("abs(" + displayNumber.text.toString() + ")")
            displayNumber.setText(operacao.toString())
            isResult = true
            displayNumberHistory.setText("")

        }





        /* Botão Resultado */

        btResultado.setOnClickListener {

            displayNumberHistory.setText(displayNumberHistory.text.toString() + displayNumber.text.toString())
            var exp = ExpressionBuilder(displayNumberHistory.text.toString()).build()
            var result = exp.evaluate()
            displayNumber.setText(result.toString())
            isResult = true
            displayNumberHistory.setText("")

        }


    }
}