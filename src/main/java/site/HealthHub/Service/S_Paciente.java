package site.HealthHub.Service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import site.HealthHub.Model.M_Paciente;
import site.HealthHub.Model.M_Resposta;
import site.HealthHub.Repository.R_Paciente;

@Service
public class S_Paciente {
    private static R_Paciente r_paciente;

    public S_Paciente(R_Paciente r_paciente) {
        this.r_paciente = r_paciente;
    }
    public static M_Resposta insertPaciente(String id_cadastro, String doencas,String alergias,String uso_medicamentos,Object paciente){
        boolean podeEditar = false;
        String mensagem = "";

        if (!S_Generico.textoEstaVazio(doencas)) {
            podeEditar = true;
            mensagem += "O campo doença prescisa ser preenchido!";
        }
        if (!S_Generico.textoEstaVazio(alergias)) {
            podeEditar = true;
            mensagem += "O campo alergias prescisa ser preenchido!";
        }
        if (!S_Generico.textoEstaVazio(uso_medicamentos)) {
            podeEditar = true;
            mensagem += "O campo medicamentos prescisa ser preenchido!";
        }
        if (!S_Generico.textoEstaVazio(id_cadastro)) {
            podeEditar = true;
            mensagem += "O campo ID do paciente prescisa ser preenchido!";
        }


        if(podeEditar){
            M_Paciente m_paciente = new M_Paciente();
            m_paciente.setDoencas(doencas);
            m_paciente.setAlergias(alergias);
            m_paciente.setUso_medicamentos(uso_medicamentos);
            m_paciente.setId_cadastro(Long.parseLong(id_cadastro));
            try {
                r_paciente.save(m_paciente);
                mensagem += "Perfil atualizado com sucesso";
            }catch (DataIntegrityViolationException e){
                podeEditar = false;
                mensagem += "Falha ao tentar atualizar o cadastro: "+ e.getMessage();
            }
        }
        return new M_Resposta(podeEditar,mensagem);
    }
}