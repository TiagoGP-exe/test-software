package br.edu.ifmt;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Locale;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.javafaker.Faker;

import br.edu.ifmt.negocio.AlunoNegocio;
import br.edu.ifmt.negocio.NegocioException;
import br.edu.ifmt.persistencia.AlunoDAO;
import br.edu.ifmt.persistencia.PersistenciaException;
import br.edu.ifmt.vo.AlunoVO;
import br.edu.ifmt.vo.EnderecoVO;
import br.edu.ifmt.vo.EnumSexo;
import br.edu.ifmt.vo.EnumUF;

public class AlunoNegocioTest {
    private static AlunoNegocio alunoNegocio;

    @BeforeClass
    public static void iniciarObjetos() {
        try {
            alunoNegocio = new AlunoNegocio(new AlunoDAO());
        } catch (NegocioException e) {
            fail(e.getMessage());
        } catch (PersistenciaException e) {
            fail(e.getMessage());
        }
    }

    @Before
    public void gerarDados() {
        Faker faker = new Faker(Locale.getDefault());

        AlunoVO alunoVO = new AlunoVO();
        String primeiroNome;

        for (int x = 1; x <= 600; x++) {
            do {
                primeiroNome = faker.address().firstName();
            } while (primeiroNome.charAt(primeiroNome.length() - 1) != 'a'
                    && primeiroNome.charAt(primeiroNome.length() - 1) != 'o');

            alunoVO.setNome(primeiroNome + " " + faker.address().lastName());

            if (primeiroNome.charAt(primeiroNome.length() - 1) == 'a') {
                alunoVO.setSexo(EnumSexo.FEMININO);
            } else {
                alunoVO.setSexo(EnumSexo.MASCULINO);
            }

            do {
                primeiroNome = faker.address().firstName();
            } while (primeiroNome.charAt(primeiroNome.length() - 1) != 'a');

            alunoVO.setNomeMae(primeiroNome + " " + faker.address().lastName());

            do {
                primeiroNome = faker.address().firstName();
            } while (primeiroNome.charAt(primeiroNome.length() - 1) != 'o');

            alunoVO.setNomePai(primeiroNome + " " + faker.address().lastName());

            EnderecoVO enderecoVO = new EnderecoVO();
            enderecoVO.setLogradouro(faker.address().streetName());
            enderecoVO.setNumero(Integer.parseInt(faker.address().streetAddressNumber()));
            enderecoVO.setBairro("Centro");
            enderecoVO.setCidade(faker.address().cityName());
            enderecoVO.setUf(EnumUF.MT);

            alunoVO.setEndereco(enderecoVO);

            try {
                alunoNegocio.inserir(alunoVO);
            } catch (NegocioException e) {
                fail(e.getMessage());
            }
        }

    }

    @Test
    public void testPesquisaParteNome() {
        try {
            List<AlunoVO> listaAluno = alunoNegocio.pesquisaParteNome("Maria");
            System.out.println("Encontrou: " +  listaAluno.size());
        } catch (NegocioException e) {
            fail(e.getMessage());
        }
    }

    @AfterClass
    public static void encerrarRecursos() {
        try {
            alunoNegocio.getAlunoDAO().desconectarBD();
        } catch (PersistenciaException e) {
            fail(e.getMessage());
        }
    }
}
