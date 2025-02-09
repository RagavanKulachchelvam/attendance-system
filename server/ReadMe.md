# Attendance System

A simple school attendance system with Spring Boot (Java) for the backend and HTML, JavaScript for the frontend.

## ✨ Features

- 🔑 User authentication with JWT
- 🔒 Secure login and logout functionality
- ➡️ Redirects based on authentication status
- 🌍 Simple UI with clean design

## 🚀 Getting Started

Follow these steps to set up and run the project:

### 1. Clone the Repository

`
git clone <YOUR_GITHUB_REPO_URL>
`

### 2. Install Prerequisites

- Java 17 or later
- Maven
- Spring Boot

### 3. Run the Server

`cd server`

`mvn spring-boot:run`

🔗 Server will start at: http://localhost:8081/

### 4. Open the \`client/\` folder and Run

Simply open `client/login.html` in your browser.

## 🔑 Login Credentials

For testing, use the following credentials:

| **Username** | **Password**   |
|--------------|----------------|
| username1        | password1    |
| username2         | password2        |

## 🛠️ Authentication Flow

- ✅ **Valid Login**: Redirects to `home.html`
- ❌ **Invalid Login**: Shows an error message

### 🔁 Auto Redirect:
- If not logged in → Redirects to `login.html`
- If already logged in → Redirects to `home.html`

### 🚪 Logout:
- Clears session and redirects to `login.html`
