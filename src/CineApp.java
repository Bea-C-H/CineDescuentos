import java.util.Scanner;

public class CineApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            final double PRECIO_NORMAL = 3500.0;

            System.out.print("Ingrese su edad: ");
            int edad;

            // Validar que se ingrese un número
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                return;
            }

            edad = scanner.nextInt();

            // Validar rango razonable de edad
            if (edad < 0 || edad > 120) {
                System.out.println("Edad inválida. Debe ingresar una edad entre 0 y 120.");
                return;
            }

            double precioFinal = PRECIO_NORMAL;

            // Descuento por edad
            if (edad < 5) {
                precioFinal *= 0.40; // 60% de descuento
                System.out.printf("Precio con 60%% de descuento por ser menor de 5 años: $%.0f\n", precioFinal);
            } else if (edad > 60) {
                precioFinal *= 0.45; // 55% de descuento
                System.out.printf("Precio con 55%% de descuento por ser mayor de 60 años: $%.0f\n", precioFinal);
            } else {
                // Precio normal: se pregunta cuántos boletos desea
                System.out.print("¿Cuántos boletos desea comprar? ");
                int cantidad;

                if (!scanner.hasNextInt()) {
                    System.out.println("Entrada inválida. Debe ingresar un número.");
                    return;
                }

                cantidad = scanner.nextInt();

                if (cantidad <= 0) {
                    System.out.println("Cantidad inválida. Debe ser al menos 1.");
                    return;
                }

                // Descuento por cantidad
                if (cantidad >= 2) {
                    precioFinal *= 0.70; // 30% de descuento
                    System.out.println("Se aplicó 30% de descuento por comprar 2 o más boletos.");
                }

                double total = precioFinal * cantidad;
                System.out.printf("Total a pagar por %d boletos: $%.0f\n", cantidad, total);
            }

            scanner.close();
        }
    }
