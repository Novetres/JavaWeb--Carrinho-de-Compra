/**
 * Confirmação de exclusão de um contato
 * @author Paloma Kimberly
 */

function confirmar (codigo){
	
	
	
	let resposta = confirm("Confirma a exclusão deste contato?")
	if(resposta === true){
	window.location.href = "delete?codigo=" + codigo
}}