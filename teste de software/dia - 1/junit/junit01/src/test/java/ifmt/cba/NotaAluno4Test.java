package ifmt.cba;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NotaAluno4Test {
    @Test
    public void quandoNaoAdicionaNotas() {
        NotaAluno4 nota = new NotaAluno4();
        assertEquals(0.0f, nota.getMediaNotas(), 0.001);
        assertEquals(Float.MAX_VALUE, nota.getMaiorNota(), 0.001);
        assertEquals(Float.MIN_VALUE, nota.getMenorNota(), 0.001);
    }

    @Test
    public void processarSemNotas() {
        NotaAluno4 nota = new NotaAluno4();
        nota.processarNotas();
        assertEquals(0.0f, nota.getMediaNotas(), 0.001);
        assertEquals(Float.MIN_VALUE, nota.getMaiorNota(), 0.001);
        assertEquals(Float.MAX_VALUE, nota.getMenorNota(), 0.001);
    }

    @Test
    public void processarComNotasDecrescente () {
        NotaAluno4 nota = new NotaAluno4();
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
        NotaAluno4 nota = new NotaAluno4();
        nota.addNota(6.0f);
        nota.addNota(7.0f);
        nota.addNota(8.0f);
        nota.processarNotas();
        assertEquals(7.0f, nota.getMediaNotas(), 0.001);
        assertEquals(8.0f, nota.getMaiorNota(), 0.001);
        assertEquals(6.0f, nota.getMenorNota(), 0.001);
    }
}
