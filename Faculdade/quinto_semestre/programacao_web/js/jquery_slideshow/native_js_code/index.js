/**
 * Function to manipulate slides
 */
function slide() {
    const activeSlide = document.querySelector(".ativo");
    const nextSlide = activeSlide.nextElementSibling;

    // Hide current active slide
    activeSlide.style.opacity = 0;
    activeSlide.classList.remove("ativo");

    if (nextSlide) {
        // Show next slide
        nextSlide.style.display = "block";
        nextSlide.classList.add("ativo");
        setTimeout(() => {
            nextSlide.style.opacity = 1;
        }, 50); // Small delay to trigger transition
    } else {
        // If no next slide, show the first one
        const firstSlide = document.querySelector("#slide img:first-of-type");
        firstSlide.style.display = "block";
        firstSlide.classList.add("ativo");
        setTimeout(() => {
            firstSlide.style.opacity = 1;
        }, 50);
    }

    // Update the caption
    const newText = document.querySelector(".ativo").getAttribute("alt");
    const slideParagraph = document.querySelector("#slide p");
    slideParagraph.style.display = "none";
    slideParagraph.innerHTML = newText;
    setTimeout(() => {
        slideParagraph.style.display = "block";
    }, 100);
}

// Slide show styling
document.addEventListener("DOMContentLoaded", () => {
    const firstSlide = document.querySelector("#slide img:first-of-type");
    firstSlide.classList.add("ativo");
    firstSlide.style.display = "block";
    firstSlide.style.opacity = 1; // Start with the first image fully visible

    // Add captions to images
    const initialText = firstSlide.getAttribute("alt");
    const slideContainer = document.getElementById("slide");
    const paragraph = document.createElement("p");
    paragraph.innerHTML = initialText;
    slideContainer.prepend(paragraph);

    setInterval(slide, 3000);
});
