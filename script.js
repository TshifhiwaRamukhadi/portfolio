// Mobile Navigation Toggle
const hamburger = document.querySelector('.hamburger');
const navMenu = document.querySelector('.nav-menu');

if (hamburger) {
    hamburger.addEventListener('click', () => {
        hamburger.classList.toggle('active');
        navMenu.classList.toggle('active');
    });

    // Close menu when clicking on a link
    document.querySelectorAll('.nav-menu a').forEach(link => {
        link.addEventListener('click', () => {
            hamburger.classList.remove('active');
            navMenu.classList.remove('active');
        });
    });
}

// Smooth scrolling for navigation links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            const offsetTop = target.offsetTop - 80;
            window.scrollTo({
                top: offsetTop,
                behavior: 'smooth'
            });
        }
    });
});

// Active navigation link on scroll
const sections = document.querySelectorAll('section[id]');
const navLinks = document.querySelectorAll('.nav-menu a');

function highlightNavigation() {
    const scrollY = window.pageYOffset;

    sections.forEach(section => {
        const sectionHeight = section.offsetHeight;
        const sectionTop = section.offsetTop - 100;
        const sectionId = section.getAttribute('id');

        if (scrollY > sectionTop && scrollY <= sectionTop + sectionHeight) {
            navLinks.forEach(link => {
                link.classList.remove('active');
                if (link.getAttribute('href') === `#${sectionId}`) {
                    link.classList.add('active');
                }
            });
        }
    });
}

window.addEventListener('scroll', highlightNavigation);

// Navbar background on scroll
const navbar = document.querySelector('.navbar');
window.addEventListener('scroll', () => {
    if (window.scrollY > 50) {
        navbar.classList.add('scrolled');
        navbar.style.boxShadow = '0 5px 20px rgba(0, 0, 0, 0.15)';
    } else {
        navbar.classList.remove('scrolled');
        navbar.style.boxShadow = '0 2px 10px rgba(0, 0, 0, 0.1)';
    }
    
    // Scroll progress indicator
    const scrollIndicator = document.getElementById('scrollIndicator');
    if (scrollIndicator) {
        const windowHeight = document.documentElement.scrollHeight - window.innerHeight;
        const scrolled = (window.scrollY / windowHeight) * 100;
        scrollIndicator.style.width = scrolled + '%';
    }
});

// Form submission handler
const contactForm = document.getElementById('contactForm');
if (contactForm) {
    contactForm.addEventListener('submit', function(e) {
        e.preventDefault();
        
        // Get form values
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const subject = document.getElementById('subject').value;
        const message = document.getElementById('message').value;
        
        // Create mailto link
        const mailtoLink = `mailto:tshifhiwaramukhadi@icloud.com?subject=${encodeURIComponent(subject)}&body=${encodeURIComponent(`Name: ${name}\nEmail: ${email}\n\nMessage:\n${message}`)}`;
        
        // Open email client
        window.location.href = mailtoLink;
        
        // Show success message
        alert('Thank you for your message! Your email client should open shortly.');
        
        // Reset form
        contactForm.reset();
    });
}

// Intersection Observer for fade-in animations
const observerOptions = {
    threshold: 0.1,
    rootMargin: '0px 0px -50px 0px'
};

const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.style.opacity = '1';
            entry.target.style.transform = 'translateY(0)';
        }
    });
}, observerOptions);

// Observe elements for animation
document.addEventListener('DOMContentLoaded', () => {
    const animateElements = document.querySelectorAll('.skill-category, .project-card, .education-item, .experience-section');
    animateElements.forEach(el => {
        el.style.opacity = '0';
        el.style.transform = 'translateY(20px)';
        el.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
        observer.observe(el);
    });
});

// Profile image error handler
const profileImg = document.getElementById('profile-img');
if (profileImg) {
    profileImg.addEventListener('error', function() {
        // If image fails to load, show initials
        this.style.display = 'none';
        const wrapper = this.parentElement;
        if (wrapper && !wrapper.querySelector('.initials-fallback')) {
            const fallback = document.createElement('div');
            fallback.className = 'initials-fallback';
            fallback.style.cssText = `
                width: 100%;
                height: 100%;
                display: flex;
                align-items: center;
                justify-content: center;
                background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                color: white;
                font-size: 4rem;
                font-weight: bold;
                border-radius: 50%;
            `;
            fallback.textContent = 'TR';
            wrapper.appendChild(fallback);
        }
    });
}

// Add loading state for images
if (profileImg && profileImg.complete && profileImg.naturalHeight === 0) {
    profileImg.dispatchEvent(new Event('error'));
}

// Typing animation for hero title
function typeWriter(element, text, speed = 100) {
    let i = 0;
    element.textContent = '';
    function type() {
        if (i < text.length) {
            element.textContent += text.charAt(i);
            i++;
            setTimeout(type, speed);
        }
    }
    type();
}

