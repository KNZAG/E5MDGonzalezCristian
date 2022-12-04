package com.example.e4mdgonzalezcristian

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.e4mdgonzalezcristian.databinding.ActivityRegistroBinding
import kotlin.system.exitProcess

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding

    private val devolverEspecialidad =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK) {
                /*?->PUEDE SER NULO-orEmpty->PUEDE ESTAR VACIO*/
                val code = activityResult.data?.getStringExtra("codigo").orEmpty()
                binding.codEspe.text = code
                //Toast.makeText(this, code, Toast.LENGTH_SHORT).show()
                //Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }

    private var registro1 = Registro("1", "Pepe", 2003, 123)
    private val listaRegistros = mutableListOf/*<Registro>*/(registro1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btInfo.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            devolverEspecialidad.launch(intent)//DEFINIMOS LA VARIABLE ARRIBA ADEMAS RECIBE EL CODIGO (INTENT.GETsTRING)
        }

        binding.btCancelar.setOnClickListener {
            limpiar()
        }

        binding.btFinApp.setOnClickListener {
            // finishAffinity()
            exitProcess(0)
        }

        binding.btRegistrar.setOnClickListener {
            val dni = binding.txDni.text.toString().trim()
            val nombre = binding.txNombre.text.toString().trim()
            val anoTitulaL = binding.txAnno.text.toString().trim()
            val codEspeciaL = binding.codEspe.text.toString().trim()
            val posRegistro = existeRegistro(dni)
            //val posRegistro = registroExistente(dni)

            if (dni.isEmpty() || nombre.isEmpty() || anoTitulaL.isEmpty() || codEspeciaL.equals("INFO PARA SELECCIONAR ESPECIALIDAD")) {
                Toast.makeText(this, "ERROR:RELLENO TODOS LOS DATOS", Toast.LENGTH_SHORT).show()
            } else {
                if (posRegistro == -1) {
                    val registro = Registro(dni, nombre, anoTitulaL.toInt(), codEspeciaL.toInt())
                    listaRegistros.add(registro)
                    Toast.makeText(this, "REGISTRO REALIZADO", Toast.LENGTH_SHORT).show()
                    limpiar()
                } else {
                    Toast.makeText(this, "ERROR: DNI YA REGISTRADO "/*+ posRegistro*/, Toast.LENGTH_SHORT).show()
                    binding.txDni.setText("")
                    binding.txDni.requestFocus()
                }
            }
        }
    }

    private fun limpiar() {
        binding.txDni.setText("")
        binding.txNombre.setText("")
        binding.txAnno.setText("")
        binding.codEspe.text = "INFO PARA SELECCIONAR ESPECIALIDAD"
        binding.txDni.requestFocus()
    }

   // private fun registroExistente(dni: String) = dni.indexOf(dni)

   private fun existeRegistro(dni: String): Int {
        var posRegistro = -1
        var pos = 0
        while (pos < listaRegistros.size && posRegistro == -1) {
            if (listaRegistros[pos].dni == binding.txDni.text.toString()) {
                posRegistro = pos
            }
            pos++
        }
        return posRegistro
    }
}