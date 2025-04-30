# Reto Técnico: Procesamiento de Transacciones Bancarias (CLI)

## Autor:
Brigitte Arely Champi Paredes
DNI: 70991422

 ## Introducción: 
 Elaborar un programa para obtener el Balance final, la transacción mas alta identificando el ID y monto de la misma así como el Numero de transacciones entre créditos y débitos.

## Consideraciones: 
 Balance = Suma de los montos de créditos - Suma de los montos de débito

## Instrucciones

1. **Repositorio Base:**  
   Clona o haz un fork del repositorio base disponible en:  
   `https://github.com/codeableorg/interbank-academy-25`

2. **Entrada de Datos:**  
   La aplicación deberá leer el archivo data.csv
   - Estructura:
     - id,tipo,monto
     - 1,Crédito,100.00

3. **Salida del Programa:**  
   - Estructura:
   Reporte de Transacciones
   ---------------------------------------------
   Balance Final: 10985,85 
   Transacción Mayor: 
   ID: 222  -  MONTO: 499,69 
   Conteo total de Transacciones: 1000
   Transacciones de Crédito: 508 -  Transacciones de Débito: 492

4. **Lenguaje de Programación:**  
   - Java
   - openjdk version "21.0.7"

5. **Enfoque y Solución:**
La aplición fue desarrollada con un enfoque directo, toda la lógica fue implemetada en el main. No hay métodos auxiliares. 

   1. Se inicia con la lectura del archivo CSV con la clase Scanner
   2. La lectura se realiza linea por linea, considerando que se debe omitir la línea de encabezado.
   3. Cada Linea del archivo debe ser dividida en columnas segun: ID - TIPO - MONTO.
   4. Segun el TIPO podemos sumar o restar los montos para el balance asi como realizar el conteo de las transacciones para cada uno.
   5. Se realiza una comparación con el monto mayor registrado hasta que se ubique la transacción mas grande.
