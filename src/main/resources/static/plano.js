$("#assinar").click(assinar);

function assinar(){
	let nome = $("#nome").val();
	let CNPJ = $("#CNPJ").val();
	let numeroCartao = $("#numeroCartao").val();
	let nomeCartao = $("#numeroCartao").val();
	let codigoCartao = $("#codigoCartao").val();
	let validadeCartao = $("#validadeCartao").val();
	let plano = $("#plano")[0].value;

	$.ajax({
		type: "POST",
		url: "/plano",
		data:{
			nome:nome,
			CNPJ:CNPJ,
			numeroCartao:numeroCartao,
			nomeCartao:nomeCartao,
			codigoCartao:codigoCartao,
			validadeCartao:validadeCartao,
			plano:plano,
		},
		success:function(data){
		    alert(data.mensagem);
		    if(data.sucesso){
			    window.location.href="/";
			}
		},
		error: function(){
			alert("Algo deu errado, tente novamente");
		}
	});
}