package mx.itson.edu.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(){
    var numActual: String = ""
    var numNuevo: String = ""
    lateinit var txtOperacion: TextView
    lateinit var txtError: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cero: Button = findViewById(R.id.btn0)
        val uno: Button = findViewById(R.id.btn1)
        val dos: Button = findViewById(R.id.btn2)
        val tres: Button = findViewById(R.id.btn3)
        val cuatro: Button = findViewById(R.id.btn4)
        val cinco: Button = findViewById(R.id.btn5)
        val seis: Button = findViewById(R.id.btn6)
        val siete: Button = findViewById(R.id.btn7)
        val ocho: Button = findViewById(R.id.btn8)
        val nueve: Button = findViewById(R.id.btn9)
        val limpiar: Button = findViewById(R.id.btnClear)
        val igual: Button = findViewById(R.id.btnIgual)

        val sumar: Button = findViewById(R.id.btnSumar)
        val multiplicar: Button = findViewById(R.id.btnMultiplicar)
        val restar: Button = findViewById(R.id.btnRestar)
        val division: Button = findViewById(R.id.btnDivision)

        val txtResultado: TextView = findViewById(R.id.textView3)

        var operacionActual: String = ""
        txtOperacion = findViewById(R.id.textView3)
        txtError = findViewById(R.id.txtView1)

        cero.setOnClickListener {
            numActual += "0"
            txtOperacion.setText(numActual)
        }

        uno.setOnClickListener {
            numActual += "1"
            txtOperacion.setText(numActual)
        }

        dos.setOnClickListener {
            numActual += "2"
            txtOperacion.setText(numActual)
        }

        tres.setOnClickListener {
            numActual += "3"
            txtOperacion.setText(numActual)
        }

        cuatro.setOnClickListener {
            numActual += "4"
            txtOperacion.setText(numActual)
        }

        cinco.setOnClickListener {
            numActual += "5"
            txtOperacion.setText(numActual)
        }

        seis.setOnClickListener {
            numActual += "6"
            txtOperacion.setText(numActual)
        }

        siete.setOnClickListener {
            numActual += "7"
            txtOperacion.setText(numActual)
        }

        ocho.setOnClickListener {
            numActual += "8"
            txtOperacion.setText(numActual)
        }

        nueve.setOnClickListener {
            numActual += "9"
            txtOperacion.setText(numActual)
        }

        limpiar.setOnClickListener {
            if(numActual == ""){
                numNuevo = ""
                txtResultado.setText("")
            }

            numActual = ""
            txtOperacion.setText(numActual)

        }

        restar.setOnClickListener {
            resetearNumero()
            txtResultado.setText(numNuevo + "-")
            operacionActual = "-"
        }

        sumar.setOnClickListener {
            resetearNumero()
            txtResultado.setText(numNuevo + "+")
            operacionActual = "+"
        }

        division.setOnClickListener {
            resetearNumero()
            txtResultado.setText(numNuevo + "/")
            operacionActual = "/"
        }

        multiplicar.setOnClickListener {
            resetearNumero()
            txtResultado.setText(numNuevo + "*")
            operacionActual = "*"
        }

        igual.setOnClickListener {
            txtError.setText("")

            if(operacionActual == "+"){
                txtResultado.setText(suma(numNuevo.toInt(), numActual.toInt()).toString())
                reiniciarValores()
            }

            if(operacionActual == "/"){
                txtResultado.setText(division(numNuevo.toInt(), numActual.toInt()).toString())
                reiniciarValores()
            }

            if (operacionActual == "-"){
                txtResultado.setText(resta(numNuevo.toInt(), numActual.toInt()).toString())
                reiniciarValores()
            }

            if(operacionActual == "*"){
                txtResultado.setText(multiply(numNuevo.toInt(), numActual.toInt()).toString())
                reiniciarValores()
            }

        }


    }

    private fun reiniciarValores(){
        txtOperacion.setText("")
        numNuevo = ""
    }
    
    private fun resetearNumero(){
        numNuevo = numActual
        numActual = ""
        txtOperacion.setText(numActual)
    }
    
    fun suma(a: Int, b: Int): Int{
        return a + b
    }
    
    fun resta(a: Int, b: Int): Int{
        return a - b
    }
    
    fun division(a: Int, b: Int): Int{
        try {
            return a / b
        }catch (e: Exception){
            txtError.setText(e.message)
            return 0
        }
    }
    
    fun multiply(a: Int, b: Int): Int{
        return a * b
    }

}