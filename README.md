# Sistema de Gestión de Usuarios en Java Swing

## 📋 Descripción
Aplicación de escritorio desarrollada en Java utilizando Swing como interfaz gráfica, que permite gestionar usuarios con conexión a una base de datos remota MySQL. Permite registrar, iniciar sesión, visualizar, actualizar y eliminar usuarios.

---

## ✅ Funcionalidades

- 📝 Registro de usuarios con validación.
- 🔐 Inicio de sesión con campos ocultos.
- 📊 Visualización de usuarios en una tabla (`JTable`).
- ✏️ Actualización de datos (excepto la contraseña).
- ❌ Eliminación de usuarios seleccionados.
- 🔁 Cierre de sesión y retorno al login.
- 🛢️ Conexión remota con base de datos MySQL.

---

## 🧪 Tecnologías utilizadas

- Java 21
- Swing (GUI)
- MySQL
- JDBC (MySQL Connector/J)

---

## 📁 Estructura del proyecto

- `UI_Formularios`: Interfaces gráficas (Login, Registro, Clientes).
- `BD`: Conexión y consultas a la base de datos (`UsuariosBD`, `Tabla`, `ConexionBD`).
- `Main`: Clase de entrada principal.

---

## 🔧 Requisitos

- Java JDK 21 o superior.
- MySQL Connector/J (agregado al classpath del proyecto).
- Acceso a la base de datos remota:


