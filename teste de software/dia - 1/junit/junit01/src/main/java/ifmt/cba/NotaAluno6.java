package ifmt.cba;

import java.util.ArrayList;
import java.util.List;

public class NotaAluno6 {
    private List<Float> listaNota;
    private float mediaNotas;
    private float maiorNota;
    private float menorNota;

    public NotaAluno6() {
        this.listaNota = new ArrayList<Float>();
        this.mediaNotas = 0;
        this.maiorNota = Float.MAX_VALUE;
        this.menorNota = Float.MIN_VALUE;
    } 

    public List<Float> getListaNota() {
        return listaNota;
    }

    public void addNota(float nota) {
        this.listaNota.add(nota);
    }

    public void processarNotas() throws RuntimeException {
        if (this.listaNota.size() == 0) {
            throw new RuntimeException();
        }
        this.maiorNota = Float.MIN_VALUE;
        this.menorNota = Float.MAX_VALUE;
        float somaNotas = 0;

        for (float nota : this.listaNota) {
            somaNotas += nota;
            if (nota > maiorNota) {
                this.maiorNota = nota;
            }

            if (nota < this.menorNota) {
                this.menorNota = nota;
            }
        }
        this.mediaNotas = somaNotas / this.listaNota.size();
    }

    public float getMediaNotas() {
        return mediaNotas;
    }

    public float getMaiorNota() {
        return maiorNota;
    }

    public float getMenorNota() {
        return menorNota;
    }

}
