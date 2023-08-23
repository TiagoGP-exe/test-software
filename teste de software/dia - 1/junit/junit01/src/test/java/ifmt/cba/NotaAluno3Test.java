package ifmt.cba;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class NotaAluno3Test {
    @Test
    public void testAddNota() {
        NotaAluno3 nota = new NotaAluno3();
        assertEquals(0, nota.getListaNota().size());
        nota.addNota(9);
        nota.addNota(8);
        assertEquals(2, nota.getListaNota().size());
    }

    @Test
    public void testGetListaNota() {
        NotaAluno3 nota = new NotaAluno3();
        nota.addNota(9);
        nota.addNota(8);
        List<Float> lista = nota.getListaNota();

        assertEquals(9, lista.get(0), 001);
        
        assertEquals(9, lista.get(1), 001);
    }

    @Test
    public void testGetMaiorNota() {
        NotaAluno3 nota = new NotaAluno3();
        nota.addNota(9);
        nota.addNota(8);
        nota.processarNotas();
        assertEquals(9, nota.getMaiorNota(), 0.001);
    }

    @Test
    public void testGetMediaNotas() {
        NotaAluno3 nota = new NotaAluno3();
        nota.addNota(9);
        nota.addNota(8);
        nota.processarNotas();
        assertEquals(8.5f, nota.getMediaNotas(), 0.001);
    }

    @Test
    public void testGetMenorNota() {
        NotaAluno3 nota = new NotaAluno3();
        nota.addNota(9);
        nota.addNota(8);
        nota.processarNotas();
        assertEquals(8, nota.getMenorNota(), 0.001);
    }

    @Test
    public void testProcessarNotas() {
        NotaAluno3 nota = new NotaAluno3();
        nota.addNota(9);
        nota.addNota(8);
        nota.processarNotas();
        assertEquals(8, nota.getMenorNota(), 0.001);
        assertEquals(9, nota.getMaiorNota(), 0.001);
        assertEquals(8.5f, nota.getMediaNotas(), 0.001);
    }
}
