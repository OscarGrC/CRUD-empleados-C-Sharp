package storage

import models.Departamento
import models.DepartamentosEnum
import models.Empleado
import java.io.File

class StorageImp():IStorage {
    override fun saveDataCSVEmpleados(data: List<Empleado>) {
        val path = "${System.getProperty("user.dir")}${File.separator}src${File.separator}main${File.separator}" +
                "kotlin${File.separator}storage${File.separator}Personal.csv"
        val file = File(path)
        if (!file.exists()) {
            file.createNewFile()
        }
        //
        val salidaPrologo = "Dni,Nombre,Correo,tlf,Puesto,Departamento \n"
        var salida = ""
        data.forEach{
            salida += it.dni+";"+it.nombre+";"+it.correo+";"+it.telefono+";"+it.puesto+";"+it.departamento.nombre+"\n" }
        file.bufferedWriter().use { it.write(salidaPrologo + salida) }
        println("CSV guardado en ${file.absolutePath}")

    }

    override fun loadDataCSVEmpleados(): List<Empleado> {
        val path = "${System.getProperty("user.dir")}${File.separator}src${File.separator}main${File.separator}" +
                "kotlin${File.separator}storage${File.separator}Personal.csv"
        val fichero = File(path)
        val listaEmpleados= fichero.useLines { lines ->
            lines
                // ignoro la primera porque es el encabezado
                .drop(1)
                // separo por comas
                .map { linea -> linea.split(";") }
                // convierto a Ingrediente
                .map { columnas ->
                    Empleado(
                        columnas[0],            // dni
                        columnas[1],            // nombre
                        columnas[2],            // correo
                        columnas[3],            // telefono
                        columnas[4],            // puesto
                        when(columnas[5]){
                            //Departamento
                            DepartamentosEnum.Administracion.name  -> Departamento(DepartamentosEnum.Administracion)
                            DepartamentosEnum.RRHH.name  -> Departamento(DepartamentosEnum.RRHH)
                            DepartamentosEnum.Mantenimiento.name  -> Departamento(DepartamentosEnum.Mantenimiento)
                            DepartamentosEnum.Logistica.name  -> Departamento(DepartamentosEnum.Logistica)
                            DepartamentosEnum.Marketing.name  -> Departamento(DepartamentosEnum.Marketing)
                            DepartamentosEnum.Comercial.name  -> Departamento(DepartamentosEnum.Comercial)
                            DepartamentosEnum.Finanzas.name  -> Departamento(DepartamentosEnum.Finanzas)
                            DepartamentosEnum.Masillas.name  -> Departamento(DepartamentosEnum.Masillas)
                            DepartamentosEnum.Compras.name  -> Departamento(DepartamentosEnum.Compras)
                            DepartamentosEnum.Direccion.name  -> Departamento(DepartamentosEnum.Direccion)
                            else -> {Departamento(DepartamentosEnum.Masillas)}
                        }
                    )
                }.toMutableList()
        }
        return  listaEmpleados
    }

}