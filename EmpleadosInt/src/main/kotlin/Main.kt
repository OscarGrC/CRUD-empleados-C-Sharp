import controllers.EmpleadoControler
import models.Empleado
import repositories.RepositoryEmpleadosImp
import storage.StorageImp

fun main(args: Array<String>) {
    var salir:Boolean =false
    var seleccion:String =""
    var controlador:EmpleadoControler= EmpleadoControler(RepositoryEmpleadosImp(StorageImp()))
    while(!salir) {
        println("GESTOR DE EMPLEADOS")
        println("-------------------")
        println("1.- Imprimir empleados")
        println("2.- Encontrar empleado por DNI")
        println("3.- Imprimir empleados por Departamento")
        println("4.- Crear Empleado")
        println("5.- Borrar empleado")
        println("6.- Borrar todos los empleados")
        println("7.- Salvar todos los empleados")
        println("8.- Actualizar empleado")
        println("S.- salir")
        seleccion= readln().trim().uppercase()
        when(seleccion){
            "1"-> {controlador.findAllEmpleados()}
            "2"-> {controlador.findEmpleadoByDNI()}
            "3"-> {controlador.findEmpleadoByDepartamento()}
            "4"-> {controlador.saveEmpleado()}
            "5"-> {controlador.deleteEmpleadoByDNI()}
            "6"-> {controlador.deleteAllEmpleados()}
            "7"-> {controlador.saveAllEmpleados()}
            "8"-> {controlador.upDateEmpleado()}
            "S"-> {salir=true}
        }
    }
    println("FIN DEL PROGRAMA")
}