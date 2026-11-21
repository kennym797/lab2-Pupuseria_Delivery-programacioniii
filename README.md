# Laboratorio III: Sistema de gestión de pupusería
**Asignatura:** Programación III  
**Docente:** Óscar Armando Contreras Álvarez  
**Grupo:** 03-B
**Repositorio:** `lab2-Pupuseria_Delivery-programacioniii`  

---

## 1. Integrantes, roles y coevaluación

| Integrante | Carnet | Concepto Técnico a Defender | Coevaluación (%) |

| **Josseline Ivonne Cortez López** | CL-67124-24 |Excepciones | 100% |

| **Marjori Stephanie Cruz Ponce**  | CP- 66338-24 |Interfaz gráfica con threads | 100% |

| **Kenny Diane Martínez Vega** | MV-39703-16| Interfaz gráfica con Jframe  | 100% |

**Enlace al tablero Kanban de gestión:** https://github.com/users/kennym797/projects/1
---

## 2. Descripción y evolución del proyecto

### Dominio del negocio y problemática
Elegimos el sistema de gestión de pedidos a domicilio para pupuserías porque identificamos que, en las horas pico, el manejo de órdenes por llamadas o mensajes de texto suele volverse un problema, generando retrasos, errores en los pedidos y pérdidas para el comercio. 

Con este sistema buscamos ofrecer una solución real y accesible que beneficie a ambas partes:

-Para el cliente: Facilita la toma de pedidos de manera rápida y estructurada desde una interfaz gráfica intuitiva.
-Para el negocio: Optimiza la organización de ventas, mejora la logística de preparación en cocina (control de insumos y cantidades) y digitaliza la administración de los pedidos a domicilio.

Nos motiva aplicar los conocimientos de Programación Orientada a Objetos en un caso de estudio real que impulse y modernice la operatividad del comercio local salvadoreño.

### Evolución técnica
El proyecto evolucionó desde un modelo básico de Clases y Objetos hacia una arquitectura orientada a objetos avanzada mediante:
1. **Herencia:** Estructuración de superclases y subclases para la reutilización eficiente de código.
2. **Abstracción:** Implementación de clases y métodos abstractos que obligan a definir comportamientos específicos según el tipo de producto.
3. **Polimorfismo:** Implementación de sobrecarga (*overloading*) de métodos para la toma flexibilizada de pedidos y sobrescritura (*overriding*) con ligadura dinámica.
4. **Interfaces:** Contratos polimórficos para la estandarización e impresión de comprobantes/tickets de compra.
5. **Manejo de Excepciones (Lab III):** Control de errores en tiempo de ejecución mediante bloques try-catch, propagación con throw y throws, creación de excepciones personalizadas para reglas del dominio (como cantidades o precios inválidos) y liberación segura de recursos con finally o try-with-resources.
6. **Iterfaz Gráfica Swing (Lab III):** Ventana principal desarrollada con JFrame (VentanaPupuseria) que integra formularios de registro de pedidos, botones, campos de texto y cuadros de diálogo JOptionPane para mostrar tickets, confirmaciones y mensajes de excepción al usuario.
7. **Programación Concurrente con Hilos (Lab III):** Ejecución de tareas en segundo plano mediante Thread o Runnable (por ejemplo, simulación del tiempo de preparación/envío o guardado asíncrono de pedidos) sin bloquear la interfaz gráfica.

---

## 3. Estructura del proyecto
```text
lab2-Pupuseria_Delivery-programacioniii/
├── .gitignore
├── README.md
└── src/
    ├── interfaces/
    │   └── Imprimible.java
    ├── main/
    │   └── Main.java
    ├── modelo/
    │   ├── Bebida.java
    │   ├── Pedido.java
    │   ├── Producto.java
    │   └── Pupusa.java
    └── vista/
        └── VentanaPupuseria.java
```

---

## 4. Instrucciones de compilación y ejecución
1. **Requisito:** Java JDK 17 o superior.
2. **Compilar:**
   ```bash
   mkdir -p bin
    javac -d bin src/interfaces/*.java src/modelo/*.java src/vista/*.java src/main/Main.java

   ```
3. **Ejecutar:**
   ```bash
   java -cp bin main.Main
   ```

---

## 5. Nota sobre el uso de herramientas de IA
- **Herramientas utilizadas:** ChatGPT / Gemini.
- **Propósito:** Apoyo en la estructuración de plantillas Markdown para la documentación y generación del esqueleto base de pruebas en `Main.java`.
- **Validación:** El código fue revisado, ajustado a la arquitectura del dominio del proyecto y verificado mediante compilación local previa al Demo Day.
