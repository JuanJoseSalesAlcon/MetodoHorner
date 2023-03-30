import java.util.Scanner;

public class MetodoHorner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el grado del dividendo: ");
        int gradDividendo = sc.nextInt();
        int[] dividendo = new int[gradDividendo + 1];
        for (int i = gradDividendo; i >= 0; i--) {
            System.out.println("Ingrese el coeficiente x^" + i + " del dividendo: ");
            dividendo[i] = sc.nextInt();
        }

        System.out.println("Ingrese el grado del divisor: ");
        int gradDivisor = sc.nextInt();
        int[] divisor = new int[gradDivisor + 1];
        for (int i = gradDivisor; i >= 0; i--) {
            System.out.println("Ingrese el coeficiente x^" + i + " del divisor: ");
            divisor[i] = sc.nextInt();
        }

        int[] cociente = new int[gradDividendo - gradDivisor + 1];
        for (int i = gradDividendo - gradDivisor; i >= 0; i--) {
            cociente[i] = dividendo[i + gradDivisor] / divisor[gradDivisor];
            for (int j = gradDivisor; j >= 0; j--) {
                dividendo[i + j] = dividendo[i + j] - cociente[i] * divisor[j];
            }
        }

        System.out.println("El cociente es:");
        for (int i = cociente.length - 1; i >= 0; i--) {
            System.out.print(cociente[i] + "x^" + i + " ");
            if (i != 0) {
                System.out.print("+ ");
            }
        }
        System.out.println();

        System.out.println("El residuo es:");
        for (int i = gradDivisor - 1; i >= 0; i--) {
            System.out.print(dividendo[i] + "x^" + i + " ");
            if (i != 0) {
                System.out.print("+ ");
            }
        }
        System.out.println();
    }
}

