document.getElementById("cadastroForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    // Coleta os dados do formulário
    const nome = document.getElementById("nome").value;
    const cpf = document.getElementById("cpf").value;
    const telefone = document.getElementById("telefone").value;
    const dataNascimento = document.getElementById("dataNascimento").value;

    const cliente = { nome, cpf, telefone, dataNascimento };

    try {
        // Faz o POST para o backend Spring Boot
        const resposta = await fetch("http://localhost:8080/usuarios", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(cliente)
        });

        if (!resposta.ok) {
            throw new Error("Erro ao cadastrar o cliente");
        }

        const dados = await resposta.json();

        // Mostra mensagem de sucesso
        document.getElementById("mensagem").innerText =
            `🎉 Cadastro realizado com sucesso!\nID: ${dados.id}\nNome: ${dados.nome}`;

        // Limpa o formulário
        this.reset();

    } catch (erro) {
        console.error("Erro:", erro);
        document.getElementById("mensagem").innerText =
            "❌ Falha ao cadastrar cliente. Verifique o servidor.";
    }
});
