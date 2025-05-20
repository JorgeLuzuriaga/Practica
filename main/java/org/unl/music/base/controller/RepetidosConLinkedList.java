package org.unl.music.base.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.unl.music.base.controller.data_struct.list.LinkedList;

public class RepetidosConLinkedList {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        LinkedList<String> lista = new LinkedList<>();
        LinkedList<String> repetidos = new LinkedList<>();
        HashMap<String, Integer> contador = new HashMap<>();
        int totalRepetidos = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
                contador.put(linea, contador.getOrDefault(linea, 0) + 1);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > 1) {
                repetidos.add(entry.getKey());
                totalRepetidos += entry.getValue();
            }
        }

        System.out.println("Cantidad total de elementos repetidos en LinkedList: " + totalRepetidos);

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Duración: " + endTime + " milisegundos.");
    }
}