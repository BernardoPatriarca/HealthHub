function controleRotasGet(url){
    switch(url){
        case "/logout":
            gerarSwal(url);
            break;

            case "/edit":
            $.get(url,function(data){
            $("#pagina").html(data);
            $("#salvar").click(salvarPerfil);
            });
            break;

            case "/":
            $.get(url,function(data){
            $("#pagina").html(data);
            });
            break;

            case "/paciente":
            $.get(url,function(data){
            $("#pagina").html(data);
            $("#atualizar").click(salvarHistorico);
            });
            break;

            case "/contato":
            $.get(url,function(data){
            $("#pagina").html(data);
            $("#enviar").click(salvarFeedback);
            });
            break;

            case "/contrato":
            $.get(url,function(data){
            $("#pagina").html(data);
            });
            break;

            case "/plano":
            $.get(url,function(data){
            $("#pagina").html(data);
            $("#assinar").click(assinar);
            });
            break;

            case "/consulta":
            $.get(url,function(data){
            $("#pagina").html(data);
            $("#enviar").click(salvarConsulta);
            });
            break;

            default:
            $.get(url,function(data){
            $(".container").html(data);
        });
    }
}