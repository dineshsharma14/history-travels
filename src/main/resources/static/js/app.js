
let spots = [
    {
        name: "Brihadisvara Temple",
        tag: "chola temple",
        inCart: 0
    },
    {
        name: "Rajaraja Chola Museum",
        tag: "chola museum",
        inCart: 0
    },
    {
        name: "Srirangam Temple",
        tag: "chola temple1",
        inCart: 0
    },
];

if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready)
} else {
    ready();
    addItemToCart();

}

function ready() {

    let addToCartButtons = document.getElementsByClassName('addToCart');
    for (let i = 0; i < addToCartButtons.length; i++) {
        let button = addToCartButtons[i];
        button.addEventListener("click", () => {
            cartNumbers(spots[i]);
        });
    }

    let deleteButton = document.getElementsByClassName("deleteButton")[0];
    if (deleteButton)
        deleteButton.addEventListener("click", deleteCartItems);

    let itemCountTop = document.getElementById("theCart");
    console.log(itemCountTop);
    itemCountTop.addEventListener("click", () => {
        addItemToCart();
    });

    showCart();
    onLoadCartNumbers();
}

function cartNumbers(place) {
    let trailNumbers = localStorage.getItem("trailNumbers");
    trailNumbers = parseInt(trailNumbers);
    if (trailNumbers) {
        localStorage.setItem("trailNumbers", trailNumbers + 1);
        document.getElementById("item-count").textContent = trailNumbers + 1;
    } else {
        localStorage.setItem("trailNumbers", 1);
        document.getElementById("item-count").textContent = 1;
    }
    alert("The place is added in your trail");
    setItems(place);
    hideAddToCartButton(place);
}

function hideAddToCartButton(place) {
    console.log("*******in hideAddToCartButton*******");
    let addToCartButtons = document.getElementsByClassName('addToCart');
    for (let i = 0; i < addToCartButtons.length; i++) {
        let button = addToCartButtons[i];
        console.log(button);
        let spotAdded = button.parentElement.parentElement
            .children[0].children[1].textContent;
        console.log(spotAdded);
        if (place.name == spotAdded) {
            console.log(button.children[0]);
            button.children[0].disabled = true;
        }
    }
    console.log("*******leaving hideAddToCartButton*******");
}

function onLoadCartNumbers() {
    let trailNumbers = localStorage.getItem("trailNumbers");

    if (trailNumbers) {
        document.getElementById("item-count").textContent = trailNumbers;
    }

    // Not allowing users to add the places if already added once
    let trailItems = localStorage.getItem("placesInCart");
    trailItems = JSON.parse(trailItems);
    console.log(trailItems);
    if (trailItems != null) {
        console.log("Calling the disable add to cart buttons fx");
        disableAddToCartButtons(trailItems);
    }
}

function setItems(place) {
    let trailItems = localStorage.getItem("placesInCart");
    trailItems = JSON.parse(trailItems);

    if (trailItems != null) {
        if (trailItems[place.tag] == undefined) {
            trailItems = {
            // grab whatever is already there in the cart using the rest operator
                ...trailItems,
                [place.tag]: place
            };
        }
        trailItems[place.tag].inCart += 1;
    } else {
        place.inCart = 1;
        trailItems = {
            [place.tag]: place
        };
    }

    localStorage.setItem("placesInCart", JSON.stringify(trailItems));

}

function addItemToCart() {


    console.log("I am inside the addItemToCart fx");
    let cartItems = localStorage.getItem("placesInCart");
    cartItems = JSON.parse(cartItems);
    console.log("Found some cart items from LS: " + cartItems);
    let trailContainer = document.getElementById("cart");

    console.log("Let's first remove the already existing items");
    let existingCartItems = document.getElementsByClassName("cart-item");
    console.log(existingCartItems);
    if (existingCartItems) {
        for (let i = 0; i < existingCartItems.length; i++) {
            console.log("deleting");
            existingCartItems[i].remove();
        }
    }

    if (cartItems) {
        console.log("As there are items in the LS lets add them to cart!");
        console.log("Building the divs for each item!");
        let cartItem = document.createElement("div");
        cartItem.classList.add("cart-item", "d-flex",
                    "justify-content-between", "text-capitalize", "my-3");
        cartItem.innerHTML = "";
        Object.values(cartItems).map(item => {
            cartItem.innerHTML += `
                <p id="cart-item-title" class="font-weight-bold mb-0">${item.name}</p>
                `;
            });
        let total = document.querySelector(".cart-total-container");
        trailContainer.insertBefore(cartItem, total);
    }

}

function removeCartItem(event) {
    let buttonClicked = event.target;
    buttonClicked.parentElement.parentElement.remove();
}

function showCart() {
    const cartInfo = document.getElementById("cart-info");
    const cart = document.getElementById("cart");

    cartInfo.addEventListener("click", function() {
        cart.classList.toggle("show-cart");
    });
}

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

function disableAddToCartButtons(trailItems) {
    console.log("Inside the disableAddToCartButtons fx")
    let addToCartButtons = document.getElementsByClassName('addToCart');
    console.log(addToCartButtons);
    console.log(trailItems);
    console.log(trailItems.length);
    // converting an hash-map or a dictionary into a list
    addedItems = Object.values(trailItems);
    console.log(addedItems);
    if (addToCartButtons) {

        for (let i = 0; i < addToCartButtons.length; i++) {
            let button = addToCartButtons[i];
            let spot = button.parentElement
                       .parentElement.children[0].children[1].textContent;
            console.log(spot);
            for (let j = 0; j < addedItems.length; j++) {
                let spotAlreadyAdded = addedItems[j].name;
                console.log(spotAlreadyAdded);
                if (spot == spotAlreadyAdded) {
                    button.children[0].disabled = true;
                }

            }
        }


    }
}

