package site.HealthHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.HealthHub.Model.M_Empresa;

@Repository
public interface R_Empresa extends JpaRepository<M_Empresa,String> {


}