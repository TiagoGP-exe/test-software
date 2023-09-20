package br.ifmt.cba.negocio;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ifmt.cba.persistencia.AlunoDAO;
import br.ifmt.cba.persistencia.PersistenciaException;
import br.ifmt.cba.vo.AlunoVO;
import br.ifmt.cba.vo.EnderecoVO;
import br.ifmt.cba.vo.EnumSexo;
import br.ifmt.cba.vo.EnumUF;

public class AlunoNegocioIntegracaoTest {

    private static AlunoNegocio alunoNegocio;

    @BeforeClass
    public static void inicializacao() {
        try {
            alunoNegocio = new AlunoNegocio(new AlunoDAO());
        } catch (NegocioException | PersistenciaException e) {
            fail();
        }
    }

    @AfterClass
    public static void finalizacao() {
        try {
            alunoNegocio.getAlunoDAO().desconectarBD();
        } catch (PersistenciaException e) {
            fail();
        }
    }

    @Test
    public void testAlterar() {
        // Add your test logic here
    }

    @Test
    public void testExcluir() {
        try {
            alunoNegocio = new AlunoNegocio(new AlunoDAO());
            AlunoVO alunoVO = new AlunoVO();
            AlunoVO alunoVORecuperado;

            alunoVO.setNome("Teste de Exclusao");
            alunoVO.setNomeMae("Mae do Teste de Exclusao");
            alunoVO.setNomePai(" Pai do Teste de Exclusao");
            alunoVO.setSexo(EnumSexo.MASCULINO);
            alunoVO.setEndereco(new EnderecoVO("Rua Teste ", 100, "Bairro Teste ", " Cidade Teste ", EnumUF.MT));

            alunoNegocio.inserir(alunoVO);
            List<AlunoVO> listaAluno = alunoNegocio.pesquisaParteNome("Teste de Exclusao");
            if (listaAluno.size() >= 0) {
                alunoVORecuperado = listaAluno.get(0);

                alunoNegocio.excluir(alunoVORecuperado.getMatricula());

                if (alunoNegocio.pesquisaMatricula(alunoVORecuperado.getMatricula()) != null) {
                    fail("Falha na exclusao do aluno");
                }
            } else {
                fail("Falha na recuperacao do aluno a ser excluido");
            }
        } catch (NegocioException | PersistenciaException e) {
            fail("Falha na inicializacao da camada de negocio ou persitencia" + e.getMessage());
        }
    }

    @Test
    public void testInserir() {
        try {
            alunoNegocio = new AlunoNegocio(new AlunoDAO());
            AlunoVO alunoVO = new AlunoVO();
            AlunoVO alunoVORecuperado;

            alunoVO.setNome("Teste de Inclusão");
            alunoVO.setNomeMae("Mae do Teste de inclusão");
            alunoVO.setNomePai("Pai do Teste de inclusão");
            alunoVO.setSexo(EnumSexo.MASCULINO);
            alunoVO.setEndereco(new EnderecoVO("Rua Teste", 100, "Bairro test", "Cidade Teste", EnumUF.MT));

            alunoNegocio.inserir(alunoVO);

            List<AlunoVO> listaAluno = alunoNegocio.pesquisaParteNome("Teste de Inclusão");
            if (listaAluno.size() >= 0) {
                alunoVORecuperado = listaAluno.get(0);
                if (!this.comparaAlunoVO((alunoVO), alunoVORecuperado)) {
                    fail("Falha na recuperação dos dados persistidos de aluno");
                }
            } else {
                fail("Falha na recuperacao do aluo incluindo");
            }
        } catch (NegocioException | PersistenciaException e) {
            fail("Failed to execute testInserir: " + e.getMessage());
        }
    }

    private boolean comparaAlunoVO(AlunoVO alunoOriginal, AlunoVO alunoRecuperado) {
        boolean retorno = true;

        if (!alunoOriginal.getNome().equals(alunoRecuperado.getNome())) {
            retorno = false;
        }
        if (!alunoOriginal.getNomeMae().equals(alunoRecuperado.getNomeMae())) {
            retorno = false;
        }
        if (!alunoOriginal.getNomePai().equals(alunoRecuperado.getNomePai())) {
            retorno = false;
        }
        if (!alunoOriginal.getSexo().equals(alunoRecuperado.getSexo())) {
            retorno = false;
        }
        if (!alunoOriginal.getEndereco().getLogradouro().equals(alunoRecuperado.getEndereco().getLogradouro())) {
            retorno = false;
        }
        if (alunoOriginal.getEndereco().getNumero() != alunoRecuperado.getEndereco().getNumero()) {
            retorno = false;
        }
        if (!alunoOriginal.getEndereco().getBairro().equals(alunoRecuperado.getEndereco().getBairro())) {
            retorno = false;
        }
        if (!alunoOriginal.getEndereco().getCidade().equals(alunoRecuperado.getEndereco().getCidade())) {
            retorno = false;
        }
        if (!alunoOriginal.getEndereco().getUf().equals(alunoRecuperado.getEndereco().getUf())) {
            retorno = false;
        }
        return retorno;
    }
}
