package org.unl.music.base.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RepetidosConArreglos {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        ArrayList<String> listaTemporal = new ArrayList<>();
        HashMap<String, Integer> contador = new HashMap<>();
        ArrayList<String> repetidos = new ArrayList<>();
        int totalRepetidos = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                listaTemporal.add(linea);
                contador.put(linea, contador.getOrDefault(linea, 0) + 1);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        String[] lista = listaTemporal.toArray(new String[0]);

        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > 1) {
                repetidos.add(entry.getKey());
                totalRepetidos += entry.getValue();
            }
        }

        System.out.println("Cantidad total de elementos repetidos en Arreglo: " + totalRepetidos);

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Duración: " + endTime + " milisegundos.");
    }
}