package com.example.pqpcalculadora

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TableRow
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

        /* Trigonometria */
        var trig = false

        /* EXP e MOD */

        var modativo = false
        var modt1 = 0.0
        var modt2 = 0.0

        var exp = false
        var expt1 = 0.0
        var expt2 = 0.0


        /* Imports Botões */
        val displayNumberHistory = findViewById<TextView>(R.id.display_number_history)
        val displayNumber = findViewById<TextView>(R.id.display_number)

        val btMC = findViewById<MaterialButton>(R.id.btMC)
        val btMR = findViewById<MaterialButton>(R.id.btMR)
        val btMmais = findViewById<MaterialButton>(R.id.btMmais)
        val btMmenos = findViewById<MaterialButton>(R.id.btMmenos)

        val btTrig = findViewById<MaterialButton>(R.id.bttrig)
        val btDeg = findViewById<MaterialButton>(R.id.btDeg)

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

        val btLog = findViewById<MaterialButton>(R.id.btlog)
        val bt1 = findViewById<MaterialButton>(R.id.bt1)
        val bt2 = findViewById<MaterialButton>(R.id.bt2)
        val bt3 = findViewById<MaterialButton>(R.id.bt3)
        val btSoma = findViewById<MaterialButton>(R.id.btsoma)

        val btLn = findViewById<MaterialButton>(R.id.btln)
        val bt0 = findViewById<MaterialButton>(R.id.bt0)
        val btPonto = findViewById<MaterialButton>(R.id.btponto)
        val btResultado = findViewById<MaterialButton>(R.id.btresultado)

        /* Parte Trigonometria */

        val btsen = findViewById<MaterialButton>(R.id.btsen)
        val btcos = findViewById<MaterialButton>(R.id.btcos)
        val bttan = findViewById<MaterialButton>(R.id.bttan)
        val btasen = findViewById<MaterialButton>(R.id.btasen)
        val btacos = findViewById<MaterialButton>(R.id.btacos)
        val btatan = findViewById<MaterialButton>(R.id.btatan)
        val hidetrig = findViewById<TableRow>(R.id.trigfunc)

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

        bt0.setOnClickListener {
            if (isResult == true)
                displayNumber.setText("0")
            if (!displayNumber.text.toString().equals("0"))
                displayNumber.setText(displayNumber.text.toString().plus("0"))

            isResult = false
        }

        bt1.setOnClickListener {
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("1")
            else
                displayNumber.setText(displayNumber.text.toString().plus("1"))

            isResult = false
        }

        bt2.setOnClickListener {
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("2")
            else
                displayNumber.setText(displayNumber.text.toString().plus("2"))

            isResult = false
        }

        bt3.setOnClickListener {
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("3")
            else
                displayNumber.setText(displayNumber.text.toString().plus("3"))

            isResult = false
        }

        bt4.setOnClickListener {
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("4")
            else
                displayNumber.setText(displayNumber.text.toString().plus("4"))

            isResult = false
        }

        bt5.setOnClickListener {
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("5")
            else
                displayNumber.setText(displayNumber.text.toString().plus("5"))

            isResult = false
        }

        bt6.setOnClickListener {
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("6")
            else
                displayNumber.setText(displayNumber.text.toString().plus("6"))

            isResult = false
        }

        bt7.setOnClickListener {
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("7")
            else
                displayNumber.setText(displayNumber.text.toString().plus("7"))

            isResult = false
        }

        bt8.setOnClickListener {
            if (displayNumber.text.toString().equals("0") || isResult)
                displayNumber.setText("8")
            else
                displayNumber.setText(displayNumber.text.toString().plus("8"))

            isResult = false
        }

        bt9.setOnClickListener {
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
            } else {
                displayNumber.text = String.format("%.4f", euler)
                displayNumber.text = displayNumber.text.toString().replace(",", ".")
            }

        }

        btPi.setOnClickListener {
            if (displayNumber.text.toString().equals("0") || isResult) {
                displayNumber.text = String.format("%.4f", pi)
                displayNumber.text = displayNumber.text.toString().replace(",", ".")
            } else
                displayNumber.text = String.format("%.4f", pi)
            displayNumber.text = displayNumber.text.toString().replace(",", ".")
        }

        /* Função para adicionar */

        fun appendOperator(op: String) {
            val historico = displayNumberHistory.text.toString()
            val atual = displayNumber.text.toString()

            if (isResult) {
                // Se o último valor foi resultado, começa nova operação com o resultado
                displayNumberHistory.text = atual + op
            } else {
                if (atual != "0") {
                    displayNumberHistory.text = historico + atual + op
                } else if (historico.isNotEmpty() && !historico.last().toString().matches(Regex("[+\\-*/(]"))) {

                    displayNumberHistory.text = historico + op
                }
            }

            displayNumber.text = "0"
            isResult = false
        }

