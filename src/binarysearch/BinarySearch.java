/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Scanner;

/*Búsqueda binaria: Encuentra un elemento en una lista ordenada dividiendo la búsqueda a la mitad en cada pasoBúsqueda binaria:
Escribe un programa en Java que implemente la búsqueda binaria. El programa debe recibir un número entero como entrada y buscar ese número en una lista de enteros ordenada.
Si el número está presente, el programa debe mostrar el índice donde se encuentra en la lista. Si no está presente, mostrar un mensaje indicando que el número no fue encontrado.*/
/**
 *
 * @author Morad
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    
     private static int busquedaBinaria(int[] lista, int target) {
         int indiceIzq = 0;// Índice izquierdo inicial
         int indiceDer = lista.length - 1;// Índice derecho inicial
         
       while (indiceIzq <= indiceDer) { //Bucle que se ejecuta mientras el espacio de búsqueda sea válido
           int indiceMedio = indiceIzq +(indiceDer - indiceIzq) /2;//Índice medio del espacio de búsqueda
           if(lista[indiceMedio] == target){// Si el elemento en el índice medio es igual al objetivo
               return indiceMedio;// Se encontró el elemento objetivo, devuelve el índice medio
           } else if(lista[indiceMedio] < target){// Si el elemento en el índice medio es menor que el objetivo
               indiceIzq = indiceMedio + 1;// Se descarta la mitad izquierda del espacio de búsqueda
           }else {// Si el elemento en el índice medio es mayor que el objetivo
               indiceDer = indiceMedio -1;// Se descarta la mitad derecha del espacio de búsqueda
           }
       }                   
    // Si el bucle termina y no se encontró el elemento, devuelve -1
    return -1;
}

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tamaño de la lista");
        int tamanio = sc.nextInt();
        int [] lista = new int[tamanio];
        
        
        System.out.println("Ingrese los elementos de la lista en orden ascendente");
        for (int i = 0; i < tamanio; i++) {
            lista[i] = sc.nextInt();
        }
        
        System.out.println("Ingrese el numero que desea buscar");
        int target = sc.nextInt();
        int resultado = busquedaBinaria(lista, target);
        if( resultado != -1){
            System.out.println("El numero " + target + " se encuentra en el indice "+ resultado + " de la lista");
        } else {
            System.out.println("El numero "+ target + " no fue encontrado en la lista");   
        }
         sc.close();
                
    }
    
}
