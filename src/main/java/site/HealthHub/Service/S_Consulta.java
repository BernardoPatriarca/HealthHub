package site.HealthHub.Service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import site.HealthHub.Model.M_Consulta;
import site.HealthHub.Model.M_Contato;
import site.HealthHub.Model.M_Resposta;
import site.HealthHub.Repository.R_Consulta;
import site.HealthHub.Repository.R_Contato;

import java.time.LocalDate;

@Service
public class S_Consulta {

    private static R_Consulta r_consulta;

    public S_Consulta(R_Consulta r_consulta) {
        this.r_consulta = r_consulta;
    }

    public static M_Resposta insertConsulta(String id_cadastro, String dataConsulta, String observacao) {
        boolean podeSalvar = false;
        String mensagem = "";

        if (!S_Generico.textoEstaVazio(observacao)) {
            podeSalvar = true;
            mensagem += "|Preencha o campo feedback| ";
        }
        if (!S_Generico.textoEstaVazio(dataConsulta)) {
            podeSalvar = true;
            mensagem += "|Preencha o campo feedback| ";
        }

        if (podeSalvar) {
            M_Consulta m_consulta = new M_Consulta();
            m_consulta.setObservacao(observacao);
            m_consulta.setDataConsulta(LocalDate.parse(dataConsulta));
            m_consulta.setId_cadastro(Long.parseLong(id_cadastro));


            try {
                r_consulta.save(m_consulta);
                mensagem += "Consulta realizada com sucesso, clique em OK para continuar";
            } catch (DataIntegrityViolationException e) {
                podeSalvar = false;
                mensagem += "Algo deu errado, tente novamente";

            }
        }
        return new M_Resposta(podeSalvar, mensagem);
    }
}
