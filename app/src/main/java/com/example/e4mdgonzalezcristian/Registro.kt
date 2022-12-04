package com.example.e4mdgonzalezcristian

data class Registro (val dni: String, val nombre: String, val annoTitu: Int,/*val especialidad: Especialidad*/val codEspe: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Registro

        if (dni != other.dni) return false

        return true
    }

    override fun hashCode(): Int {
        return dni.hashCode()
    }
}