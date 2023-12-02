package site.HealthHub.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import site.HealthHub.Model.M_Resposta;
import site.HealthHub.Service.S_Contato;
import site.HealthHub.Service.S_Paciente;

@Controller
public class C_Contato {
    @GetMapping("/contato")
    public String getContato(HttpSession session,
                          Model model){
        if(session.getAttribute("usuario") != null) {
            model.addAttribute("usuario", session.getAttribute("usuario"));
            return "home/Servicos/contato";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/contato")
    @ResponseBody
    public M_Resposta postEnviarFeedback(@RequestParam("feedback") String feedback,
                                         HttpSession session) {

        return S_Contato.insertContato(feedback);
    }
}
