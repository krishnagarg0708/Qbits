// Form validation for student registration and login forms
document.addEventListener('DOMContentLoaded', function () {
    // Student Registration Form Validation
    const studentForm = document.getElementById('studentForm');
    if (studentForm) {
        studentForm.onsubmit = function (event) {
            let username = document.getElementById('username').value;
            let password = document.getElementById('password').value;
            let email = document.getElementById('email').value;

            if (username.trim() === '' || password.trim() === '') {
                alert('Username and password cannot be empty.');
                event.preventDefault();
            }
        };
    }

    // Student Login Form Validation
    const loginForm = document.getElementById('loginForm');
    if (loginForm) {
        loginForm.onsubmit = function (event) {
            let username = document.getElementById('username').value;
            let password = document.getElementById('password').value;

            if (username.trim() === '' || password.trim() === '') {
                alert('Please enter both username and password.');
                event.preventDefault();
            }
        };
    }

    // Admin Login Form Validation
    const adminLoginForm = document.getElementById('adminLoginForm');
    if (adminLoginForm) {
        adminLoginForm.onsubmit = function (event) {
            let username = document.getElementById('username').value;
            let password = document.getElementById('password').value;

            if (username.trim() === '' || password.trim() === '') {
                alert('Please enter both username and password.');
                event.preventDefault();
            }
        };
    }

    // Adding interactivity for input focus and blur
    document.querySelectorAll('input').forEach(input => {
        input.addEventListener('focus', function () {
            this.style.backgroundColor = '#e6f7ff'; // Light blue on focus
        });
        input.addEventListener('blur', function () {
            this.style.backgroundColor = ''; // Remove background color when focus is lost
        });
    });

    // Adding tooltip functionality (optional)
    const tooltips = document.querySelectorAll('[data-bs-toggle="tooltip"]');
    tooltips.forEach(tooltip => {
        new bootstrap.Tooltip(tooltip);
    });
});
