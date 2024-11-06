# Laboratorio 02- Patterns
*Integrantes:*

*-Jaider David Vargas Noriega.*

*-Laura Sofia Gil Chaves.*

## Preguntas
### -¿Cuál es su mayor utilidad?

La herramienta Maven nos ayuda a facilitar y optimizar procesos de desarrollo y hacerlos en el menor tiempo posible. Además, nos proporciona sistema de información de proyectos y contrucción de calidad para así lograr buenas prácticas. 

### -Fases de maven:

![image](https://github.com/user-attachments/assets/d23f6ad4-13e9-4b32-957a-b52e2ad3f274)

*Maven Validate*: Verifica la configuración y estructura de un proyecto sea correcta, validando que todas las dependencias esten disponibles.
```console
mvn validate
```
*Maven Compile:* Compila el código fuente del proyecto. Esto incluye la verificación de sintaxis y semántica.
```console
mvn compile
```

*Maven Test:* Ejecuta las pruebas unitarias, que son escenciales para garatizar el comportamiento esperado. 
```console
mvn test
```

*Maven Package:* Encapsula el código compilado y los recursos asociados en un formato de distribución.
```console
mvn package
```

*Maven Integrartion Test:*  Hace pruebas de integración que verifican la interracion entre diferentes servicios dentro del proyecto.
```console
mvn integration-test
```

*Maven Verify:* Válida el empaquetamiento del código, comprobando  que cumple los lineamientos de calidad. 
```console
mvn verify
```

*Maven Install:*  Instala el empaquetamiento del código del repositorio local de Maven, permitiendo que se reutilize como dependencia en otros proyectos.
```console
mvn install
```

*Maven Deploy:* Despliega el código a un repositorio remoto o a un entorno de producción para ser ejecutado.
```console
mvn deploy
```

### -Ciclo de vida de la construcción:

Existen 3 ciclos de vida de contrucción principales:

*Default o build*: Este ciclo construye, prueba, empaqueta, e instalar un proyecto. 

*Clean:* Maneja la limpieza del proyecto, eliminando compilaciones previas. 

*Site:* Genera la documentación del proyecto.

### -¿Para qué sirven los plugins?
Los plugins amplia las funcionalidades a las aplicaciones web, permitiendo al usuario personalizar sin modificar el código fuente. 

### -¿Qué es y para qué sirve el repositorio central de maven?

Es un repositorio público que contiene varias colecciones de biblotecas para usar en los proyectos de Maven de manera centralizada y automatizada. Nos sirve para gestión de versiones, plugins y acceso de dependencias.

# EJERCICIO DE LAS FIGURAS
## CREAR UN PROYECTO CON MAVEN

Realizamos la búsqueda de cómo se crea el proyecto maven con ayuda de arquetipos. Además, cómo ejecutar desde línea de comandos el objetivo "generate" del plugin "archetype",con los siguientes parámetros:
```console
Grupo: edu.eci.cvds
Id del Artefacto: Patterns
Paquete: edu.eci.cvds.patterns?
archetypeArtifactId: maven-archetype-quickstart
```

Para visualizar la estructura usamos el comando:
*cd Patterns
tree /f*

![image](https://github.com/user-attachments/assets/e1998679-5bcb-4c01-8987-318dd792ebc7)

## AJUSTAR ALGUNAS CONFIGURACIONES EN EL PROYECTO

Cambiamos la versión del compilador de Java a la versión 8, para ello, agregamos la sección properties antes de la sección de dependencias:

![image](https://github.com/user-attachments/assets/70ebdfd6-f22c-438a-9d1b-86beb440fdfc)

## COMPILAR Y EJECUTAR
Para compilar el proyecto de maven se usa el comando:

```console
mvn package
```

Buscamos cómo ejecutar desde línea de comandos un proyecto maven:

Desde CMD
```console
mvn exec:java -Dexec.mainClass="edu.eci.cvds.patterns.App"
```
![image](https://github.com/user-attachments/assets/6a10e2a5-0b87-465c-a96d-1e1594d53bc9)

Desde InteliJ
```console
mvn exec:java -Dexec.mainClass="edu.eci.cvds.patterns.App -Dexec.args='argument1' 'argument2'
```
![image](https://github.com/user-attachments/assets/1cbd6998-f814-4729-883a-bb2d7ad61e4b)

Realizamos el cambio en la clase App.java para crear un saludo personalizado, basado en los parámetros de entrada a la aplicación.

![image](https://github.com/user-attachments/assets/895104aa-113c-4753-a91d-7793c011a55d)

Buscamos cómo enviar parámetros al plugin "exec".

![image](https://github.com/user-attachments/assets/b1b822e5-2776-44e9-a091-66cc12237133)

### Ejecutar la clase con su nombre y apellido como parámetro. ¿Qué sucedió?

Lo que sucecedió fue que solo imprimió el primer nombre del primer elemento del arreglo, debido a esto, para esto se utilizó un condicional
para que resultará el nombre y apellido.

## HACER EL ESQUELETO DE LA APLICACIÓN
Realizamos el esqueleto según el laboratorio:

![image](https://github.com/user-attachments/assets/6a11048c-deab-46fa-bba5-1d15ec0dc5d3)

Ejecutamos múltiples veces la clase ShapeMain, usando el plugin exec de maven con los siguientes parámetros y verificamos la salida en consola para cada una:

Sin parámetros:

![image](https://github.com/user-attachments/assets/f85401b2-bd97-4940-b96f-9d813cc3df23)

![image](https://github.com/user-attachments/assets/8c13c87f-900b-4b38-b4a5-d72f990ab87e)

Parámetro qwerty:

![image](https://github.com/user-attachments/assets/3fa48f6c-5b58-4f08-b6b8-8b03f12619a3)

![image](https://github.com/user-attachments/assets/10ef111f-f535-43ee-b400-ace1f8081d8b)


Parámetro pentagon: 

![image](https://github.com/user-attachments/assets/f0394cb2-e957-46df-bd06-53b9e0ed2136)

![image](https://github.com/user-attachments/assets/9c385fac-d291-44c1-9cb0-9b7ac4253248)


Parámetro Hexagon:

![image](https://github.com/user-attachments/assets/fbf454f3-14ce-4b27-904e-47468cc85772)

![image](https://github.com/user-attachments/assets/5d8553cf-5a2f-4ee2-a15b-25e4491753be)

### ¿Cuál(es) de las anteriores instrucciones se ejecutan y funcionan correctamente y por qué?

Cuando no se ingresa parámetros o el tipo no está dentro de la lista de figuras manejadas, el programa se ejecuta, pero no funciona correctamente ya que las entradas no son válidas y se lanza una excepción. En caso de que el tipo este dentro de las figuras manejadas entonces el programa se ejecuta y funciona correctamente como lo fue pentagon y Hexagon.

### Investigue para qué sirve "gitignore" y cómo se usa.

El *.gitignore* se itiliza para indicar que los archivos y/o directorios no se deben buscar, ni incluir en el repositorio.
Se utiliza:
1. Crean el .gitingnore en la raíz del proyecto.
2. Se agrega el arquetipo a los archivos o directorios a ignorar. Lo más utilizados son

   -*.log
   
   -node_modules/
   
   -.env
   
3. Guardar el archivo.

### Referencias:
-https://eusebiorubio.es/fases-de-maven-explicadas-en-un-grafico/

-https://www.atlassian.com/git/tutorials/saving-changes/gitignore 
