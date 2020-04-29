/*
 * Copyright (C) {2020}
 * Todos los derechos reservados
 * Desarrollado para {Universidad Veracruzana}
 */
package logica;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class Documento {
    private String ruta;
    private byte[] documento;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
        this.documentoABinario();
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }
    
    public void documentoABinario(){
        File archivo = new File(ruta);
        documento = new byte[(int) archivo.length()];
        this.setDocumento(documento);
    }
}