// Botões de operação
        btSoma.setOnClickListener { appendOperator("+") }
        btMenos.setOnClickListener { appendOperator("-") }
        btVezes.setOnClickListener { appendOperator("*") }
        btDiv.setOnClickListener { appendOperator("/") }

// Parênteses
        btPaberto.setOnClickListener {
            val historico = displayNumberHistory.text.toString()

            if (isResult) {
                displayNumberHistory.text = displayNumber.text.toString() + "("
                displayNumber.text = "0"
            } else {
                if (displayNumber.text.toString() != "0") {
                    displayNumberHistory.text = historico + displayNumber.text.toString() + "*("
                    displayNumber.text = "0"
                } else {
                    displayNumberHistory.text = historico + "("
                }
            }

            isResult = false
        }

        btPfechado.setOnClickListener {
            val atual = displayNumber.text.toString()
            val historico = displayNumberHistory.text.toString()

            if (atual != "0") {
                displayNumberHistory.text = historico + atual + ")"
                displayNumber.text = "0"
            } else {
                displayNumberHistory.text = historico + ")"
            }
        }


        btPfechado.setOnClickListener {
            if (!isResult) {
                val currentNumber = displayNumber.text.toString()
                if (currentNumber != "0") {
                    // Adiciona o número atual ao histórico antes de fechar parêntese
                    displayNumberHistory.text = displayNumberHistory.text.toString() + currentNumber
                    displayNumber.text = "0"
                }
                // Adiciona parêntese de fechamento ao histórico
                displayNumberHistory.text = displayNumberHistory.text.toString() + ")"
            }
        }

        /* Operações Especiais */

        btPotencia.setOnClickListener {

            var tempo = displayNumberHistory.text.toString()

            if (!displayNumberHistory.text.toString().endsWith("^")) {

                if (tempo != "") {
                    displayNumberHistory.setText(tempo + "^" + displayNumber.text.toString())
                } else if (tempo == "") {
                    displayNumberHistory.setText(displayNumber.text.toString() + "^")
                }
            } else if (displayNumberHistory.text.toString().endsWith("^")) {

                displayNumberHistory.setText(tempo + displayNumber.text.toString())

            }

            isResult = true
        }

        btXquadrado.setOnClickListener {

            displayNumberHistory.setText(displayNumber.text.toString() + "^2")
            var operacao =
                ExpressionBuilder(displayNumberHistory.text.toString()).build().evaluate()
            displayNumber.setText(operacao.toString())
            isResult = true
            displayNumberHistory.setText("")

        }

        btRaizQd.setOnClickListener {

            var tempo = displayNumber.text.toString()
            displayNumberHistory.setText("√ $tempo")
            displayNumber.setText((Math.sqrt(tempo.toDouble())).toString())
            isResult = true

        }

        btAbs.setOnClickListener {

            var tempo = displayNumber.text.toString()
            displayNumberHistory.setText("abs($tempo)")
            displayNumber.setText((Math.abs(tempo.toString().toInt())).toString())

        }


        btLn.setOnClickListener {

            var tempo = displayNumber.text.toString()
            displayNumberHistory.setText("Logₑ $tempo")

            displayNumber.setText(Math.log(tempo.toDouble()).toString())
            isResult = true
        }

        btLog.setOnClickListener {

            var tempo = displayNumber.text.toString()
            displayNumberHistory.setText("Log₁₀ $tempo")

            displayNumber.setText((Math.log10(tempo.toDouble())).toString())
            isResult = true
        }

        bt1sobrex.setOnClickListener {

            var tempo = displayNumber.text.toString()
            displayNumberHistory.setText("1/$tempo")

            displayNumber.setText((1 / tempo.toString().toDouble()).toString())
            isResult = true
        }

        btFatorial.setOnClickListener {

            fun fatorial(n: Int): Long {
                if (n == 0) return 1 // Caso base: fatorial de 0 é 1
                return n * fatorial(n - 1) // Chamada recursiva
            }

            var tempo = displayNumber.text.toString()
            displayNumberHistory.setText("$tempo!")
            displayNumber.setText((fatorial(tempo.toString().toInt())).toString())

            isResult = true
        }

        /* Trigonometria */

        btTrig.setOnClickListener {

            if (hidetrig.visibility == View.GONE) {
                hidetrig.visibility = View.VISIBLE
            } else if (btTrig.visibility == View.VISIBLE) {
                hidetrig.visibility = View.GONE
            }
        }

        btsen.setOnClickListener {
            var tempo = displayNumber.text.toString()
            displayNumberHistory.setText("Sen($tempo)")
            var tempoc = Math.toRadians(tempo.toDouble())
            var calc = Math.sin(tempoc)
            displayNumber.setText(String.format("%.2f", calc).replace(",", "."))

            isResult = true
        }

        btcos.setOnClickListener {
            var tempo = displayNumber.text.toString()
            displayNumberHistory.setText("Cos($tempo)")
            var tempoc = Math.toRadians(tempo.toDouble())
            var calc = Math.cos(tempoc)
            displayNumber.setText(String.format("%.2f", calc).replace(",", "."))

            isResult = true
        }

        bttan.setOnClickListener {
            var tempo = displayNumber.text.toString()
            displayNumberHistory.setText("Tan($tempo)")
            var tempoc = Math.toRadians(tempo.toDouble())
            var calc = Math.tan(tempoc)
            displayNumber.setText(String.format("%.2f", calc).replace(",", "."))

            isResult = true
        }

        btasen.setOnClickListener {
            var tempo = displayNumber.text.toString()
            displayNumberHistory.setText("ASen($tempo)")
            var calc = Math.asin(tempo.toDouble())
            displayNumber.setText(String.format("%.2f", Math.toDegrees(calc)).replace(",", "."))

            isResult = true
        }

        btacos.setOnClickListener {
            var tempo = displayNumber.text.toString()
            displayNumberHistory.setText("ACos($tempo)")
            var calc = Math.acos(tempo.toDouble())
            displayNumber.setText(String.format("%.2f", Math.toDegrees(calc)).replace(",", "."))

            isResult = true
        }

        btatan.setOnClickListener {
            var tempo = displayNumber.text.toString()
            displayNumberHistory.setText("ATan($tempo)")
            var calc = Math.atan(tempo.toDouble())
            displayNumber.setText(String.format("%.2f", Math.toDegrees(calc)).replace(",", "."))

            isResult = true
        }

        /* Botão EXP e MOD */

        btMod.setOnClickListener {

            modt1 = displayNumber.text.toString().toDouble()
            displayNumber.text = "0"
            modativo = true

        }

        btExp.setOnClickListener {

            expt1 = displayNumber.text.toString().toDouble()
            displayNumber.text = "0"
            exp = true

        }


        /* Botão DEGREE */
        btDeg.setOnClickListener {
            if (btDeg.text == "DEG")
                btDeg.text = "RAD"
            else if (btDeg.text == "RAD")
                btDeg.text = "GRAD"
            else if (btDeg.text == "GRAD")
                btDeg.text = "DEG"
        }


        /* Botão Resultado */

        btResultado.setOnClickListener {

            if (modativo == true) {
                modt2 = displayNumber.text.toString().toDouble()
                var calc = modt1 % modt2
                displayNumberHistory.setText("$modt1 % $modt2")
                displayNumber.text = calc.toString()
                modt1 = 0.0
                modt2 = 0.0
                modativo = false
                isResult = true

            }
            else if (exp == true) {
                expt2 = displayNumber.text.toString().toDouble()
                var calc = expt1 * Math.pow(10.0, expt2)
                displayNumber.setText(calc.toString())

                exp = false
                expt1 = 0.0
                expt2 = 0.0
                isResult = true
            }

            else {
                displayNumberHistory.setText(displayNumberHistory.text.toString() + "+" + displayNumber.text.toString())
                var expressao = ExpressionBuilder(displayNumberHistory.text.toString()).build()
                var result = expressao.evaluate()
                displayNumber.setText(result.toString())
                isResult = true
                displayNumberHistory.setText("")


            }

        }


    }
}