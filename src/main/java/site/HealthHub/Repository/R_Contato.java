package site.HealthHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.HealthHub.Model.M_Contato;

@Repository
public interface R_Contato extends JpaRepository<M_Contato,String> {


}