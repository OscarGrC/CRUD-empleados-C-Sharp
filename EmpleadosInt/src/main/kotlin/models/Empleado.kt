package models

class Empleado(val dni:String,var nombre:String,var correo:String,var telefono:String,var puesto:String,var departamento: Departamento) {
    override fun toString(): String {
        return "Hola soy $nombre mi puesto es $puesto en el departamento $departamento"
    }
}