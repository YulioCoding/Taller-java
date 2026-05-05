import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n Calculadora ");
            System.out.println("1. Sumar (a + b)");
            System.out.println("2. Restar (a - b)");
            System.out.println("3. Multiplicar (a * b)");
            System.out.println("4. Dividir (a / b)");
            System.out.println("5. Raíz cuadrada (√x)");
            System.out.println("6. Potencia (a^b)");
            System.out.println("7. Seno ");
            System.out.println("8. Coseno (cos x)");
            System.out.println("9. Salir");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1: // Suma
                    System.out.print("Ingrese a: ");
                    double a1 = sc.nextDouble();
                    System.out.print("Ingrese b: ");
                    double b1 = sc.nextDouble();
                    System.out.println("Resultado: " + (a1 + b1));
                    break;
                case 2: // Resta
                    System.out.print("Ingrese a: ");
                    double a2 = sc.nextDouble();
                    System.out.print("Ingrese b: ");
                    double b2 = sc.nextDouble();
                    System.out.println("Resultado: " + (a2 - b2));
                    break;
                case 3: // Multiplicación
                    System.out.print("Ingrese a: ");
                    double a3 = sc.nextDouble();
                    System.out.print("Ingrese b: ");
                    double b3 = sc.nextDouble();
                    System.out.println("Resultado: " + (a3 * b3));
                    break;
                case 4: // División
                    System.out.print("Ingrese a (dividendo): ");
                    double a4 = sc.nextDouble();
                    System.out.print("Ingrese b (divisor): ");
                    double b4 = sc.nextDouble();
                    if (b4 == 0) {
                        System.out.println("Error: división por cero no permitida.");
                    } else {
                        System.out.println("Resultado: " + (a4 / b4));
                    }
                    break;
                case 5: // Raíz cuadrada
                    System.out.print("Ingrese x (>= 0): ");
                    double x = sc.nextDouble();
                    if (x < 0) {
                        System.out.println("Error: raíz cuadrada de número negativo (resultado complejo).");
                    } else {
                        System.out.println("Resultado: " + Math.sqrt(x));
                    }
                    break;
                case 6: // Potencia
                    System.out.print("Ingrese base a: ");
                    double base = sc.nextDouble();
                    System.out.print("Ingrese exponente b: ");
                    double exponente = sc.nextDouble();
                    System.out.println("Resultado: " + Math.pow(base, exponente));
                    break;
                case 7: // Seno
                    System.out.print("Ingrese ángulo x: ");
                    double angSin = sc.nextDouble();
                    System.out.print("¿Ingresaste grados? (s/n): ");
                    char gSin = sc.next().toLowerCase().charAt(0);
                    if (gSin == 's') angSin = Math.toRadians(angSin);
                    System.out.println("Resultado (sin): " + Math.sin(angSin));
                    break;
                case 8: // Coseno
                    System.out.print("Ingrese ángulo x: ");
                    double angCos = sc.nextDouble();
                    System.out.print("¿Ingresaste grados? (s/n): ");
                    char gCos = sc.next().toLowerCase().charAt(0);
                    if (gCos == 's') angCos = Math.toRadians(angCos);
                    System.out.println("Resultado (cos): " + Math.cos(angCos));
                    break;
                case 9:
                    salir = true;
                    System.out.println("Saliendo. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        sc.close();
    }
}
