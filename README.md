# Evaluador de Expresiones Aritméticas

Evaluador de expresiones aritméticas usando pilas - Universidad EAN Guía 3

## Descripción

Programa en Java que evalúa expresiones aritméticas en notación infija y las convierte a notación postfija (notación polaca inversa) utilizando la estructura de datos Pila implementada con listas enlazadas.

## Características

- Evaluación de expresiones aritméticas en notación infija
- Conversión de notación infija a postfija
- Soporte para operadores: +, -, *, /, ^ (potencia)
- Soporte para paréntesis
- Manejo de números decimales
- Implementación propia de la estructura de datos Pila genérica

## Estructura del Proyecto

```
evaluador-expresiones/
└── src/
    ├── Nodo.java                    # Clase genérica para nodos de lista enlazada
    ├── Pila.java                    # Implementación de pila genérica
    ├── EvaluadorExpresiones.java    # Lógica de evaluación de expresiones
    └── Main.java                    # Programa principal con menú interactivo
```

## Compilación y Ejecución

### Compilar
```bash
javac src/*.java
```

### Ejecutar
```bash
java -cp src Main
```

## Uso

Al ejecutar el programa, aparecerá un menú con las siguientes opciones:

1. **Evaluar expresión**: Ingresa una expresión aritmética y obtiene el resultado
2. **Convertir infija a postfija**: Convierte una expresión infija a notación postfija
0. **Salir**: Termina el programa

### Ejemplos

**Evaluación de expresiones:**
- `3 + 5 * 2` = 13
- `(3 + 5) * 2` = 16
- `10 / 2 + 3` = 8
- `2 ^ 3` = 8

**Conversión infija a postfija:**
- `3 + 5 * 2` → `3 5 2 * +`
- `(3 + 5) * 2` → `3 5 + 2 *`

## Complejidad Computacional

- **Apilar**: O(1)
- **Desapilar**: O(1)
- **Ver tope**: O(1)
- **Evaluación de expresión**: O(n) donde n es la longitud de la expresión

## Autor

Juan Sebastian Novoa Cepeda  
Universidad EAN - Ingeniería de Sistemas  
Guía 3 - Estructuras de Datos
