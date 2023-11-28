function salvarHistorico(){
    let doencas = $("#doencas").val();
    let alergias = $("#alergias").val();
    let uso_medicamentos = $("#uso_medicamentos").val();
    let id_cadastro = $("#id_cadastro").val();

    $.ajax({
        type: "POST",
        url: "/paciente",
        data:{
            doencas:doencas,
            alergias:alergias,
            uso_medicamentos:uso_medicamentos,
            id_cadastro:id_cadastro,
        },
        success: function(data){
            if(data.sucesso){
                alertaSucesso("Historico atualizado com sucesso");
            }else{
                alert(data.mensagem);
            }
        },
        error: function(){
            alert("Deu ruim");
        }
    })
}
