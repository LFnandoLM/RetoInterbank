# Procesamiento de Transacciones Bancarias (CLI)

## Introducción
Este proyecto procesa transacciones bancarias desde un archivo CSV y genera un reporte con:
- **Balance Final**: Diferencia entre "Créditos" y "Débitos".
- **Transacción de Mayor Monto**: La transacción con el mayor valor.
- **Conteo de Transacciones**: Conteo total de créditos y débitos.

---

## Estructura del Proyecto
```
    /RetoInterbank
    ├── docs                           # documentación javadoc
    ├── resources
    │   └── data.csv                  # datos de transacciones .CSV 
    ├── src
    │   └── com
    │       └── bancaProceso
    │           ├── model
    │           │   └── Transaccion.java          
    │           ├── service
    │           │   └── ProcesoContable.java      
    │           ├── utils
    │           │   └── LeerDataCsv.java          
    │           └── App.java                      
    └── README.md                       # información del proyecto
```

---

## Instrucciones de Ejecución

### Requisitos

- Java 8+ instalado en tu máquina: puedes instalar el jdk 8 aquí:
[jdk-8u291-windows-x64](https://drive.google.com/drive/folders/1ONhieXDxfoG_HL8N2anc0izYhFcwRNJM?usp=sharing)

#### pudes agregar javac como variable de entorno de la siguiente manera:
-copia tu ruta bin de java: 
```
    C:\Program Files\Java\jdk1.8.0_291
```
-ve a inicio -> variables de entorno -> editar variables de entorno -> variable de entorno
-en la seccion variables de sistema busca Path -> editar -> nuevo -> pegar ruta bin

#### usando solo ruta bin
- puedes reemplazar el comando javac por simplemente la ruta bin
```
    C:\Program Files\Java\jdk1.8.0_291
```

- (opcional) tener instalado visual studio code

## Instalación y Ejecución

Clona o descarga el repositorio:
```
    git clone https://github.com/LFnandoLM/RetoInterbank
```

Verifica la instalación de java:
```
    java -version
```

Accede a la carpeta RetoInterbank:
```
    cd RetoInterbank
```

Primero compila con el comando:
```
    javac -d bin src/com/bancaProceso/model/Transaccion.java src/com/bancaProceso/service/ProcesoContable.java src/com/bancaProceso/utils/LeerDataCsv.java src/App.java
```
(sin variable de entorno) compilar con ruta bin
```
    "C:\Program Files\Java\jdk1.8.0_291" -d bin src/com/bancaProceso/model/Transaccion.java src/com/bancaProceso/service/ProcesoContable.java src/com/bancaProceso/utils/LeerDataCsv.java src/App.java
```


Finalmente, Ejecuta el programa:
```
    java -cp bin App
```

---

## CLASES 

### Clase Transaccion (model)

Esta clase representa una transaccion bancaria. 

#### atributos:

- **id**: identificador.
- **tipo**: tipo de transacción (Crédito o Débito).
- **monto**: monto de la transacción.

#### Métodos principales:

- **getId()**: Retorna el ID de la transacción.
- **getTipo()**: Retorna el tipo de la transacción.
- **getMonto()**: Retorna el monto de la transacción.

### Clase LeerDataCsv (Utils)

Lee el archivo CSV línea por línea usando Scanner y convierte los datos en objetos Transaccion.

#### Método principal:

- **leerCsv(String rutaDataCsv)**: Lee el archivo CSV desde la ruta especificada y devuelve una lista de objetos de tipo Transaccion.

### Clase ProcesoContable (Lógica de procesamiento)

Implementa la lógica para procesar las transacciones.
Calcular el balance final, transacción con el mayor monto y la cantidad de transacciones ( "Crédito", "Débito").

#### Método principal:

- **procesandoCsv(List<Transaccion> transacciones)**: Procesa las transacciones, calcula el balance, identifica la transacción con el mayor monto y cuenta las transacciones de tipo "Crédito" y "Débito".

### Clase App (Ejecutable)

La clase principal que ejecuta el programa. Lee el archivo CSV utilizando LeerDataCsv, luego pasa la lista de transacciones a ProcesoContable para generar el reporte final.

---

### Diseño

- **BigDecimal**: Se utiliza BigDecimal para manejar los montos de las transacciones, ya que proporciona una mayor precisión al momento de manejar valores monetarios, esto evita perdida de datos o valores.

- **Modularización**: El código está pensado para que pueda ser manejado por clases con responsabilidades específicas, lo que mejora la organización, reutilización del código y lo hace mas legible.

- **Lectura CSV**: Se utiliza Scanner para leer el archivo CSV, asegurandose que el archivo se cierre adecuadamente después de la lectura mediante scan.close(), además de manejar los valores con el parámetro "UTF-8".

---

### Documentación y Calidad del Código
- El código se encuentra documentado, con comentarios en cada clase y método.
- Los nombres de variables y métodos son descriptivos.
- Se maneja excepciones en la lectura del archivo, evitando fallos del programa (IOExeption).
