# Refactoring & Clean Code - Unidad 11

## Análisis Comparativo de Métricas (SonarQube)

| Métrica | Antes de Refactorizar | Después de Refactorizar |
| :--- | :--- | :--- |
| **Code Smells Totales** | X | Y (Reducción notable) |
| **Complejidad Ciclomática (CC)** | Alta (múltiples `if/else`, bucles) | Baja (Métodos de CC=1 o 2) |
| **Deuda Técnica (TDR)** | X horas/minutos | Y horas/minutos |

## Técnicas de Refactorización Aplicadas

1. **Value Object (Eliminación de Primitive Obsession):**
   Se encapsuló la larga lista de parámetros primitivos del cliente en una clase inmutable `DatosCliente` (que a su vez compone a `Direccion`). Esto agrupó la validación del estado en el constructor.
2. **Extract Class (Separación de Responsabilidades):**
   La lógica de impresión/envío de correos se extrajo a una nueva clase `NotificacionService`, cumpliendo el Principio de Responsabilidad Única (SRP).
3. **Extract Method (Reducción de Long Method):**
   El método `procesarPedido` se dividió en métodos privados más pequeños (`calcularTotal`, `aplicarDescuento`, `persistirPedido`). Ahora el método principal actúa solo como un orquestador fácil de leer.
4. **Inyección por Constructor:**
   Se eliminó el uso de `@Autowired` sobre campos, garantizando la inmutabilidad de las dependencias (`final`).

