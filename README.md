# E5MDGonzalezCristian
Se desea realizar una app que permita registrar datos relativos a un proceso de selección de un
hospital.
El hospital quiere contratar a una serie de personas, para las especialidades de las que necesite
personal. Para ello va a crear una herramienta que va a permitir introducir la información a los
posibles candidatos.
La información que se va a almacenar or cada candidato es.
DNI
Nombre-Apellidos
Año de Titulación
Código especialidad
Reglas de negocio:
1. Todos los campos son obligatorios
2. El año de Titulación del máster o grado que le permite ejercer en esa especialidad
3. Una persona solo puede estar una vez en el proceso.
4. El hospital nos indica las especialidades en las que existen plazas. Por cada una de ellas
tiene almacenado en memoria los siguientes datos:
Código especialidad: Numérico
Nombre especialidad: Alfanumérico
Número de plazas
Las especialidades estarán en una colección de datos inmutable.

Se pide:

1.En la actividad Inicio, existirá una imagen con el logotipo del Hospital (se deberá cargar
de Internet usando Glide) una etiqueta que contendrá el nombre del alumno/na.
Realizando una pulsación corta sobre la imagen se irá a la activity de Registro.
2. La activity Registro, es donde se registran los datos de los candidatos.

 En cada campo de texto existirá la posibilidad de borrar la información introducida.

 Para facilitar el código de la especialidad al lado del campo de texto (etiqueta)
existirá un botón que irá a la activity de Información.

3.En la activity de Información se mostrará en un recyclerView la información de
las especialidades y cuando el usuario realice una pulsación larga sobre una
especialidad devolverá a la activity de Registro, la información que necesite.
4.En la activity Registro también existirá 3 botones:

 Registrar la solicitud

 Cancelar la solicitud

 Finalizar la app

Los datos de los candidatos(personas) se guardarán en una colección mutable.
