document.addEventListener("DOMContentLoaded", () => {
  const images = document.querySelectorAll(".image");
  const dots = document.querySelectorAll(
    ".index-box .dot, .index-box .full-dot"
  );
  let currentIndex = 0;

  function showImage(index) {
    images.forEach((img, i) => {
      img.style.display = i === index ? "flex" : "none";
    });

    dots.forEach((dot, i) => {
      dot.className = i === index ? "full-dot" : "dot";
    });
  }

  function nextImage() {
    currentIndex = (currentIndex + 1) % images.length;
    showImage(currentIndex);
  }

  setInterval(nextImage, 3000);
  showImage(currentIndex);
});

document.addEventListener("DOMContentLoaded", () => {
  const images = document.querySelectorAll(".image-shop");
  const dots = document.querySelectorAll(
    ".index-box-shop .dot, .index-box-shop .full-dot"
  );
  const arrowLeft = document.getElementById("arrowLeft");
  const arrowRight = document.getElementById("arrowRight");
  let currentIndex = 0;

  function showImage(index) {
    images.forEach((img, i) => {
      if (i === index) {
        img.classList.add("active");
      } else {
        img.classList.remove("active");
      }
    });

    dots.forEach((dot, i) => {
      dot.className = i === index ? "full-dot" : "dot";
    });
  }

  arrowLeft.addEventListener("click", () => {
    currentIndex = (currentIndex - 1 + images.length) % images.length;
    showImage(currentIndex);
  });

  arrowRight.addEventListener("click", () => {
    currentIndex = (currentIndex + 1) % images.length;
    showImage(currentIndex);
  });

  // Initial display
  showImage(currentIndex);
});
