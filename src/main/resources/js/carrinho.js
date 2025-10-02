let cart = [];

function addToCart(id) {
    const produto = produtos.find(p => p.id === id);
    cart.push(produto);
    updateCart();
}

function updateCart() {
    const cartItems = document.getElementById('cart-items');
    if(!cartItems) return;

    cartItems.innerHTML = '';
    let total = 0;
    cart.forEach((item, index) => {
        const li = document.createElement('li');
        li.textContent = `${item.nome} - R$ ${item.preco.toFixed(2)}`;
        li.onclick = () => {
            cart.splice(index, 1);
            updateCart();
        };
        cartItems.appendChild(li);
        total += item.preco;
    });
    const cartTotal = document.getElementById('cart-total');
    const cartCount = document.getElementById('cart-count');
    if(cartTotal) cartTotal.textContent = total.toFixed(2);
    if(cartCount) cartCount.textContent = cart.length;
}

function finalizarCompra() {
    if(cart.length === 0) {
        alert('Carrinho vazio!');
        return;
    }
    alert(`Compra finalizada! Total: R$ ${cart.reduce((a,b)=>a+b.preco,0).toFixed(2)}`);
    cart = [];
    updateCart();
}
