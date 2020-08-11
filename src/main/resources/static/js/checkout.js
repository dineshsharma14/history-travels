let checkoutCart = document.querySelector(".checkout-items");
console.log(checkoutCart);
if (checkoutCart) {
    checkoutCartItems();
}

function checkoutCartItems() {
    console.log("checkout fx");
    let cartItems = localStorage.getItem("placesInCart");
    cartItems = JSON.parse(cartItems);
    let productContainer = document.querySelector(".checkout-items");
    if (cartItems && productContainer) {
        productContainer.innerHTML = "";
        Object.values(cartItems).map(item => {
                    productContainer.innerHTML += `
                    <div class="card">
                            <div class="card-body checkout-cart">
                                <p class="card-text">${item.name}</p>
                            </div>
                    </div>
                    `;
                    });

    }

    fillTrailDetails();
}

function fillTrailDetails() {
    let formField = document.getElementById("trailDetails");
    console.log(formField);
    formField.value = "";
    if (formField) {
        let trailDetails = document.getElementsByClassName("card-text");
        console.log(trailDetails);
        for (let i = 0; i < trailDetails.length; i++) {
            formField.value += trailDetails[i].textContent + ", ";
        }
    }
    console.log(formField.value);
}
