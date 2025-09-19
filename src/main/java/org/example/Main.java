package org.example;
import java.util.Arrays;
import java.util.Random;

public class Main {

    //----Búsqueda lineal----
    public static int busquedaLineal(int[] arr, int valor) {
        int comparaciones = 0;
        for (int i = 0; i < arr.length; i++) {
            comparaciones++;
            if (arr[i] == valor) {
                System.out.println("Búsqueda lineal -> Comparaciones: " + comparaciones);
                return i;
            }
        }
        System.out.println("Búsqueda lineal -> Comparaciones: " + comparaciones);
        return -1;
    }

    //----Búsqueda binaria----
    public static int busquedaBinaria(int[] arr, int valor) {
        int comparaciones = 0;
        int inicio = 0, fin = arr.length - 1;
        while (inicio <= fin) {
            comparaciones++;
            int medio = (inicio + fin) / 2;
            if (arr[medio] == valor) {
                System.out.println("Búsqueda binaria -> Comparaciones: " + comparaciones);
                return medio;
            }
            if (arr[medio] < valor) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        System.out.println("Búsqueda binaria -> Comparaciones: " + comparaciones);
        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[20];

        //----20 números aleatorios entre 1 y 100 ----
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }

        System.out.println("Arreglo generado:");
        System.out.println(Arrays.toString(arr));

        //---- Ordenar para búsqueda binaria----
        Arrays.sort(arr);
        System.out.println("Arreglo ordenado:");
        System.out.println(Arrays.toString(arr));

        //----Número que sí está----
        int valorExistente = arr[5];
        //----Número que no está----
        int valorNoExistente = 999;

        System.out.println("Buscando valor existente: " + valorExistente);
        busquedaLineal(arr, valorExistente);
        busquedaBinaria(arr, valorExistente);

        System.out.println("Buscando valor NO existente: " + valorNoExistente);
        busquedaLineal(arr, valorNoExistente);
        busquedaBinaria(arr, valorNoExistente);
    }
}
