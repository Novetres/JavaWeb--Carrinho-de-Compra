/**
 * Validacao dos campos obrigatorios
 * @author Paloma Kimberly
 */

function validar() {
	let item = frmContato.item.value;
	let quantidade = frmContato.quantidade.value;
	let preco = frmContato.preco.value;
	if (item === '') {
		alert('Preencha o nome do item')
		frmContato.item.focus();
		return false
		
		
		} else if 		(quantidade === '') {
		alert('Preencha a quantidade do item')
		frmContato.quantidade.focus();
		return false
		
		
		
		} else if 		(preco === '') {
		alert('Preencha o preço do item')
		frmContato.preco.focus();
		return false
				
		} else {			
		document.forms['frmContato'].submit();
		
		}
		
}

	
	
