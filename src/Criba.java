import java.util.Scanner;

public class Criba {
    // Generar números primos de 1 a max
    public static final int tamanioInicial = 2;
    public static final boolean verdadero = true;
    public static final boolean falso = false;


    public static int[] generarPrimos(int max) {
        if (max >= 2) {
            // Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = inicializarArray(dim);

            //Criba
            criba(dim, esPrimo);

            // ¿Cuántos primos hay?
            int cuenta = cuentaPrimos(dim,esPrimo);

            // Rellenar el vector de números primos
            int[] primos = rellenarPrimos(cuenta, dim, esPrimo);
            return primos;
        } else { // max < 2
            return new int[0];
            // vector vacío
        }
    }

    public static boolean [] inicializarArray (int dim){
        boolean[] esPrimo = new boolean[dim];
        for (int i = 0; i < dim; i++)
            esPrimo[i] = verdadero;
        // Eliminar el 0  y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = falso;
        return esPrimo;
    }

    private static void criba (int dim, boolean[] esPrimo) {
        for (int i = tamanioInicial; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < dim; j += i)
                    esPrimo[j] = false;
            }
        }
    }

    public static int [] rellenarPrimos(int cuenta, int dim, boolean[] esPrimo) {
        int i;
        int j;
        int[] primos = new int[cuenta];
        for (i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    private static int cuentaPrimos (int dim, boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
        System.out.println("\nVector inicial hasta: " + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.println(i + 1 + "\t");
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.println(vector[i] + "\t");
        }
    }
}