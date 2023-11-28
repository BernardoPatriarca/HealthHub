$("#enviar").click(cadastro);

function cadastro(){
	let nome = $("#nome").val();
	let email = $("#email").val();
	let CPF = $("#CPF").val();
	let senha = $("#senha").val();
	let relacao =$("#relacao")[0].value;

	$.ajax({
		type: "POST",
		url: "/cadastro",
		data:{
			nome:nome,
			email:email,
			CPF:CPF,
			senha:senha,
			relacao:relacao,
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