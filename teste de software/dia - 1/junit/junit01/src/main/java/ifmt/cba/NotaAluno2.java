package ifmt.cba;

import java.util.ArrayList;
import java.util.List;

public class NotaAluno2 {
    private List<Float> listaNota;
    private float mediaNotas;
    private float maiorNota;
    private float menorNota;

    public NotaAluno2() {
        this.listaNota = new ArrayList<Float>();
        this.mediaNotas = 0;
        this.maiorNota = Float.MIN_VALUE;
        this.menorNota = Float.MAX_VALUE;
    }

    public List<Float> getListaNota() {
        return listaNota;
    }

    public void addNota(float nota) {
        this.listaNota.add(nota);
    }

    public void processarNotas() {
        this.maiorNota = Float.MIN_VALUE;
        this.menorNota = Float.MAX_VALUE;
        float somaNotas = 0;

        for (float nota : this.listaNota) {
            somaNotas += nota;
            if (nota > maiorNota) {
                this.maiorNota = nota;
            }
            if (nota < menorNota) {
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
