// Array de produtos
const produtos = [
    {
        nome: "Pão Francês",
        descricao: "Tradicional, quentinho e crocante.",
        preco: 0.50
    },
    {
        imagem: "/images/croissant.jpg",
        nome: "Croissant",
        descricao: "Massa amanteigada, macia e saborosa.",
        preco: 4.00
    },
    {
        imagem: "/images/pao-integral.jpg",
        nome: "Pão Integral",
        descricao: "Feito com farinha integral e sementes.",
        preco: 2.50
    },
    {
        imagem:"/imagens/bolo",
        nome: "Bolo de Cenoura",
        descricao: "Fofinho, com cobertura de chocolate.",
        preco: 15.00
    },
    {

        nome: "Cookie de Chocolate",
        descricao: "Crocrante por fora, macio por dentro.",
        preco: 3.00
    }
];

// Seleciona a div de produtos
const produtosContainer = document.querySelector(".produtos");

// Função para criar os cards de produto
produtos.forEach(produto => {
    const card = document.createElement("div");
    card.classList.add("produto-card");
    card.innerHTML = `
        <h3>${produto.nome}</h3>
        <p>${produto.descricao}</p>
        <p>R$ ${produto.preco.toFixed(2)}</p>
        <button onclick="adicionarAoCarrinho('${produto.nome}', ${produto.preco})">Adicionar ao carrinho</button>
    `;
    produtosContainer.appendChild(card);
});

// Função de exemplo para adicionar ao carrinho
function adicionarAoCarrinho(nome, preco) {
    alert(`${nome} adicionado ao carrinho por R$ ${preco.toFixed(2)}!`);
    // Aqui você pode chamar seu código do carrinho.js para atualizar o carrinho
}
