package site.HealthHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.HealthHub.Model.M_Consulta;


@Repository
public interface R_Consulta extends JpaRepository<M_Consulta,String> {


}