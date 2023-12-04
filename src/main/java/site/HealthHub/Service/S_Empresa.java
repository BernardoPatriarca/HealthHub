package site.HealthHub.Service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import site.HealthHub.Model.M_Empresa;
import site.HealthHub.Model.M_Resposta;
import site.HealthHub.Repository.R_Empresa;

import java.time.LocalDate;

@Service
public class S_Empresa {
    private static R_Empresa r_empresa;

    public S_Empresa(R_Empresa r_empresa) {
        this.r_empresa = r_empresa;
    }

    public static M_Resposta insertEmpresa(String nome, String CNPJ, String nomeCartao, String numeroCartao, String codigoCartao, String validadeCartao, String id_plano) {
        boolean podeSalvar = true;
        String mensagem = "";

        if (S_Generico.textoEstaVazio(nome)) {
            podeSalvar = false;
            mensagem += "|Preencha o campo nome da empresa| ";
        }
        if (S_Generico.textoEstaVazio(nomeCartao)) {
            podeSalvar = false;
            mensagem += "|Preencha o campo nome do cartao| ";
        }
        if(S_Generico.textoEstaVazio(CNPJ) || !S_Generico.validarCNPJ(CNPJ)){
            podeSalvar = false;
            mensagem += "|CNPJ inválido| ";
        }
        if(S_Generico.textoEstaVazio(numeroCartao) || !S_Generico.validarNumeroCartao(numeroCartao)){
            podeSalvar = false;
            mensagem += "|Numero do cartao inválido| ";
        }
        if(S_Generico.textoEstaVazio(codigoCartao) || !S_Generico.validarCodigoCartao(codigoCartao)){
            podeSalvar = false;
            mensagem += "|Codigo do cartao inválido| ";
        }
        if(S_Generico.textoEstaVazio(validadeCartao) || !S_Generico.validarDataCartao(validadeCartao)){
            podeSalvar = false;
            mensagem += "|Data de vencimento do cartao inválido| ";
        }
        if(S_Generico.textoEstaVazio(id_plano)){
            podeSalvar = false;
            mensagem += "|Plano inválida| ";
        }

        if (podeSalvar) {
            M_Empresa m_empresa = new M_Empresa();
            m_empresa.setNome(nome);
            m_empresa.setNomeCartao(nomeCartao);
            m_empresa.setCNPJ(Long.parseLong(CNPJ));
            m_empresa.setNumeroCartao(Long.parseLong(numeroCartao));
            m_empresa.setCodigoCartao(Long.parseLong(codigoCartao));
            m_empresa.setValidadeCartao(LocalDate.parse(validadeCartao));
            m_empresa.setId_plano(Long.parseLong(id_plano));

            try {
                r_empresa.save(m_empresa);
                mensagem += "Pagamento realizado com sucesso, clique em OK para continuar";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Algo deu errado, tente novamente";
                podeSalvar = false;
            }
        }
        return new M_Resposta(podeSalvar, mensagem);
    }
}
