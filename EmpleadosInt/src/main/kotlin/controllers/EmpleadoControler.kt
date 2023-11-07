package controllers

import models.Departamento
import models.DepartamentosEnum
import models.Empleado
import repositories.RepositoryEmpleadosImp

class EmpleadoControler(private var repositorio:RepositoryEmpleadosImp):IEmpleadoControler {

    override fun findAllEmpleados() {
        var listaEmpleados = repositorio.findAllEmpleados()
        println(listaEmpleados.toString())
    }

    override fun findEmpleadoByDNI():Empleado? {
        var empleadoDni:String =""
        println("Introduce el DNI del Empleado que deseas borrar")
        empleadoDni = readln()
        var empleado:Empleado? =repositorio.findEmpleadoByDNI(empleadoDni)
        println(empleado.toString()?:"null")
        return empleado
    }

    override fun findEmpleadoByDepartamento() {
         var empleados: MutableList<Empleado> = mutableListOf()
        println("Selecciona un departamento")
        println("--------------------------")
        println("1.-RRHH")
        println("2.-Administracion")
        println("3.-Mantenimiento")
        println("4.-Logistica")
        println("5.-Marketing")
        println("6.-Comercial")
        println("7.-Finanzas")
        println("8.-Masillas")
        println("9.-Compras")
        println("10.-Direccion")
        var seleccion = readln().toInt()
        when(seleccion){
            1-> empleados = repositorio.findEmpleadoByDepartamento(Departamento(DepartamentosEnum.RRHH))
            2-> empleados = repositorio.findEmpleadoByDepartamento(Departamento(DepartamentosEnum.Administracion))
            3-> empleados = repositorio.findEmpleadoByDepartamento(Departamento(DepartamentosEnum.Mantenimiento))
            4-> empleados = repositorio.findEmpleadoByDepartamento(Departamento(DepartamentosEnum.Logistica))
            5-> empleados = repositorio.findEmpleadoByDepartamento(Departamento(DepartamentosEnum.Marketing))
            6-> empleados = repositorio.findEmpleadoByDepartamento(Departamento(DepartamentosEnum.Comercial))
            7-> empleados = repositorio.findEmpleadoByDepartamento(Departamento(DepartamentosEnum.Finanzas))
            8-> empleados = repositorio.findEmpleadoByDepartamento(Departamento(DepartamentosEnum.Masillas))
            9-> empleados = repositorio.findEmpleadoByDepartamento(Departamento(DepartamentosEnum.Compras))
            10-> empleados = repositorio.findEmpleadoByDepartamento(Departamento(DepartamentosEnum.Direccion))
        }
        println("----------------------------------------")
        if(empleados.size==0){ println("DEPARTAMENTO VACIO")}
        empleados.toString()
    }

    override fun saveEmpleado() {
        println("Introduce DNI empleado")
        val dni = readln()
        println("Introduce Nombre empleado")
        val nombre= readln()
        println("Introduce Telefono")
        val telefono = readln()
        println("Introduce Correo")
        val correo = readln()
        println("Introduce puesto")
        val puesto = readln()
        println("Selecciona un departamento")
        println("--------------------------")
        println("1.-RRHH")
        println("2.-Administracion")
        println("3.-Mantenimiento")
        println("4.-Logistica")
        println("5.-Marketing")
        println("6.-Comercial")
        println("7.-Finanzas")
        println("8.-Masillas")
        println("9.-Compras")
        println("10.-Direccion")
        var seleccion = readln().trim()
        var departamento:Departamento = Departamento(DepartamentosEnum.RRHH)
        when(seleccion){
            "1"-> departamento = Departamento(DepartamentosEnum.RRHH)
            "2"-> departamento = Departamento(DepartamentosEnum.Administracion)
            "3"-> departamento = Departamento(DepartamentosEnum.Mantenimiento)
            "4"-> departamento = Departamento(DepartamentosEnum.Logistica)
            "5"-> departamento = Departamento(DepartamentosEnum.Marketing)
            "6"-> departamento = Departamento(DepartamentosEnum.Comercial)
            "7"-> departamento = Departamento(DepartamentosEnum.Finanzas)
            "8"-> departamento = Departamento(DepartamentosEnum.Masillas)
            "9"-> departamento = Departamento(DepartamentosEnum.Compras)
            "10"-> departamento = Departamento(DepartamentosEnum.Direccion)}
        repositorio.saveEmpleado(Empleado(dni,nombre,correo,telefono,puesto,departamento))
    }

