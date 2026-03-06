public class EvaluadorExpresiones {
    
    // Determinar precedencia de operadores
    private static int precedencia(char operador) {
        switch (operador) {
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    
    // Realizar operación aritmética
    private static double aplicarOperacion(double a, double b, char operador) {
        switch (operador) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new RuntimeException("División por cero");
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                throw new RuntimeException("Operador inválido");
        }
    }
    
    // Evaluar expresión infija (ej: "3 + 5 * 2")
    public static double evaluarInfija(String expresion) {
        Pila<Double> pilaNumeros = new Pila<>();
        Pila<Character> pilaOperadores = new Pila<>();
        
        expresion = expresion.replaceAll("\\s+", ""); // Eliminar espacios
        
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            
            // Si es un dígito, leer el número completo
            if (Character.isDigit(c) || c == '.') {
                StringBuilder numero = new StringBuilder();
                while (i < expresion.length() &&
                       (Character.isDigit(expresion.charAt(i)) || expresion.charAt(i) == '.')) {
                    numero.append(expresion.charAt(i));
                    i++;
                }
                i--; // Retroceder uno porque el for hará i++
                pilaNumeros.apilar(Double.parseDouble(numero.toString()));
            }
            // Si es paréntesis de apertura
            else if (c == '(') {
                pilaOperadores.apilar(c);
            }
            // Si es paréntesis de cierre
            else if (c == ')') {
                while (!pilaOperadores.estaVacia() && pilaOperadores.verTope() != '(') {
                    char operador = pilaOperadores.desapilar();
                    double b = pilaNumeros.desapilar();
                    double a = pilaNumeros.desapilar();
                    pilaNumeros.apilar(aplicarOperacion(a, b, operador));
                }
                pilaOperadores.desapilar(); // Quitar '('
            }
            // Si es un operador
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (!pilaOperadores.estaVacia() &&
                       precedencia(pilaOperadores.verTope()) >= precedencia(c)) {
                    char operador = pilaOperadores.desapilar();
                    double b = pilaNumeros.desapilar();
                    double a = pilaNumeros.desapilar();
                    pilaNumeros.apilar(aplicarOperacion(a, b, operador));
                }
                pilaOperadores.apilar(c);
            }
        }
        
        // Procesar operadores restantes
        while (!pilaOperadores.estaVacia()) {
            char operador = pilaOperadores.desapilar();
            double b = pilaNumeros.desapilar();
            double a = pilaNumeros.desapilar();
            pilaNumeros.apilar(aplicarOperacion(a, b, operador));
        }
        
        return pilaNumeros.desapilar();
    }
    
    // Convertir expresión infija a postfija (notación polaca inversa)
    public static String infijaAPostfija(String expresion) {
        StringBuilder resultado = new StringBuilder();
        Pila<Character> pilaOperadores = new Pila<>();
        
        expresion = expresion.replaceAll("\\s+", "");
        
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            
            if (Character.isDigit(c) || c == '.') {
                resultado.append(c);
                // Añadir espacio después del número
                if (i + 1 < expresion.length() &&
                    !Character.isDigit(expresion.charAt(i + 1)) &&
                    expresion.charAt(i + 1) != '.') {
                    resultado.append(' ');
                }
            }
            } else if (c == '(') {
                pilaOperadores.apilar(c);
            } else if (c == ')') {
                while (!pilaOperadores.estaVacia() && pilaOperadores.verTope() != '(') {
                    resultado.append(pilaOperadores.desapilar()).append(' ');
                }
                pilaOperadores.desapilar(); // Quitar '('
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (!pilaOperadores.estaVacia() &&
                       precedencia(pilaOperadores.verTope()) >= precedencia(c)) {
                    resultado.append(pilaOperadores.desapilar()).append(' ');
                }
                pilaOperadores.apilar(c);
            }
        }
        
        while (!pilaOperadores.estaVacia()) {
            resultado.append(pilaOperadores.desapilar()).append(' ');
        }
        
        return resultado.toString().trim();
    }
}
