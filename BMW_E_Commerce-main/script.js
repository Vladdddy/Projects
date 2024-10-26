const menu = document.getElementById("menu");
const navbar = document.getElementById("navbar");
const sideMenu = document.getElementById("sideMenu");
const sideNavbar = document.getElementById("sideNavbar");
const sideContent = document.getElementById("sideContent");
const description = document.getElementById("description");

menu.onclick = function () {
    navbar.style.display = "none";
    description.style.display = "none";
    sideMenu.style.display = "flex";
    sideNavbar.style.display = "flex";
};
0
sideMenu.onclick = function () {
    navbar.style.display = "flex";
    description.style.display = "block";
    sideMenu.style.display = "none";
    sideNavbar.style.display = "none";
};