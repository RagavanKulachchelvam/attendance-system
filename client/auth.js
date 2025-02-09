const API_URL = "http://localhost:8081/auth/authenticate";

// Function to login
async function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let response = await fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    });

    if (response.ok) {
        let token = await response.text();
        localStorage.setItem("token", token);
        window.location.href = "home.html";
    } else {
        document.getElementById("error-message").innerText = "Invalid username or password";
    }
}

// Function to check authentication
function checkAuth() {
    let token = localStorage.getItem("token");

    // Redirect to login if not logged in
    if (!token) {
        window.location.href = "login.html";
    }
}

// Function to check if the user is already logged in
function redirectIfLoggedIn() {
    let token = localStorage.getItem("token");

    // Redirect to home page if already logged in
    if (token) {
        window.location.href = "home.html";
    }
}

// Function to logout
function logout() {
    localStorage.removeItem("token");
    window.location.href = "login.html";
}
