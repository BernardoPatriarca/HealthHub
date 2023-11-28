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
import site.HealthHub.Service.S_Usuario;

@Controller
public class C_Usuario {

    @GetMapping("/")
    public String getLogin(HttpSession session) {
        if (session.getAttribute("usuario") != null) {
            return "redirect:/Home";
        } else {
            return "/index";
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean postLogin(@RequestParam("CPF") String CPF,
                             @RequestParam("senha") String senha,
                             HttpSession session) {
        session.setAttribute("usuario", S_Usuario.verificaLogin(CPF, senha));
        if (session.getAttribute("usuario") == null) {
            return false;
        } else {
            return true;
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("usuario", null);
        return "redirect:/";
    }

    @GetMapping("/cadastro")
    public String getCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping("/termos")
    public String getTermos() {
        return "usuario/termos";
    }

    @PostMapping("/cadastro")
    @ResponseBody
    public M_Resposta cadastrarUsuario(@RequestParam("nome") String nome,
                                       @RequestParam("email") String email,
                                       @RequestParam("CPF") String CPF,
                                       @RequestParam("senha") String senha,
                                       @RequestParam("relacao") String relacao) {
        return S_Usuario.cadastrarUsuario(nome, email, CPF, senha, relacao);
    }

    @GetMapping("/edit")
    public String getHome(HttpSession session,
                          Model model){
        if(session.getAttribute("usuario") != null) {
            model.addAttribute("usuario", session.getAttribute("usuario"));
            return "/usuario/edit";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/edit")
    @ResponseBody
    public M_Resposta postEditUsuario(@RequestParam("nome") String nome,
                                      @RequestParam("email") String email,
                                      @RequestParam("senhaAtual") String senhaAtual,
                                      @RequestParam("novaSenha") String novaSenha,
                                      @RequestParam("confSenha") String confSenha,
                                      HttpSession session) {
        return S_Usuario.updateUsuario(nome, email, senhaAtual, novaSenha, confSenha, session.getAttribute("usuario"));
    }

}
