package site.HealthHub.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import site.HealthHub.Model.M_Resposta;
import site.HealthHub.Service.S_Consulta;

@Controller
public class C_Consulta {
    @GetMapping("/consulta")
    public String getConsulta(HttpSession session,
                             Model model){
        if(session.getAttribute("usuario") != null) {
            model.addAttribute("usuario", session.getAttribute("usuario"));
            return "home/Servicos/consulta";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/consulta")
    @ResponseBody
    public M_Resposta postSalvarConsulta(@RequestParam("id_cadastro") String id_cadastro,
                                         @RequestParam("dataConsulta") String dataConsulta,
                                         @RequestParam("observacao") String observacao,
                                         HttpSession session) {

        return S_Consulta.insertConsulta(id_cadastro, dataConsulta, observacao);
    }
}
