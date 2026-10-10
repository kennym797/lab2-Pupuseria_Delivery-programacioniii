# Laboratorio II: Sistema de gestión de pupusería
**Asignatura:** Programación III  
**Docente:** Oscar Armando Contreras Álvarez  
**Grupo / Sección:** LG-016  
**Repositorio:** `lab2-Pupuseria_Delivery-programacioniii`  

---

## 1. Portada, asignación de roles y coevaluación

| Integrante | Carnet | Concepto Técnico a Defender | Coevaluación (%) |

| **Angel André Mendoza Majano** | MM-69749-25 | Herencia y Superclases | 100% |
|**Josseline Ivonne Cortez Lopez** | CL-67124-24 | Clases Abstractas | 100% |
| **Marjori Stephanie Cruz Ponce**  | CP- 66338-24 | Polimorfismo (Sobrecarga / Sobrescritura) | 100% |
| **Cristhofer Alexis Guevara Rosales**  | GR-69915-25 | Interfaces | 100% |
| **Kenny Diane Martinez Vega** | MV-39703-16| Integración (Main), Flujo y Gestión Kanban | 100% |

**Enlace al tablero Kanban de gestión:** https://github.com/users/kennym797/projects/1
---

## 2. Descripción y evolución del proyecto

### Dominio del negocio y problemática
Elegimos el sistema de gestión de pedidos a domicilio para pupuserías porque identificamos que, en las horas pico, el manejo de órdenes por llamadas o mensajes de texto suele volverse un problema, generando retrasos, errores en los pedidos y pérdidas para el comercio. 

Con este sistema buscamos ofrecer una solución real y accesible que beneficie a ambas partes:
- **Para el cliente:** Facilita la toma de pedidos de manera rápida y estructurada desde su dispositivo móvil.
- **Para el negocio:** Optimiza la organización de ventas, mejora la logística de preparación en cocina (control de insumos y cantidades) y digitaliza la administración de los pedidos a domicilio.

Nos motiva aplicar los conocimientos de Programación Orientada a Objetos en un caso de estudio real que impulse y modernice la operatividad del comercio local salvadoreño.

### Evolución técnica
El proyecto evolucionó desde un modelo básico de Clases y Objetos hacia una arquitectura orientada a objetos avanzada mediante:
1. **Herencia:** Estructuración de superclases y subclases para la reutilización eficiente de código.
2. **Abstracción:** Implementación de clases y métodos abstractos que obligan a definir comportamientos específicos según el tipo de producto.
3. **Polimorfismo:** Implementación de sobrecarga (*overloading*) de métodos para la toma flexibilizada de pedidos y sobrescritura (*overriding*) con ligadura dinámica.
4. **Interfaces:** Contratos polimórficos para la estandarización e impresión de comprobantes/tickets de compra.

---

## 3. Estructura del proyecto
```text
lab2-[nombreequipo]-programacioniii/
├── .gitignore
├── README.md
└── src/
    ├── interfaces/
    │   └── Imprimible.java
    ├── main/
    │   └── Main.java
    └── modelo/
        ├── Bebida.java
        ├── Pedido.java
        ├── Producto.java
        └── Pupusa.java
```

---

## 4. Instrucciones de compilación y ejecución
1. **Requisito:** Java JDK 17 o superior.
2. **Compilar:**
   ```bash
   javac -d bin src/modelo/*.java src/interfaces/*.java src/main/Main.java
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
