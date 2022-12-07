package com.example.e4mdgonzalezcristian.modelo

data class Registro(
    val dni: String,
    val nombre: String = "",
    val annoTitu: Int = 0,
    val codEspe: Int = 0
) {

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