    override fun deleteEmpleadoByDNI() {
        println("Introduce el DNI")
        var dni = readln()
        repositorio.deleteEmpleadoByDNI(dni)
    }

    override fun deleteAllEmpleados() {
        repositorio.deleteAllEmpleados()
    }

    override fun saveAllEmpleados()  {
        repositorio.saveAllEmpleados()
    }
    override fun upDateEmpleado(){
        var empleado:Empleado? = findEmpleadoByDNI()
        var salir:Boolean = false
        var opcion:String = ""
        var modificacion:String = ""
        if(empleado==null){
            println("Trabajador no encontrado")}
        else {
            while (!salir) {
                println(
                    "Nombre:${empleado.nombre} TELEFONO: ${empleado.telefono} CORREO:${empleado.correo} " +
                            "PUESTO:${empleado.puesto} DEPARTAMENTO:${empleado.departamento.nombre}"
                )
                println("--------------------------------------------------------------------------------------")
                println("SELECCIONA QUE DESEAS MODIFICAR")
                println("1.- Nombre")
                println("2.- Telefono")
                println("3.- Correo")
                println("4.-Puesto")
                println("5.-Departamento")
                println("6.-Ver datos empleado")
                println("S.-Salir y guardar cambios")
                opcion = readln().trim().uppercase()
                when(opcion){
                    "1"-> {
                        println("Introduce nuevo nombre")
                        modificacion = readln()
                        empleado.nombre = modificacion
                    }
                    "2"->{
                        println("Introduce nuevo Telefono")
                        modificacion = readln()
                        empleado.telefono = modificacion
                    }
                    "3"-> {
                        println("Introduce nuevo Correo")
                        modificacion = readln()
                        empleado.correo = modificacion
                    }
                    "4"->{
                        println("Introduce nuevo Puesto")
                        modificacion = readln()
                        empleado.puesto = modificacion
                    }
                    "5"-> {
                        println("Selecciona un departamento")
                        println("--------------------------")
                        println("1.-RRHH")
                        println("2.-Administracion")
                        println("3.-Mantenimiento")
                        println("4.-Logistica")
                        println("5.-Marketing")
                        println("6.-Comercial")
                        println("7.-Finanzas")
                        println("8.-Masillas")
                        println("9.-Compras")
                        println("10.-Direccion")
                        modificacion = readln().trim()
                        var departamento:Departamento = Departamento(DepartamentosEnum.RRHH)
                        when(modificacion){
                            "1"-> departamento = Departamento(DepartamentosEnum.RRHH)
                            "2"-> departamento = Departamento(DepartamentosEnum.Administracion)
                            "3"-> departamento = Departamento(DepartamentosEnum.Mantenimiento)
                            "4"-> departamento = Departamento(DepartamentosEnum.Logistica)
                            "5"-> departamento = Departamento(DepartamentosEnum.Marketing)
                            "6"-> departamento = Departamento(DepartamentosEnum.Comercial)
                            "7"-> departamento = Departamento(DepartamentosEnum.Finanzas)
                            "8"-> departamento = Departamento(DepartamentosEnum.Masillas)
                            "9"-> departamento = Departamento(DepartamentosEnum.Compras)
                            "10"-> departamento = Departamento(DepartamentosEnum.Direccion)}
                        empleado.departamento = departamento
                    }
                    "6"->{
                        println(
                            "Nombre:${empleado.nombre} TELEFONO: ${empleado.telefono} CORREO:${empleado.correo} " +
                                    "PUESTO:${empleado.puesto} DEPARTAMENTO:${empleado.departamento.nombre}"
                        )
                    }
                    "S"-> {salir= true}
                }
                repositorio.upDateEmpleado(empleado)
            }
        }
    }
}