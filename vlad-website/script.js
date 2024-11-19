const menuBtn = document.getElementById("menu");
const menuText = document.getElementById("menuText");
const menuContainer = document.getElementById("menuContainer");
menuContainer.style.display = "none";

menuBtn.addEventListener("click", () => {
    if (menuContainer.style.display == "none") {
        menuContainer.style.display = "flex";
    } else {
        menuContainer.style.display = "none";
    }
});

menuText.addEventListener("click", () => {
    menuContainer.style.display = "none";
});