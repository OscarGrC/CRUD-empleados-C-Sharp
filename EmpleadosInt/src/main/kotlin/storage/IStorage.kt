package storage

import models.Departamento
import models.Empleado
import java.io.File

interface IStorage {
    fun saveDataCSVEmpleados(data: List<Empleado>)
    fun loadDataCSVEmpleados(): List<Empleado>
}