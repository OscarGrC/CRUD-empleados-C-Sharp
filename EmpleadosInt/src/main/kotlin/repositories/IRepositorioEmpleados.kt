package repositories

import models.Departamento
import models.Empleado

interface IRepositorioEmpleados {
    fun findAllEmpleados(): MutableList<Empleado>
    fun findEmpleadoByDNI(dni: String): Empleado?
    fun findEmpleadoByDepartamento(departamento: Departamento):MutableList<Empleado>
    fun saveEmpleado(empleado: Empleado): Empleado
    fun deleteEmpleadoByDNI(dni: String)
    fun deleteAllEmpleados()
    fun saveAllEmpleados(): MutableList<Empleado>
    fun createEmpleado(empleado: Empleado):Empleado
    fun upDateEmpleado(empleado: Empleado):Empleado
}
