# CRUD PRODUCTOS POO SPRING BOOT

Crud para una tabla de productos con variables "Id", "Nombre" y "Precio", almacenados en Base de datos "producto"

## Comenzando 🚀

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.



### Pre-requisitos 📋

_Que cosas necesitas para desplegar el proyecto_

```
-Crear base de datos llamada producto en MySQL 
-Realizar configuracion de username y password en application.yaml para utilizar la base de datos creada
-MySQL y Apache iniciados.
-Instalar POSTMAN
```
### Pasos para desplegar el proyecto

* Clonar el proyecto https://github.com/hernanCelyNivelics/crud-productos.git
* Abrir el proyecto con [IntelliJ](https://www.jetbrains.com/es-es/idea/) y esperar que lo indexe
* Modificamos el archivo application.yaml con los datos de acceso a MySQL
* Hecho esto, procedemos a darle run al proyecto. Se ejecutara spring y correra el servidor.
* Abrimos POStMAN y añadimos una nueva coleccion.
* Creamos las cuatro peticiones Agregar[Post],Editar[POST],Mostrar[GET],Eliminar[POST]
* Introducimos la direccion del proyecto http://localhost:8080/api/v1/productos
* Vamos a la pestaña body y seleccionamos el formato JSON
* Creamos nuestro formato con los datos que queremos ingresar.

```
{
    "nombre": "Arroz",
    "precio": "31330"
}
```
* le damos en el boton send, si todo esta bien nos arrojara un status 200 y abajo se mostrara los datos que fueron enviados.

<div>
<p style = 'text-align:center;'>
<img src="https://ibb.co/dP4LtSJl" alt="POSTMAN" width="600px">
</p>
</div>

* Se hace el mismo procesos para el mostrar, editar,eliminar

## Ejecutando las pruebas ⚙️

Prubas realizadas con Postman.

Para *Agregar-Actualizar-Eliminar-Listar* los registros.

## Construido con ️ ⚙️

* [POSTMAN](https://www.postman.com/)-Para probar solicitudes POST-GET
* [IntelliJ](https://www.jetbrains.com/es-es/idea/) - El IDE usado
* [Spring](https://spring.io/) - El framework usado

## Versionado 📌

Usamos [github](https://github.com/) para el versionado. Repositorio [crud-productos](https://github.com/hernanCelyNivelics/crud-productos.git)
