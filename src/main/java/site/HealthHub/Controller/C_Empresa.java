package site.HealthHub.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import site.HealthHub.Model.M_Resposta;
import site.HealthHub.Service.S_Empresa;

@Controller
public class C_Empresa {

    @GetMapping("/contrato")
    public String getContrato(HttpSession session,
                             Model model){
        if(session.getAttribute("usuario") != null) {
            return "home/Servicos/contrato";
        }else{
            return "redirect:/";
        }
    }
    @GetMapping("/plano")
    public String getPlano(HttpSession session,
                             Model model){
        if(session.getAttribute("usuario") != null) {
            model.addAttribute("usuario", session.getAttribute("usuario"));
            return "home/Servicos/plano";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/plano")
    @ResponseBody
    public M_Resposta postEmpresa(@RequestParam("nomeEmpresa") String nomeEmpresa,
                                         @RequestParam("CNPJ") String CNPJ,
                                         @RequestParam("nomeCartao") String nomeCartao,
                                         @RequestParam("numeroCartao") String numeroCartao,
                                         @RequestParam("codigoCartao") String codigoCartao,
                                         @RequestParam("validade") String validade,
                                         @RequestParam("id_plano") String id_plano,
                                         HttpSession session) {

            return S_Empresa.insertEmpresa(nomeEmpresa, CNPJ, nomeCartao, numeroCartao,codigoCartao,validade,id_plano);
    }
}