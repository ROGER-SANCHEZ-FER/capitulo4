/**
 * @author Roger Roy Sánchez Fernández
 * @version 1.0
 * @see <a href = "https://www.youtube.com/watch?v=GST7EhThqpQ">Algoritmo Criba de Eratóstenes</a>
 */

import java.util.Scanner;

public class Criba {
    /**
     *Se definen 3 variables estáticas
     */
    public static final int tamanioInicial = 2;
    public static final boolean verdadero = true;
    public static final boolean falso = false;


    /**
     * Devuelve una tabla con los números primos desde cero hasta el número ingresado como parámetro max
     * @param max Número máximo del rango desde cero
     * @return Devuelve una tabla con números primos
     */
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

    /**
     * Inicializar una tabla descartando el cero y el 1 como número primo.
     * @param dim Dimensión de la tabla.
     * @return Devuelve una tabla con los 2 primeros números descartados como primo.
     */
    public static boolean [] inicializarArray (int dim){
        boolean[] esPrimo = new boolean[dim];
        for (int i = 0; i < dim; i++)
            esPrimo[i] = verdadero;
        // Eliminar el cero  y el 1, que no son primos.
        esPrimo[0] = esPrimo[1] = falso;
        return esPrimo;
    }

    /**
     * Se aplica el algoritmo Criba de Eratóstenes para obtener los números primos restantes.
     * @param dim Dimensión de la tabla.
     * @param esPrimo Tabla con los 2 primeros números descartados como primo.
     */
    private static void criba (int dim, boolean[] esPrimo) {
        for (int i = tamanioInicial; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < dim; j += i)
                    esPrimo[j] = false;
            }
        }
    }

    /**
     * Cuenta la cantidad de números primos que obtenemos.
     * @param dim Dimensión de la tabla.
     * @param esPrimo Tabla con las posiciones True = Números primos y False = No primos
     * @return Devuelve la cantidad de números primos que hay en la tabla esPrimo.
     */
    private static int cuentaPrimos (int dim, boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    /**
     * Crea una tabla con los números primos obtenidos.
     * @param cuenta Número de números primos existentes.
     * @param dim Dimensión de la tabla.
     * @param esPrimo Tabla con las posiciones True = Números primos y False = No primos
     * @return Devuelve una nueva tabla primos con los números primos obtenidos
     */
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

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
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