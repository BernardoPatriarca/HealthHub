package site.HealthHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import site.HealthHub.Model.M_Paciente;

@Repository
public interface R_Paciente extends JpaRepository<M_Paciente,Long> {
    @Modifying
    @Query("INSERT INTO M_Paciente (doencas, alergias, uso_medicamentos, id_cadastro) VALUES (:doencas, :alergias, :uso_medicamentos, :id_cadastro)")
    void insereHistorico(@Param("doencas") String doencas, @Param("alergias") String alergias, @Param("uso_medicamentos") String uso_medicamentos, @Param("id_cadastro") String id_cadastro);


}