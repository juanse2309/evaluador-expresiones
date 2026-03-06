import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n===== EVALUADOR DE EXPRESIONES ARITMÉTICAS =====");
            System.out.println("1. Evaluar expresión");
            System.out.println("2. Convertir infija a postfija");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese expresión (ej: 3 + 5 * 2): ");
                    String expresion1 = scanner.nextLine();
                    try {
                        double resultado = EvaluadorExpresiones.evaluarInfija(expresion1);
                        System.out.println("Resultado: " + resultado);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                    
                case 2:
                    System.out.print("Ingrese expresión infija: ");
                    String expresion2 = scanner.nextLine();
                    try {
                        String postfija = EvaluadorExpresiones.infijaAPostfija(expresion2);
                        System.out.println("Expresión postfija: " + postfija);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                    
                case 0:
                    System.out.println("Saliendo...");
                    break;
                    
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        
        scanner.close();
    }
}
