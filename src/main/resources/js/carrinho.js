let cart = [];

function loadCart() {
    // Carrega o carrinho salvo no localStorage
    cart = JSON.parse(localStorage.getItem("carrinho")) || [];
    updateCart();
}

function updateCart() {
    const cartItems = document.getElementById('cart-items');
    if (!cartItems) return;

    cartItems.innerHTML = '';
    let total = 0;

    cart.forEach((item, index) => {
        const li = document.createElement('li');
        li.textContent = `${item.nome} - R$ ${item.preco.toFixed(2)}`;

        // Clique remove o item
        li.onclick = () => {
            cart.splice(index, 1);
            localStorage.setItem("carrinho", JSON.stringify(cart)); // Atualiza no localStorage
            updateCart();
        };

        cartItems.appendChild(li);
        total += item.preco;
    });

    const cartTotal = document.getElementById('cart-total');
    const cartCount = document.getElementById('cart-count');
    if (cartTotal) cartTotal.textContent = total.toFixed(2);
    if (cartCount) cartCount.textContent = cart.length;
}

function finalizarCompra() {
    if (cart.length === 0) {
        alert('Carrinho vazio!');
        return;
    }

    const total = cart.reduce((sum, item) => sum + item.preco, 0);
    alert(`Compra finalizada!\nTotal: R$ ${total.toFixed(2)}`);

    cart = [];
    localStorage.removeItem("carrinho");
    updateCart();
}

function cancelarCompra() {
    if (confirm("Tem certeza que deseja cancelar a compra?")) {
        cart = [];
        localStorage.removeItem("carrinho");
        updateCart();
        alert("Compra cancelada.");
    }
}

// Quando a página carrega, carregar os itens do localStorage
window.onload = loadCart;
