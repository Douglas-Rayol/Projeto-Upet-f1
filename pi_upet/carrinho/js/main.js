const cartIcon = document.querySelector("#cart-icon");
const cart= document.querySelector(".cart");
const closeCart = document.querySelector("#close-cart");

cartIcon.addEventListener("click", () => {
    cart.classList.add("active");
});

closeCart.addEventListener("click", () =>{
    cart.classList.remove("active");
});

if(document.readyState == "loading"){
    document.addEventListener("DOMContentLoaded", start);
 } else{
    start();
}

//======================= START =======================
function start(){
    addEvents();
}

//======================= UPDATE ======================
function update(){
    addEvents();
    updateTotal();
}
//======================= ADD EVERNTS =================
function addEvents(){
    // Remover Item do carrinho 
    let cartRemove_btns = document.querySelectorAll(".cart-romove");
    console.log(cartRemove_btns);
    cartRemove_btns.forEach((btn) => {
        btn.addEventListener("click", handle_removerCartIytem);
    });

    //change item quantity
    let cartQuantity_inputs = document.querySelectorAll(".cart-quantity");
    cartQuantity_inputs.forEach((input) => {
        input.addEventListener("change", handle_changeItemQuantity);
    });

    // Add item to cart
    let addCart_btns = document.querySelectorAll(".add-cart");
    addCart_btns.forEach((btn) => {
        btn.addEventListener("click", handle_addCartItem);
    });

    //Enviar via WhatsApp
    const btncomprar = document.querySelector(".btn-comprar");
    btncomprar.addEventListener("click", handle_btncomprar);
}

//======================= HANDLE EVENTS ===============
let itemsAdded = []

function handle_addCartItem() {
    let product = this.parentElement;
    let title = product.querySelector(".produto-title").innerHTML;
    let price = product.querySelector(".price").innerHTML;
    let imgSrc = product.querySelector(".produto-img").src;
    console.log(title, price, imgSrc);

    let newToAdd = {
        title,
        price,
        imgSrc,
    };

    //produto existe
    if(itemsAdded.find((el) => el.title == newToAdd.title)){
        alert ("Item já foi adicionado!");
        return;
    } else{
        itemsAdded.push(newToAdd);
    }

    // Add produto no cart
    let cartBoxElement = CartBoxComponent(title, price, imgSrc);
    let newNode = document.createElement("div");
    newNode.innerHTML = cartBoxElement;
    const cartContent = cart.querySelector(".cart-content");
    cartContent.appendChild(newNode);

    update();
}

function handle_removerCartIytem(){
    this.parentElement.remove();
    itemsAdded = itemsAdded.filter(el=>el.title != this.parentElement.querySelector(".cart-produto-title").innerHTML);
    updateTotal();
}

function handle_changeItemQuantity(){
    if (Number.isNaN(this.value) || this.value < 1) {
       this.value = 1; 
    }
    this.value = Math.floor(this.value);

    update();
}

function handle_btncomprar(){
    if(itemsAdded.length <= 0){
        alert("Faça um pedido primeiro.");
        return;
    }
    const cartContent = cart.querySelector(".cart-content");
    cartContent.innerHTML = '';
    alert("Seu pedido foi enviado com sucesso");
    itemsAdded = [];

    update();
}

//====================== UPDATE FUNCTIONS ==============
function updateTotal(){
    let cartBoxes = document.querySelectorAll(".cart-box");
    const totalElement = cart.querySelector(".total-price");
    let total = 0;
    cartBoxes.forEach((cartBox) => {
        let priceElement = cartBox.querySelector(".price");
        let price = parseFloat(priceElement.innerHTML.replace("R$", ""));
        let quantity = cartBox.querySelector(".cart-quantity").value;
        total += price * quantity;
    });
    
    total = total.toFixed(2);
    total = Math.round(total * 100) / 100;

    totalElement.innerHTML = "R$" + total;
}


//====================== HTML ========================
function CartBoxComponent(title, price, imgSrc){
    return `
    <div class="cart-box">
        <img src=${imgSrc} alt="" class="cart-img">
        <div class="detalhe-box">
            <div class="cart-produto-title">${title}</div>
            <div class="price">${price}</div>
            <input type="number" value="1" class="cart-quantity">
        </div>
        <!--Remover do carrinho-->
        <i class='bx bxs-trash-alt cart-romove'></i>
    </div>`;
}