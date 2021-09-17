/**
 * Confirmação de exclusão de um contato
 * @author Paloma Kimberly
 */

function confirmar (codigo){
	let resposta = confirm("Confirma a exclusão desse item? ")
	if (resposta === true){
		// alert(codigo)
	window.location.href = "delete?codigo=" + codigo
	}}
	
	function somar (){


	let quanti = lista.quantidade.value;
	
	//document.querySelector('.quantidade');
	//lista.get(i).getQuantidade;

	//var pre = lista.preco.value;
	//lista.get(i).getPreco;
	
	//var resultado = quanti * pre;
	
	
	
	//document.querySelector('.resultado').innerHTML = resultado;
alert(quanti);

}

