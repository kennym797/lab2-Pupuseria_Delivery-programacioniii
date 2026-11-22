# Laboratorio III: Sistema de gestión de pupusería
**Asignatura:** Programación III  
**Docente:** Óscar Armando Contreras Álvarez  
**Grupo:** 03-B
**Repositorio:** `lab2-Pupuseria_Delivery-programacioniii`  

---

## 1. Integrantes, roles y coevaluación

| Integrante | Carnet | Concepto Técnico a Defender | Coevaluación (%) |

| Josseline Ivonne Cortez López | CL-67124-24 |Excepciones | 100% |

| Marjori Stephanie Cruz Ponce | CP- 66338-24 |Interfaz gráfica con threads | 100% |

| Kenny Diane Martínez Vega | MV-39703-16| Interfaz gráfica con Jframe | 100% |

**Enlace al tablero Kanban de gestión:** 
---

## 2. Descripción y evolución del proyecto

### Dominio del negocio y problemática
Elegimos el sistema de gestión de pedidos a domicilio para pupuserías porque identificamos que, en las horas pico, el manejo de órdenes por llamadas o mensajes de texto suele volverse un problema, generando retrasos, errores en los pedidos y pérdidas para el comercio. 

Con este sistema buscamos ofrecer una solución real y accesible que beneficie a ambas partes:
- **Para el cliente:** Facilita la toma de pedidos de manera rápida y estructurada desde su dispositivo móvil.
- **Para el negocio:** Optimiza la organización de ventas, mejora la logística de preparación en cocina (control de insumos y cantidades) y digitaliza la administración de los pedidos a domicilio.
- **Para el desarrollo y mantenimiento:** Implementa una arquitectura orientada a objetos que facilita la reutilización, validación y organización del código.


### Evolución técnica
El proyecto evolucionó desde un modelo básico de Clases y Objetos hacia una arquitectura orientada a objetos avanzada mediante:

1. **Herencia:** Implementación de una superclase Producto y sus respectivas subclases, como Pupusa y Bebida, permitiendo reutilizar atributos y comportamientos.

2. **Abstracción:** Utilización de clases y métodos abstractos para establecer una estructura común y obligar a las subclases a implementar comportamientos específicos.

3. **Polimorfismo:** Aplicación de sobrecarga (Overloading) en los métodos de gestión de pedidos y sobrescritura (Overriding) para personalizar comportamientos heredados, como el cálculo de precios y la representación de productos.

4. **Interfaces:** Implementación de la interfaz Imprimible, que establece un contrato para la generación de tickets de compra.

5. **Manejo de excepciones:** Incorporación de excepciones personalizadas, como ProductoInvalidoException y PedidoInvalidoException, para controlar situaciones inválidas, incluyendo identificadores incorrectos, nombres vacíos, precios no válidos y productos que no pueden agregarse a un pedido.

6. **Validaciones:** Implementación de controles para evitar cantidades iguales o inferiores a cero y prevenir el registro de productos nulos.

7. **Gestión de recursos:** Aplicación de AutoCloseable y la estructura try-with-resources para demostrar la administración automática de recursos.

8. **Interfaz gráfica:** Integración de Java Swing mediante la clase VentanaPupuseria, permitiendo iniciar el sistema desde una interfaz gráfica.

---

## 3. Estructura del proyecto
```text

---
lab2-Pupuseria_Delivery-programacioniii/
│
├── .gitignore
├── README.md
│
└── src/
    │
    ├── excepciones/
    │   ├── PedidoInvalidoException.java
    │   └── ProductoInvalidoException.java
    │
    ├── interfaces/
    │   └── Imprimible.java
    │
    ├── main/
    │   └── Main.java
    │
    ├── modelo/
    │   ├── Bebida.java
    │   ├── Pedido.java
    │   ├── Producto.java
    │   ├── Pupusa.java
    │   └── RecursosPedido.java
    │
    └── vista/
        └── VentanaPupuseria.java

```

Descripción de los paquetes:

**excepciones:** Contiene las clases encargadas de gestionar los errores y validaciones del sistema.

**interfaces:** Define los contratos de comportamiento que implementan las clases.

**main:** Contiene el punto de entrada de la aplicación.

**modelo:** Contiene las entidades principales, la lógica de productos y pedidos, y la gestión de recursos.

**vista:** Contiene la interfaz gráfica desarrollada con Java Swing.

##4. Tecnologías utilizadas

-Java: Lenguaje principal de desarrollo

-Java Swing: Desarrollo de la interfaz gráfica

-Programación Orientada a Objetos: Estructuración de clases y componentes

-Git: Control de versiones

-GitHub: Repositorio y colaboración del equipo

-GitHub Projects: Gestión de tareas mediante Kanban

-IntelliJ IDEA: Entorno de desarrollo

## 5. Instrucciones de compilación y ejecución
### Requisitos
- Java JDK 17 o superior.
- IntelliJ IDEA o un entorno compatible con proyectos Java.
- Git instalado.

### 5.1. Obtener la versión final del proyecto

Para descargar la versión final del sistema, es necesario clonar específicamente la rama `integracion-final`, ya que contiene la integración de las funcionalidades de programación orientada a objetos, manejo de excepciones e interfaz gráfica.

Ejecutar el siguiente comando:

```bash
git clone -b integracion-final --single-branch https://github.com/kennym797/lab2-Pupuseria_Delivery-programacioniii.git
```

Este comando descarga directamente la rama `integracion-final`, evitando utilizar la rama `main`.

### 5.2. Compilar el proyecto

Ingresar a la carpeta del repositorio:

```bash
cd lab2-Pupuseria_Delivery-programacioniii
```

Crear la carpeta de compilación:

```bash
mkdir bin
```

Compilar los archivos Java:

```bash
javac -d bin src/excepciones/*.java src/interfaces/*.java src/modelo/*.java src/vista/*.java src/main/Main.java
```

### 5.3. Ejecutar la aplicación

Iniciar el sistema mediante el siguiente comando:

```bash
java -cp bin main.Main
```

Al ejecutar la aplicación, se iniciará la interfaz gráfica de la pupusería desarrollada con Java Swing.

**Importante:** Para garantizar la ejecución de la versión final, se debe utilizar la rama `integracion-final` y no la rama `main`.

## 6. Control de versiones e integración

Durante el desarrollo se trabajó mediante ramas independientes para distribuir las responsabilidades y facilitar la colaboración entre los integrantes.

Posteriormente, se realizó la integración de los componentes desarrollados, resolviendo conflictos de código y unificando las funcionalidades en la rama final **integracion-final.**

Las principales ramas de trabajo incluyeron:

-integracion-final

-integrante1-excepciones

-integrante3-hilos

-interfazGrafica

La integración permitió consolidar los módulos de programación orientada a objetos, excepciones e interfaz gráfica en una versión final del proyecto.

## 7. Nota sobre el uso de herramientas de IA
- **Herramientas utilizadas:** ChatGPT / Gemini.
- **Propósito:** Apoyo en la estructuración de documentación Markdown, orientación técnica, revisión de código y generación de estructuras base para pruebas.
- **Validación:** El código fue revisado, ajustado e integrado por los integrantes del equipo. Se realizaron pruebas de compilación y ejecución local para verificar el funcionamiento de la aplicación.


**Versión final:** Laboratorio III - Sistema de gestión de pupusería.
**Estado:** Integración final completada y aplicación ejecutada satisfactoriamente.
