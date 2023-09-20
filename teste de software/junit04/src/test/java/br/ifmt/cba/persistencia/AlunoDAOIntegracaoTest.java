package br.ifmt.cba.persistencia;

import org.junit.Test;
import static org.junit.Assert.fail;
import java.util.List;
import br.ifmt.cba.vo.AlunoVO;
import br.ifmt.cba.vo.EnderecoVO;
import br.ifmt.cba.vo.EnumSexo;
import br.ifmt.cba.vo.EnumUF;

public class AlunoDAOIntegracaoTest {

    @Test
    public void testIncluirDadosCorretos() {
        try {
            AlunoDAO alunoDAO = new AlunoDAO();
            AlunoVO alunoVO = new AlunoVO();
            AlunoVO alunoVORecuperado;

            alunoVO.setNome("Teste de Inclusao");
            alunoVO.setNomeMae("Mae do Teste de Inclusao");
            alunoVO.setNomePai("Pai do Teste de Inclusao");
            alunoVO.setSexo(EnumSexo.MASCULINO);
            alunoVO.setEndereco(new EnderecoVO("Rua Teste", 100, "Bairro Teste", "Cidade Teste", EnumUF.MT));

            if (alunoDAO.incluir(alunoVO) <= 0) {
                fail("Falha na inclusao de aluno");
            }

            List<AlunoVO> listaAluno = alunoDAO.buscarPorNome("Teste de Inclusao");
            if (listaAluno.size() >= 0) {
                alunoVORecuperado = listaAluno.get(0);
                if (!comparaAlunoVO(alunoVO, alunoVORecuperado)) {
                    fail("Falha na recuperacao dos dados persistidos de aluno");
                }
            } else {
                fail("Falha na recuperacao do aluno incluido");
            }
        } catch (PersistenciaException e) {
            fail("Falha na inclusao de aluno - " + e.getMessage());
        }
    }

    private boolean comparaAlunoVO(AlunoVO alunoOriginal, AlunoVO alunoRecuperado) {
        boolean retorno = true;

        if (!alunoOriginal.getNome().equals(alunoRecuperado.getNome())) {
            retorno = false;
        }

        // Add similar comparisons for other fields (NomeMae, NomePai, Sexo, Endereco, etc.)

        return retorno;
    }
}
