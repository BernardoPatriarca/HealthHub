$("#assinar").click(assinar);

function assinar(){
	let nomeEmpresa = $("#nomeEmpresa").val();
	let CNPJ = $("#CNPJ").val();
	let numeroCartao = $("#numeroCartao").val();
	let nomeCartao = $("#numeroCartao").val();
	let codigoCartao = $("#codigoCartao").val();
	let validade = $("#validade").val();
	let id_plano = $("#id_plano")[0].value;

	$.ajax({
		type: "POST",
		url: "/plano",
		data:{
			nomeEmpresa:nomeEmpresa,
			CNPJ:CNPJ,
			numeroCartao:numeroCartao,
			nomeCartao:nomeCartao,
			codigoCartao:codigoCartao,
			validade:validade,
			id_plano:id_plano,
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