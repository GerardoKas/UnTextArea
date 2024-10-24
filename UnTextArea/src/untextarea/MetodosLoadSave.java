/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package untextarea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Gerardo.Castro.Mtz
 */
public class MetodosLoadSave {
    
    
     public  String leerArchivo(String ruta) {
        String linea;
        String contenido = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(ruta)));
            while ((linea = br.readLine()) != null) {
                contenido += linea + '\n';
            }
            br.close();
        } catch (Exception ex) {
            System.out.println("ERROR FICHERO LEYENDO");
        }
        return contenido;
    }

    public  boolean salvarArchivo(String ruta,String texto) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(ruta)));
            bw.write(texto);
            bw.close();
            return true;
        } catch (IOException ex) {
            System.out.println("ERROR D_E IO, al salvar::" + ruta);
        } catch (NullPointerException ex) {
            System.out.println("No hay fichero, al salvar");
        }
        return false;
    }

}
