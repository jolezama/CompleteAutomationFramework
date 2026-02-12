# Prompt sugerido para implementar el orden recomendado

Actúa como un QA Automation Engineer Senior en un framework Java + Selenium + TestNG + ExtentReports.

Objetivo: implementar en este orden exacto y con cambios mínimos:

1) Corregir mapeo de configuración de URLs por aplicación.
   - Alinear `appKey()` de Heroku con la clave en `config-uat.properties` y `config-prod.properties`.
   - Debe existir `baseUrl.heroku` si `appKey()` retorna `heroku`.

2) Corregir reporte para fallos en setup/configuración.
   - Si falla `@BeforeMethod`, el reporte NO debe quedar como PASS vacío.
   - Extender listener TestNG para capturar `configuration failure/skip` y marcar estado correcto.

3) Ampliar SauceDemo con escenarios:
   - `WrongPath` dentro de la misma clase de tests de SauceDemo.
   - Nuevo flujo de compra:
     - login válido,
     - clic a todos los `//button[text()='Add to cart']`,
     - clic a `a[data-test*='shopping']`,
     - screenshot del carrito,
     - validar que cantidad de `//button[text()='Remove']` sea igual a los agregados,
     - clic a `button[id='checkout']`.

Reglas:
- No romper arquitectura actual.
- Reusar Page Objects y Actions existentes.
- Mantener nombres descriptivos en tests y nodos de reporte.
- Ejecutar pruebas/compilación para validar.
- Entregar resumen de cambios + comandos ejecutados.
