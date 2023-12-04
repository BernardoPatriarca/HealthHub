package site.HealthHub.Service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import site.HealthHub.Model.M_Contato;
import site.HealthHub.Model.M_Resposta;
import site.HealthHub.Repository.R_Contato;

@Service
public class S_Contato {

    private static R_Contato r_contato;

    public S_Contato(R_Contato r_contato) {
        this.r_contato = r_contato;
    }

    public static M_Resposta insertContato(String feedback) {
        boolean podeSalvar = false;
        String mensagem = "";

        if (!S_Generico.textoEstaVazio(feedback)) {
            podeSalvar = true;
            mensagem += "|Preencha o campo feedback| ";
        }

        if (podeSalvar) {
            M_Contato m_contato = new M_Contato();
            m_contato.setFeedback(feedback);


            try {
                r_contato.save(m_contato);
                mensagem += "feedback enviado com sucesso, clique em OK para continuar";
            } catch (DataIntegrityViolationException e) {
                podeSalvar = false;
                mensagem += "Algo deu errado, tente novamente";

            }
        }
        return new M_Resposta(podeSalvar, mensagem);
    }
}
