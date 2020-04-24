/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoimpl;

import entidades.Horario;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author angel
 */
public class HorarioDaoImplTest {
    
    public HorarioDaoImplTest() {
        this.testGetHorarioByIdHorario();
        this.testGetAllHorarios();
        this.testSaveHorario();
        this.testDeleteHorario();
    }

    @Test
    public void testGetAllHorarios() {
        HorarioDaoImpl horarioDaoImpl = new HorarioDaoImpl();
        List <Horario> horarios = horarioDaoImpl.getAllHorarios();
        int resultadoEsperado = 1;
        int resultadoObtenido = horarios.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba GetAllHorarios ");
    }

    @Test
    public void testSaveHorario() {
        HorarioDaoImpl horarioDaoImpl;
        horarioDaoImpl = new HorarioDaoImpl();
        Horario horario = new Horario();
        horario.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        horarioDaoImpl.saveHorario(horario);
        List <Horario> horarios = horarioDaoImpl.getAllHorarios();
        int resultadoEsperado = 2;
        int resultadoObtenido = horarios.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba saveHorario ");
    }

    @Test
    public void testDeleteHorario() {
        HorarioDaoImpl horarioDaoImpl;
        horarioDaoImpl = new HorarioDaoImpl();
        Horario horario = new Horario();
        horario.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        horarioDaoImpl.deleteHorario(horario);
        List <Horario> horarios = horarioDaoImpl.getAllHorarios();
        int resultadoEsperado = 1;
        int resultadoObtenido = horarios.size();
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba deleteHorario ");
    }

    @Test
    public void testGetHorarioByIdHorario() {
        HorarioDaoImpl horarioDaoImpl;
        horarioDaoImpl = new HorarioDaoImpl();
        Horario resultadoEsperado = new Horario();
        resultadoEsperado.setRuta("C:/Users/angel/Downloads/6_PUDS.pdf");
        Horario resultadoObtenido = horarioDaoImpl.getHorarioByIdHorario("1");
        assertEquals(resultadoEsperado, resultadoObtenido, "Prueba getHorarioByIdHorario");
    }
    
}
