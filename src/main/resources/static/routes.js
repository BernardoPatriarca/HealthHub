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

            case "/calendario":
            $.get(url,function(data){
            $("#pagina").html(data);
            createCalendar(new Date());
            $("#next-month").click(function(){
            atualizaCalendario(1);
            });
            $("#previous-month").click(function(){
            atualizaCalendario(-1);
            });
            });
            break;

            default:
            $.get(url,function(data){
            $(".container").html(data);
        });
    }
}