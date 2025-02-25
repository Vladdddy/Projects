function search() {
    const content = document.getElementById("content");
    const computedStyle = window.getComputedStyle(content).display;

    if (computedStyle === "none") {
        content.style.display = "block";
    } else {
        content.style.display = "none";
    }
}
