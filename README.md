# Sistema de Gestión de Personal - Clínica Privada

Este proyecto es un sistema de consola desarrollado en Java para automatizar el registro y control del personal (Médicos y Administrativos) de una clínica privada. Permite realizar operaciones CRUD, calcular pagos y mostrar estadísticas generales del sistema.

## Aplicación de Conceptos de Programación Orientada a Objetos (POO)

De acuerdo a los requerimientos de la tarea integradora, a continuación se explica cómo se aplicaron los pilares de POO y validaciones dentro del código:

### 1. Herencia
Se implementó creando una clase abstracta padre llamada `Empleado` que agrupa los atributos comunes de todo el personal (cédula, nombre, edad, teléfono, correo). De esta clase heredan (`extends`) las subclases `Medico` y `Administrativo`, las cuales añaden sus propios atributos específicos (como especialidad, departamento y horas trabajadas) aprovechando el código ya escrito en la clase padre.

### 2. Encapsulamiento
Se protegió la información declarando todos los atributos de las clases del modelo (`Empleado`, `Medico`, `Administrativo`) con el modificador de acceso `private`. Esto asegura que los datos no puedan ser alterados directamente desde otras clases. El acceso y modificación se realiza de manera controlada y estricta a través de métodos `getters`, `setters` y los constructores.

### 3. Polimorfismo
El polimorfismo se evidencia en el uso de una lista dinámica `ArrayList<Empleado>` dentro de la clase `EmpleadoServicio`. Esta lista es capaz de almacenar tanto objetos `Medico` como `Administrativo`. Al iterar la lista y llamar a métodos como `calcularPago()` o `mostrarInformacion()`, el sistema determina en tiempo de ejecución qué versión del método utilizar, dependiendo del tipo de objeto instanciado.

### 4. Excepciones
Se utilizaron bloques `try-catch` dentro de la clase utilitaria `Validador` para controlar errores en tiempo de ejecución. Específicamente, se captura la excepción `NumberFormatException` para evitar que la aplicación se detenga abruptamente si el usuario ingresa letras o caracteres especiales en entradas donde se esperan valores numéricos (como las opciones del menú, la edad o el valor de la consulta).

### 5. Conversiones
Para transformar las entradas de texto plano provenientes de la clase `Scanner` hacia los tipos de datos primitivos requeridos por el modelo, se aplicaron conversiones explícitas obligatorias:
- Se utilizó `Integer.parseInt()` para convertir cadenas de texto a enteros (ej. edad, pacientes atendidos, horas trabajadas).
- Se utilizó `Double.parseDouble()` para convertir cadenas de texto a decimales (ej. valor de consulta, valor por hora).

### 6. Validaciones
Para asegurar la integridad de los datos, se establecieron bucles de validación (`while`) que impiden el registro de información incorrecta:
- **Menú:** Se muestra un mensaje de error y se vuelve a solicitar el dato si se ingresan letras o números fuera del rango.
- **Campos de texto:** No se permite dejar vacíos el nombre, correo, especialidad o departamento.
- **Edad:** Restringida a un rango válido (mayor a 0 y menor a 150).
- **Cédula:** Se valida en la lista para impedir el registro de duplicados (se bloquea y avisa al usuario).
- **Correo:** Se fuerza a que contenga el carácter `@`.
- **Teléfono:** Se verifica que la cadena ingresada contenga únicamente dígitos numéricos.
- **Datos de negocio:** Los pacientes atendidos, horas trabajadas y valores monetarios deben ser estrictamente mayores a cero.

---

## Autor
* **Gregory Alejandro Araujo Ayala**
* Escuela Politécnica Nacional (EPN) - ESFOT
* Tecnología Superior en Desarrollo de Software
