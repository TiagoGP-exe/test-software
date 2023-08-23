package ifmt.cba;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotaAluno6_1Test {
    @Test
    public void quandoNaoAdicionaNotas() {
        NotaAluno6 nota = new NotaAluno6();
        assertEquals(0.0f, nota.getMediaNotas(), 0.001);
        assertEquals(Float.MAX_VALUE, nota.getMaiorNota(), 0.001);
        assertEquals(Float.MIN_VALUE, nota.getMenorNota(), 0.001);
    }

    @Test
    public void processarSemNotas() {
        NotaAluno6 nota = new NotaAluno6();
        nota.processarNotas();
        assertEquals(0.0f, nota.getMediaNotas(), 0.001);
        assertEquals(Float.MAX_VALUE, nota.getMaiorNota(), 0.001);
        assertEquals(Float.MIN_VALUE, nota.getMenorNota(), 0.001);
    }

    @Test
    public void processarComNotasDescrescente () {
        NotaAluno6 nota = new NotaAluno6();
        nota.addNota(8.0f);
        nota.addNota(7.0f);
        nota.addNota(6.0f);
        nota.processarNotas();
        assertEquals(7.0f, nota.getMediaNotas(), 0.001);
        assertEquals(8.0f, nota.getMaiorNota(), 0.001);
        assertEquals(6.0f, nota.getMenorNota(), 0.001);
    }

    @Test
    public void processarComNotasCrescente() {
        NotaAluno6 nota = new NotaAluno6();
        nota.addNota(6.0f);
        nota.addNota(7.0f);
        nota.addNota(8.0f);
        nota.processarNotas();
        assertEquals(7.0f, nota.getMediaNotas(), 0.001);
        assertEquals(8.0f, nota.getMaiorNota(), 0.001);
        assertEquals(6.0f, nota.getMenorNota(), 0.001);
    }
}
