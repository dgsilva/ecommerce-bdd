#language: pt

Funcionalidade: Acessar Conta
	como um cliente da loja virtual
	eu quero acessar minha conta
	para que eu possa realizar meus pedidos
	
Cenário: Acessar conta de cliente com sucesso
	Dado Acessar a página de autenticação de cliente
	E Informar o email de acesso "sergio.coti@gmail.com"
	E Informar a senha de acesso "@Admin123"
	Quando Solicitar a realização do acesso
	Então Sistema autentica o cliente com sucesso
	
	Cenário: Acessar conta de cliente com erro
	Dado Acessar a página de autenticação de cliente
	E Informar o email de acesso "Teste.coti@gmail.com"
	E Informar a senha de acesso "@Admin12345421"
	Quando Solicitar a realização do acesso
	Então Sistema autentica o cliente com sucesso
