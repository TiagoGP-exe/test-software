package ifmt.cba;

import java.util.List;

public class NotaAluno1 {
    private List<Float> listaNota;
    private float mediaNotas;
    private float maiorNota;
    private float menorNota;

    public NotaAluno1() {
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

    public void processarNotas() {
        this.maiorNota = Float.MAX_VALUE;
        this.menorNota = Float.MIN_VALUE;
        float somaNotas = 0;

        for (float nota : this.listaNota) {
            somaNotas += nota;
            if (nota > this.maiorNota) {
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
