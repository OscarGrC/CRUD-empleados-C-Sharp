package controllers

import models.Departamento
import models.DepartamentosEnum
import models.Empleado

interface IEmpleadoControler {
    fun findAllEmpleados()
    fun findEmpleadoByDNI():Empleado?
    fun findEmpleadoByDepartamento()
    fun saveEmpleado()
    fun deleteEmpleadoByDNI()
    fun deleteAllEmpleados()
    fun saveAllEmpleados()
    fun upDateEmpleado()
}