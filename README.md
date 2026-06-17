# SauceDemo Automation - Playwright + Cucumber + Maven

Proyecto de automatización para validar el flujo de compra en Sauce Demo utilizando **Playwright**, **Cucumber** y **Page Object Model (POM)**.

## Historia de Usuario

Como un cliente de Sauce Demo,  
Quiero poder iniciar sesión, agregar productos al carrito y completar una compra  
Para poder adquirir los productos que necesito.

---

## Tecnologías usadas

- Java 17
- Maven
- Playwright
- Cucumber
- JUnit
- IntelliJ IDEA

---

## Estructura del proyecto

```text
src
├── test
│   ├── java
│   │   ├── hooks
│   │   ├── pages
│   │   ├── runners
│   │   └── stepdefinitions
│   └── resources
│       └── features
```

---

## Patrones aplicados

- **Page Object Model (POM)** para separar lógica de negocio y localizadores.
- **Hooks** para inicialización y cierre del navegador.

---

## Escenarios cubiertos

### Login

- Inicio de sesión exitoso con `standard_user`
- Validación de acceso denegado con `locked_out_user`

### Carrito

- Agregar producto al carrito
- Validar producto agregado en carrito

### Checkout

- Completar compra exitosamente
- Validar confirmación de compra

---

## Credenciales usadas

### Usuario estándar

```text
standard_user / secret_sauce
```

### Usuario bloqueado

```text
locked_out_user / secret_sauce
```

---

## Instalación del proyecto

Clonar repositorio:

```bash
git clone <URL_DEL_REPOSITORIO>
```

Ingresar al proyecto:

```bash
cd automation
```

Instalar dependencias:

```bash
mvn clean install
```

Instalar navegadores Playwright:

```bash
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

---

## Ejecutar pruebas

Ejecutar todos los escenarios:

```bash
mvn test
```

---

## Reportes

Los reportes se generan en:

```text
target/cucumber-report.html
```

Para abrir el reporte:

1. Ir a la carpeta `target`
2. Abrir `cucumber-report.html` en el navegador

---