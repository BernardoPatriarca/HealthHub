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
    import site.HealthHub.Service.S_Paciente;

    @Controller
    public class C_Paciente {
        @GetMapping("/paciente")
        public String getEditHistorico(HttpServletRequest request,
                                       HttpSession session,
                                       Model model) {
            if (request.getHeader("Referer") != null) {
                Object paciente = session.getAttribute("paciente");
                model.addAttribute("paciente", paciente);
                return "/home/Servicos/paciente";
            }
            return "redirect:/";
        }
        @PostMapping("/paciente")
        @ResponseBody
        public M_Resposta postEditHistorico(@RequestParam("id_cadastro") String id_cadastro,
                                            @RequestParam("doencas") String doencas,
                                            @RequestParam("alergias") String alergias,
                                            @RequestParam("uso_medicamentos") String uso_medicamentos,
                                            HttpSession session

        ) {
            return S_Paciente.insertPaciente(id_cadastro, doencas, alergias,uso_medicamentos,session.getAttribute("paciente"));
        }
    }
