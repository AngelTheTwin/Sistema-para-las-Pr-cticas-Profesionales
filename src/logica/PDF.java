/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import logica.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class PDF {
    
    public static File byteAPdf(Blob archivo, String titulo){
        File pdf = null;
        try {
            byte[] bytes = archivo.getBytes(1, (int)archivo.length());
            pdf = File.createTempFile(titulo, ".binary");
            FileOutputStream out = new FileOutputStream(pdf);
            out.write(bytes);
            out.close();
        } catch (SQLException excepcion) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, excepcion);
        } catch (IOException excepcion) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, excepcion);
        }
        return pdf;
    }
}
