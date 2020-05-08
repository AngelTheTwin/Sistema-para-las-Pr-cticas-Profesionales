/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package logica;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class MostrarDocumento {

    public static void visualizarDocumento(Documento documento){
        
        try {
            System.out.println("Mostrando documento");
            InputStream bos = new ByteArrayInputStream(documento.getDocumento());
            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);
            
            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);
            
            //abrir archivo
            out.close();
            bos.close();
        } catch (IOException ex) {
            Logger.getLogger(MostrarDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
