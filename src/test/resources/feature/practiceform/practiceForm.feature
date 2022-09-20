# language: es
Característica: Ingreso de estudiantes
    Como empleado administrativo
    necesito ingresar al sistema los estudiantes de los nuevos ciclos académicos
    con el fin de cumplir las políticas administrativas y de auditoría de la universidad.

    Antecedentes:
        Dado que el empleado administrativo se encuentra en la página web de los ingresos de estudiantes

    @Regresion
    Escenario: Ingreso de un estudiante con los campos obligatorios.
        Cuando el empleado administrativo ingresa los campos obligatorios y confirma la acción
        Entonces el sistema deberá mostrar por pantalla el registro del estudiante ingresado.

    @Regresion
    Escenario: Ingreso de un estudiante con todos los campos.
        Cuando el empleado administrativo ingresa valores a todos los campos obligatorios y confirma la acción
        Entonces el sistema deberá mostrar por pantalla el registro del estudiante ingresado con todos sus campos.