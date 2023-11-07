package repositories

import models.Departamento
import models.Empleado
import storage.StorageImp

class RepositoryEmpleadosImp(private var db: StorageImp):IRepositorioEmpleados {
    var database = db
   private var listaEmpleados:MutableList<Empleado> = db.loadDataCSVEmpleados().toMutableList()

    override fun findAllEmpleados(): MutableList<Empleado> {
        return database.loadDataCSVEmpleados().toMutableList()
    }

    override fun findEmpleadoByDNI(dni: String): Empleado? {
        return listaEmpleados.find{it.dni==dni}
    }

    override fun findEmpleadoByDepartamento(departamento: Departamento): MutableList<Empleado> {
        return listaEmpleados.filter {it.departamento==departamento  }.toMutableList()
    }

    override fun saveEmpleado(empleado: Empleado): Empleado {
        listaEmpleados.add(empleado)
        return empleado
    }

    override fun deleteEmpleadoByDNI(dni: String) {
        var empleado:Empleado? = listaEmpleados.find { it.dni==dni }
        if(empleado == null){
            println("Trabajador no encontrado")}
        else{
        listaEmpleados.remove(empleado)
            println("Trabajador borrado")
    }}

    override fun deleteAllEmpleados() {
        var listaVacia = mutableListOf<Empleado>()
        db.saveDataCSVEmpleados(listaVacia)
    }

    override fun saveAllEmpleados(): MutableList<Empleado> {
        db.saveDataCSVEmpleados(listaEmpleados)
        return  listaEmpleados
    }

    override fun createEmpleado(empleado: Empleado): Empleado {
        listaEmpleados.add(empleado)
        return  empleado
    }

    override fun upDateEmpleado(empleado: Empleado): Empleado {
        deleteEmpleadoByDNI(empleado.dni)
        saveEmpleado(empleado)
        return empleado
    }
}