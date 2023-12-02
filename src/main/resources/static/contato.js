function salvarFeedback(){
    let feedback = $("#feedback").val();

    $.ajax({
        type: "POST",
        url: "/contato",
        data:{
            feedback:feedback,
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
