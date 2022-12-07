package com.example.e4mdgonzalezcristian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e4mdgonzalezcristian.databinding.ActivityRecyclerViewBinding
import com.example.e4mdgonzalezcristian.modelo.Especialidad


class RecyclerViewActivity : AppCompatActivity(), Eventos {
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var linearLayout: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.adapter = EspecialidadAdapter(cargarEspecialiades(), this)
        linearLayout = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = linearLayout
        binding.recyclerview.setHasFixedSize(true)
    }

    fun cargarEspecialiades(): List<Especialidad> {
        val epecialidad1 = Especialidad(123, "Pediatria", 5)
        val especialidad2 = Especialidad(321, "Traumatismos", 4)
        val especialidad3 = Especialidad(456, "Dermatología", 6)
        val especialidad4 = Especialidad(777, "Anatomía ", 22)
        val especialidad5 = Especialidad(111, "Anestesiología", 10)
        val especialidad6 = Especialidad(222, "Geriatría", 7)
        val especialidad7 = Especialidad(333, "Hematología ", 9)
        val especialidad8 = Especialidad(444, "Alergología ", 4)
        val especialidad9 = Especialidad(555, "Cardiología", 1)
        val especialidad10 = Especialidad(666, "Medicina de la educación física", 2)
        val especialidad11 = Especialidad(888, "Cirugía", 30)
        val especialidad12 = Especialidad(999, "Neumología ", 15)
        //val listaEspecialidades = listOf(epecialidad1, especialidad2, especialidad3, especialidad4)
        //return listaEspecialidades
        return listOf(epecialidad1, especialidad2, especialidad3, especialidad4,especialidad5,especialidad6,
        especialidad6,especialidad7,especialidad8,especialidad9,especialidad10,especialidad11,especialidad12)
    }

    override fun pulsacionLarga(especialidad: Especialidad): Boolean {
        /*DEVOLVEMOS EL CODIGO*/
        val intent = Intent()
        intent.putExtra("codigo", especialidad.codigo.toString())
        setResult(RESULT_OK, intent)
        Toast.makeText(this, "Especilidad" + ": ${especialidad.nombre}", Toast.LENGTH_SHORT).show()
        finish()
        return true
    }
}