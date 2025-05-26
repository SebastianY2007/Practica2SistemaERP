## 📌 Información General

- **Título:** Diseño de una interfaz gráfica de usuario básica utilizando contenedores y componentes gráficos de Java AWT  
- **Asignatura:** Programación Orientada a Objetos (POO)  
- **Carrera:** Computación  
- **Estudiantes:** Sebastian Yupangui, Javier Barrezueta  
- **Fecha:** 28/04/2025  
- **Docente:** Ing. Gabriel León  

## 🎯 Objetivos de la práctica

- Implementar una interfaz gráfica funcional usando Java AWT.
- Integrar la lógica de negocio previamente desarrollada con una capa visual.
- Aplicar principios de separación de responsabilidades entre vista y lógica.
- Manejar eventos mediante clases anónimas y adaptadoras.
- Realizar pruebas funcionales de las vistas y operaciones del sistema.

## 📋 Funcionalidades

- Registro y gestión de productos (con y sin IVA).
- Registro y gestión de proveedores y personas.
- Creación y gestión de solicitudes de compra.
- Cálculo automático de subtotal, IVA y total.
- Cambio de estado de solicitudes (SOLICITADA, APROBADA, RECHAZADA).
- Validación básica de entradas y controles GUI.
- Navegación mediante un menú principal con botones de acceso.

## 🧩 Vistas Implementadas (AWT)

- `MenuPrincipal` → Navegación general del sistema  
- `ProductoView` / `ProductoConIvaView` / `ProductoSinIvaView` → Gestión de productos  
- `PersonaView` → Gestión de datos personales (empleados/clientes)  
- `ProveedorView` → Registro de proveedores  
- `DetalleDeCompraView` → Gestión de ítems de compra  
- `SolicitudCompraView` → Flujo completo de solicitudes de compra

## 🛠️ Tecnologías utilizadas

- **Java AWT**
- **POO (Programación Orientada a Objetos)**
- **Git y GitHub** para control de versiones

## 📂 Estructura del proyecto

- `views/` → Contiene todas las interfaces gráficas (AWT)
- `clases/` → Contiene las clases de dominio (Producto, Proveedor, Solicitud, DetalleCompra, etc.)
- `enums/` → Contiene el enum `EstadoSolicitud`
- `Main.java` → Punto de entrada con el menú gráfico

## 🧪 Pruebas y validación

- Verificación del correcto funcionamiento de botones y navegación.
- Pruebas funcionales con registros de productos y solicitudes.
- Validación de datos en memoria durante la ejecución.

## ✔️ Resultados Obtenidos

- Sistema completo con 7 vistas interconectadas.
- Implementación exitosa de funcionalidades clave.
- Separación clara entre lógica de negocio e interfaz gráfica.
- Colaboración efectiva mediante Git.

## 💡 Recomendaciones

- Añadir validaciones más robustas.
- Considerar migración a JavaFX para un diseño más moderno.
- Implementar persistencia de datos con archivos o bases de datos.
- Mejorar el manejo de errores con mensajes informativos.
- Incluir pruebas unitarias para las clases de lógica.