// Animate hero text on load
document.addEventListener('DOMContentLoaded', () => {
    const heroName = document.querySelector('.hero-title .name');
    if (heroName) {
        const originalText = heroName.textContent;
        heroName.style.opacity = '0';
        setTimeout(() => {
            heroName.style.opacity = '1';
            heroName.style.transition = 'opacity 0.5s ease';
        }, 500);
    }
});

// Floating animation for profile image
const profileWrapper = document.querySelector('.image-wrapper');
if (profileWrapper) {
    setInterval(() => {
        profileWrapper.style.animation = 'none';
        setTimeout(() => {
            profileWrapper.style.animation = 'float 3s ease-in-out infinite';
        }, 10);
    }, 3000);
}

// Parallax effect for hero section
window.addEventListener('scroll', () => {
    const scrolled = window.pageYOffset;
    const hero = document.querySelector('.hero');
    if (hero) {
        hero.style.backgroundPositionY = scrolled * 0.5 + 'px';
    }
});

// Counter animation for stats (if you add stats later)
function animateCounter(element, target, duration = 2000) {
    let start = 0;
    const increment = target / (duration / 16);
    const timer = setInterval(() => {
        start += increment;
        if (start >= target) {
            element.textContent = target;
            clearInterval(timer);
        } else {
            element.textContent = Math.floor(start);
        }
    }, 16);
}

// Enhanced scroll animations with stagger
const observerOptionsEnhanced = {
    threshold: 0.1,
    rootMargin: '0px 0px -100px 0px'
};

const observerEnhanced = new IntersectionObserver((entries) => {
    entries.forEach((entry, index) => {
        if (entry.isIntersecting) {
            setTimeout(() => {
                entry.target.style.opacity = '1';
                entry.target.style.transform = 'translateY(0) scale(1)';
                entry.target.classList.add('animated');
            }, index * 100);
        }
    });
}, observerOptionsEnhanced);

// Observe all animatable elements
document.addEventListener('DOMContentLoaded', () => {
    const allAnimateElements = document.querySelectorAll(`
        .skill-category, 
        .project-card, 
        .education-item, 
        .experience-section,
        .about-text,
        .contact-item,
        .detail-item
    `);
    
    allAnimateElements.forEach((el, index) => {
        el.style.opacity = '0';
        el.style.transform = 'translateY(30px) scale(0.95)';
        el.style.transition = 'opacity 0.8s ease, transform 0.8s ease';
        observerEnhanced.observe(el);
    });
});

// Skill tags hover animation
document.querySelectorAll('.skill-tag').forEach(tag => {
    tag.addEventListener('mouseenter', function() {
        this.style.transform = 'translateY(-5px) scale(1.1)';
    });
    tag.addEventListener('mouseleave', function() {
        this.style.transform = 'translateY(0) scale(1)';
    });
});

// Project cards tilt effect
document.querySelectorAll('.project-card').forEach(card => {
    card.addEventListener('mousemove', function(e) {
        const rect = this.getBoundingClientRect();
        const x = e.clientX - rect.left;
        const y = e.clientY - rect.top;
        
        const centerX = rect.width / 2;
        const centerY = rect.height / 2;
        
        const rotateX = (y - centerY) / 10;
        const rotateY = (centerX - x) / 10;
        
        this.style.transform = `perspective(1000px) rotateX(${rotateX}deg) rotateY(${rotateY}deg) translateY(-10px)`;
    });
    
    card.addEventListener('mouseleave', function() {
        this.style.transform = 'perspective(1000px) rotateX(0) rotateY(0) translateY(0)';
    });
});

// Smooth reveal animation for sections
const sectionObserver = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('section-visible');
        }
    });
}, { threshold: 0.2 });

document.querySelectorAll('section').forEach(section => {
    sectionObserver.observe(section);
});

// Loading animation
window.addEventListener('load', () => {
    document.body.classList.add('loaded');
    const loader = document.querySelector('.page-loader');
    if (loader) {
        loader.style.opacity = '0';
        setTimeout(() => {
            loader.style.display = 'none';
        }, 500);
    }
});

// Cursor trail effect (optional, can be disabled for performance)
let mouseX = 0, mouseY = 0;
let cursorTrail = [];

document.addEventListener('mousemove', (e) => {
    mouseX = e.clientX;
    mouseY = e.clientY;
    
    // Create subtle cursor trail
    if (Math.random() > 0.7) {
        const trail = document.createElement('div');
        trail.className = 'cursor-trail';
        trail.style.left = mouseX + 'px';
        trail.style.top = mouseY + 'px';
        document.body.appendChild(trail);
        
        setTimeout(() => {
            trail.style.opacity = '0';
            trail.style.transform = 'scale(0)';
            setTimeout(() => trail.remove(), 300);
        }, 100);
    }
});

