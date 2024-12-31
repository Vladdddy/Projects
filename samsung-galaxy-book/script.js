document.addEventListener('DOMContentLoaded', () => {
    const images = document.querySelectorAll('.image');
    const dots = document.querySelectorAll('.index-box .dot, .index-box .full-dot');
    let currentIndex = 0;

    function showImage(index) {
        images.forEach((img, i) => {
            img.style.display = i === index ? 'flex' : 'none';
        });

        dots.forEach((dot, i) => {
            dot.className = i === index ? 'full-dot' : 'dot';
        });
    }

    function nextImage() {
        currentIndex = (currentIndex + 1) % images.length;
        showImage(currentIndex);
    }

    setInterval(nextImage, 3000);
    showImage(currentIndex);
});

