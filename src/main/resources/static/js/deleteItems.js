function deleteCartItems() {
    console.log("delete fx");
    let cartItems = localStorage.getItem("placesInCart");
    cartItems = JSON.parse(cartItems);
    let trailNumbers = localStorage.getItem("trailNumbers");
    trailNumbers = parseInt(trailNumbers);
    if (trailNumbers){
        localStorage.removeItem("trailNumbers");
        document.getElementById("item-count").textContent = 0;
    }
    if (cartItems)
        localStorage.removeItem("placesInCart");

}

deleteCartItems();