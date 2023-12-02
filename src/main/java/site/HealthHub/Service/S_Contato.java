package site.HealthHub.Service;

import org.springframework.dao.DataIntegrityViolationException;
import site.HealthHub.Model.M_Contato;
import site.HealthHub.Model.M_Resposta;
import site.HealthHub.Repository.R_Contato;


public class S_Contato {

    private static R_Contato r_contato;

    public S_Contato(R_Contato r_contato) {
        this.r_contato = r_contato;
    }

    public static M_Resposta insertContato(String feedback) {
        boolean podeSalvar = true;
        String mensagem = "";

        if (S_Generico.textoEstaVazio(feedback)) {
            podeSalvar = false;
            mensagem += "|Preencha o campo feedback| ";
        }

        if (podeSalvar) {
            M_Contato m_contato = new M_Contato();
            m_contato.setFeedback(feedback);


            try {
                r_contato.save(m_contato);
                mensagem += "feedback enviado com sucesso, clique em OK para continuar";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Algo deu errado, tente novamente";
                podeSalvar = false;
            }
        }
        return new M_Resposta(podeSalvar, mensagem);
    }
}
