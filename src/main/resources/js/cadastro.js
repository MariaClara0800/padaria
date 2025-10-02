document.getElementById("cadastroForm").addEventListener("submit", function(event){
    event.preventDefault();

    const nome = document.getElementById("nome").value;
    const cpf = document.getElementById("cpf").value;
    const telefone = document.getElementById("telefone").value;
    const dataNascimento = document.getElementById("dataNascimento").value;

    // Mensagem de sucesso simples
    const mensagem = `Cadastro realizado com sucesso!\nNome: ${nome}\nCPF: ${cpf}\nTelefone: ${telefone}\nData de Nascimento: ${dataNascimento}`;
    document.getElementById("mensagem").innerText = mensagem;

    // Limpar formulário
    this.reset();
});
