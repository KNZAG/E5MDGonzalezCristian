package com.example.e4mdgonzalezcristian

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e4mdgonzalezcristian.databinding.ItemEspecialidadAltBinding


class EspecialidadAdapter(private val especialidades: List<Especialidad>, private val listener: Eventos)
    : RecyclerView.Adapter<EspecialidadAdapter.ClaseInterna>() {

    private lateinit var context: Context

    inner class ClaseInterna(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemEspecialidadAltBinding.bind(view)
        fun setListener(especialidad: Especialidad, /*posicion: Int*/){
            binding.root.setOnLongClickListener {
                listener.pulsacionLarga(especialidad)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaseInterna {
        context = parent.context//AVERIGUAR EL CONTEXTO
        /*LE INDICO EL DISEÑO DE CADA ELEMENTO*/
        val view = LayoutInflater.from(context).inflate(R.layout.item_especialidad_alt, parent/*donde*/, false)//la vista a usar para poder interactuar
        return ClaseInterna(view/*ES LA VAL VIEW*/)
    }

    override fun onBindViewHolder(holder: ClaseInterna, position: Int) {
        val especialidad = especialidades.get(position)
        with(holder) {
            binding.codigo.text = "Cód: \n"+especialidad.codigo.toString()
            binding.NombreEspe.text = especialidad.nombre
            binding.NumPlazas.text = "Número de plazas: "+especialidad.nPlazas.toString()
            setListener(especialidad/*,position*/)
        }
    }

    override fun getItemCount() = especialidades.size
}


