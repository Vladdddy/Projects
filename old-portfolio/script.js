window.addEventListener('scroll', function () {
    var competencies = document.getElementById('competencies');
    var position = competencies.getBoundingClientRect().top;

    if (position < window.innerHeight && position > 0) {
        competencies.classList.add('show');
    } else if (position < window.inner) {
        competencies.classList.remove('show');
    }
});

window.addEventListener('scroll', function () {
    var skills = document.getElementById('skills');
    var position = skills.getBoundingClientRect().top;

    if (position < window.innerHeight && position > 0) {
        skills.classList.add('show');
    } else if (position < window.inner) {
        skills.classList.remove('show');
    }
});

window.addEventListener('scroll', function () {
    var certificates_carousel = document.getElementById('certificates_carousel');
    var position = certificates_carousel.getBoundingClientRect().top;

    if (position < window.innerHeight && position > 0) {
        certificates_carousel.classList.add('show');
    } else if (position < window.inner) {
        certificates_carousel.classList.remove('show');
    }
});

window.addEventListener('scroll', function () {
    var graph = document.getElementById('graph');
    var position = graph.getBoundingClientRect().top;

    if (position < window.innerHeight && position > 0) {
        graph.classList.add('show');
    } else if (position < window.inner) {
        graph.classList.remove('show');
    }
});

function acceptCookies() {
    document.getElementById('cookie-consent').style.display = 'none';
    // Add your code to handle cookie acceptance here
    console.log('Cookies accepted');
}

function declineCookies() {
    document.getElementById('cookie-consent').style.display = 'none';
    // Add your code to handle cookie decline here
    console.log('Cookies declined');
}