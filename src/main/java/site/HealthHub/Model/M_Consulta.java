package site.HealthHub.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "consulta")
public class M_Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_cadastro;
    private String observacao;
    private LocalDate dataConsulta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_cadastro() {
        return id_cadastro;
    }

    public void setId_cadastro(Long id_cadastro) {
        this.id_cadastro = id_cadastro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
}
