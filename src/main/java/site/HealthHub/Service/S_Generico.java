package site.HealthHub.Service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class S_Generico {
    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean textoEstaVazio(String texto) {
        return texto == null || texto.trim().equals("");
    }

    public static String limparNumero(String numero) {
        return numero.replaceAll("[^0-9]", "");
    }

    public static boolean validarCPF(String cpf) {
        return cpf.matches("^\\d{11}$");
    }

    public static boolean validarCNPJ(String cnpj) {
        return cnpj.matches("^\\d{14}$");
    }

    public static boolean validarNumeroCartao(String numeroCartao) {
        return numeroCartao.matches("^\\d{16}$");
    }

    public static boolean validarCodigoCartao(String codigoCartao) {
        return codigoCartao.matches("^\\d{3}$");
    }

    public static boolean validarDataCartao(String dataValidade) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        dateFormat.setLenient(false);

        try {
            Date currentDate = new Date();
            Date inputDate = dateFormat.parse(dataValidade);

            return inputDate.after(currentDate);
        } catch (ParseException e) {
            return false;
        }
    }
    public static boolean validarSenha(String senha) {
        return senha.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@*#_$%^&+=!]).{10,}$");
    }

}
