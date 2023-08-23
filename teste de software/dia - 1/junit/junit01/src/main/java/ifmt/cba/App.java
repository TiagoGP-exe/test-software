package ifmt.cba;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        NotaAluno2 notas = new NotaAluno2();

        notas.addNota(8);
        notas.addNota(7);
        notas.addNota(6);

        notas.processarNotas();

        System.out.println("Media = " + notas.getMediaNotas());
        System.out.println("Maior nota = " + notas.getMaiorNota());
        System.out.println("Menor nota = " + notas.getMenorNota());
    }
}
