package site.HealthHub.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="cartao")
public class M_Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private long CNPJ;
    private String nomeCartao;
    private long numeroCartao;
    private long codigoCartao;
    private LocalDate validadeCartao;
    private Long id_plano;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public long getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(long numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public long getCodigoCartao() {
        return codigoCartao;
    }

    public void setCodigoCartao(long codigoCartao) {
        this.codigoCartao = codigoCartao;
    }

    public LocalDate getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(LocalDate validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    public Long getId_plano() {
        return id_plano;
    }

    public void setId_plano(Long id_plano) {
        this.id_plano = id_plano;
    }
}