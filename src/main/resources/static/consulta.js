function salvarConsulta(){
    let observacao = $("#observacao").val();
    let dataConsulta = $("#dataConsulta").val();
    let id_cadastro = $("#id_cadastro").val();

    $.ajax({
        type: "POST",
        url: "/consulta",
        data:{
            observacao:observacao,
            dataConsulta:dataConsulta,
            id_cadastro:id_cadastro,
        },
        success: function(data){
            if(data.sucesso){
                alertaSucesso("Feedback enviado com sucesso");
            }else{
                alert(data.mensagem);
            }
        },
        error: function(){
            alert("Algo deu errado, tente novamente");
        }
    })
}