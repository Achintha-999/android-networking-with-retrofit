# Android Networking with Retrofit

A full-stack Android application demonstrating RESTful API integration using Retrofit, JWT authentication, and a Java-based backend with Jersey, Hibernate, and MySQL.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Architecture](#architecture)
- [Requirements](#requirements)
- [Setup Instructions](#setup-instructions)
  - [Backend Setup](#backend-setup)
  - [Mobile App Setup](#mobile-app-setup)
- [How It Works](#how-it-works)
- [API Endpoints](#api-endpoints)
- [Testing with Postman](#testing-with-postman)
- [Troubleshooting](#troubleshooting)

## 🎯 Project Overview

This project demonstrates a complete Android application with a RESTful API backend. It includes:
- **Backend**: Java-based REST API using Jersey, embedded Tomcat, Hibernate ORM, and MySQL
- **Mobile**: Android app using Retrofit for networking, JWT token-based authentication, and RecyclerView for displaying data

## ✨ Features

- **User Authentication**: Login with JWT token generation (Access Token & Refresh Token)
- **Token Management**: Automatic token refresh using interceptors
- **Student List Display**: Fetch and display students in a RecyclerView
- **Search Functionality**: AutoComplete search for student names
- **Secure API Calls**: Token-based authentication for protected endpoints

## 🏗️ Architecture

### Backend Stack
- **Framework**: Jersey JAX-RS 3.1.10
- **Server**: Embedded Tomcat 11.0.12
- **ORM**: Hibernate 7.1.6
- **Database**: MySQL
- **Authentication**: JWT (JSON Web Tokens)
- **Build Tool**: Maven

### Mobile Stack
- **Language**: Java
- **Networking**: Retrofit 2 + Gson Converter
- **UI**: Material Design Components, RecyclerView
- **Min SDK**: 27 (Android 8.1)
- **Target SDK**: 36

## 📦 Requirements

### Backend Requirements

#### Software
- **Java JDK**: Version 17 or higher
- **Maven**: 3.6 or higher
- **MySQL**: 8.0 or higher
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code (recommended)

#### Dependencies (handled by Maven)
All dependencies are defined in `backend/pom.xml`:
- Jersey Framework 3.1.10
- Hibernate 7.1.6.Final
- MySQL Connector 9.3.0
- JWT Library (JJWT) 0.13.0
- Embedded Tomcat 11.0.12

### Mobile Requirements

#### Software
- **Android Studio**: Latest version (Hedgehog or newer recommended)
- **JDK**: Version 11 or higher
- **Android Device/Emulator**: Android 8.1 (API 27) or higher

#### Dependencies (handled by Gradle)
All dependencies are defined in `mobile/app/build.gradle`:
- Retrofit 2
- Gson Converter
- OkHttp Logging Interceptor
- Material Design Components
- RecyclerView

## 🚀 Setup Instructions

### Backend Setup

#### 1. Install MySQL

Download and install MySQL from [mysql.com](https://dev.mysql.com/downloads/mysql/)

#### 2. Create Database

Open MySQL and create a new database:

```sql
CREATE DATABASE network_practical;
```

#### 3. Configure MySQL Password

Navigate to `backend/src/main/resources/hibernate.cfg.xml` and update the password:

```xml
<property name="hibernate.connection.password">YOUR_MYSQL_PASSWORD</property>
```

**Important**: Replace `<YOUR PASSWORD>` with your actual MySQL root password.

Full configuration example:
```xml
<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/network_practical?allowPublicKeyRetrieval=true&amp;useSSL=false
</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">your_password_here</property>
```

#### 4. Build the Backend

Navigate to the backend directory and build with Maven:

```bash
cd backend
mvn clean install
```

#### 5. Run the Backend Server

Run the `Main.java` class:

```bash
mvn exec:java -Dexec.mainClass="lk.acx.np.Main"
```

Or run directly from your IDE.

The server will start on: `http://localhost:8080/api/v1`

#### 6. Seed the Database (Optional)

Hibernate will automatically create tables. To add test data, insert users and students manually:

```sql
USE network_practical;

-- Insert test user
INSERT INTO User (email, password) VALUES ('admin@gmail.com', 'admin123');

-- Insert test students
INSERT INTO Student (name, age, course) VALUES 
('John Doe', 20, 'Computer Science'),
('Jane Smith', 22, 'Software Engineering'),
('Mike Johnson', 21, 'Information Technology');
```

### Mobile App Setup

#### 1. Open Project in Android Studio

Open the `mobile` folder in Android Studio.

#### 2. Update Base URL (for Physical Device)

If testing on a **physical device**, update the base URL in `RetrofitClient.java`:

```java name=mobile/app/src/main/java/lk/acx/networkpractical/client/RetrofitClient.java url=https://github.com/Achintha-999/android-networking-with-retrofit/blob/9f74c607cb1db61b2142b4cd7e6fc57eaf4f7b64/mobile/app/src/main/java/lk/acx/networkpractical/client/RetrofitClient.java#L14-L16
public static final String BASE_URL = "http://10.0.2.2:8080/api/v1/";
/// emulators ==> http://10.0.2.2:8080/api/v1
/// physical device ==> Get your IP: cmd -> ipconfig -> IPv4 address => http://192.168.1.100:8080/api/v1
```

**Steps to find your IP:**
1. Open Command Prompt (Windows) or Terminal (Mac/Linux)
2. Run: `ipconfig` (Windows) or `ifconfig` (Mac/Linux)
3. Find your IPv4 Address (e.g., `192.168.1.100`)
4. Replace in code: `http://192.168.1.100:8080/api/v1/`

#### 3. Sync Gradle

Click **Sync Project with Gradle Files** in Android Studio.

#### 4. Run the App

- Select an emulator or connect a physical device
- Click **Run** ▶️
- Login with the credentials you added to the database

## 🔧 How It Works

### Authentication Flow

1. **User Login**: User enters email and password in `LoginActivity`
2. **API Call**: Retrofit sends POST request to `/auth/login`
3. **Token Generation**: Backend validates credentials and generates JWT tokens
4. **Token Storage**: Android app stores tokens in SharedPreferences via `TokenManager`
5. **Authenticated Requests**: `AuthInterceptor` automatically adds access token to all API requests
6. **Token Refresh**: If access token expires, app automatically refreshes using refresh token

### Data Flow

```
LoginActivity → AuthApi → Backend (/auth/login) → JWT Tokens
    ↓
TokenManager (SharedPreferences)
    ↓
StudentListActivity → StudentApi → Backend (/students/get-all) → Student List
    ↓
RecyclerView (UI Display)
```

### Key Components

#### Backend Components

- **`Main.java`**: Embedded Tomcat server initialization
- **`LoginController.java`**: Handles user authentication
- **`StudentController.java`**: Manages student data endpoints
- **`RefreshController.java`**: Handles token refresh
- **`UserService.java`**: Business logic for user validation
- **`JwtUtil.java`**: JWT token generation and validation
- **`HibernateUtil.java`**: Hibernate session factory management

#### Mobile Components

- **`RetrofitClient.java`**: Singleton Retrofit instance with OkHttp interceptor
- **`AuthInterceptor.java`**: Adds JWT token to API requests
- **`TokenManager.java`**: Manages token storage in SharedPreferences
- **`LoginActivity.java`**: User login UI and logic
- **`StudentListActivity.java`**: Displays student list with search
- **`StudentAdapter.java`**: RecyclerView adapter for students

## 📡 API Endpoints

### Base URL
```
http://localhost:8080/api/v1
```

### Authentication Endpoints

#### 1. User Login
```http
POST /auth/login
Content-Type: application/json

{
  "email": "admin@gmail.com",
  "password": "admin123"
}
```

**Response (200 OK):**
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiJ9...",
  "refreshToken": "eyJhbGciOiJIUzI1NiJ9..."
}
```

#### 2. Refresh Token
```http
POST /auth/refresh
Content-Type: application/json

{
  "refreshToken": "eyJhbGciOiJIUzI1NiJ9..."
}
```

**Response (200 OK):**
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiJ9...",
  "refreshToken": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### Student Endpoints

#### 3. Get All Students (Protected)
```http
GET /students/get-all
Authorization: Bearer <access_token>
Content-Type: application/json
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "age": 20,
    "course": "Computer Science"
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "age": 22,
    "course": "Software Engineering"
  }
]
```

### Test Endpoints

#### 4. Generate Test Token
```http
GET /test
```

**Response:**
```json
"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJpYXQiOjE3MDgwMDAwMDAsImV4cCI6MTcwODAwMzYwMH0..."
```

#### 5. Get Students (Test - No Auth)
```http
GET /test/students
```

## 🧪 Testing with Postman

### 1. Install Postman

Download from [postman.com](https://www.postman.com/downloads/)

### 2. Test Login Endpoint

**Step-by-step:**

1. Create a new request
2. Set method to **POST**
3. Enter URL: `http://localhost:8080/api/v1/auth/login`
4. Go to **Headers** tab:
   - Key: `Content-Type`
   - Value: `application/json`
5. Go to **Body** tab:
   - Select **raw** and **JSON**
   - Enter:
   ```json
   {
     "email": "admin@gmail.com",
     "password": "admin123"
   }
   ```
6. Click **Send**
7. Copy the `accessToken` from the response

### 3. Generate a Token

You can also use the test endpoint to quickly generate a token:

1. Create a new **GET** request
2. URL: `http://localhost:8080/api/v1/test`
3. Click **Send**
4. Copy the token from the response body

### 4. Test Protected Endpoint (Get Students)

1. Create a new **GET** request
2. URL: `http://localhost:8080/api/v1/students/get-all`
3. Go to **Headers** tab:
   - Key: `Authorization`
   - Value: `Bearer YOUR_ACCESS_TOKEN_HERE`
   - Key: `Content-Type`
   - Value: `application/json`
4. Click **Send**
5. You should see the list of students

### 5. Test Token Refresh

1. Create a new **POST** request
2. URL: `http://localhost:8080/api/v1/auth/refresh`
3. Go to **Headers** tab:
   - Key: `Content-Type`
   - Value: `application/json`
4. Go to **Body** tab:
   - Select **raw** and **JSON**
   - Enter:
   ```json
   {
     "refreshToken": "YOUR_REFRESH_TOKEN_HERE"
   }
   ```
5. Click **Send**
6. You'll receive a new access token

### 6. Save as Postman Collection

To save time:
1. Click **Save** on each request
2. Create a new collection: "Android Networking API"
3. Use **Environment Variables** for the base URL and tokens

**Example Environment:**
- `base_url`: `http://localhost:8080/api/v1`
- `access_token`: (paste after login)
- `refresh_token`: (paste after login)

Then use: `{{base_url}}/students/get-all` and `Bearer {{access_token}}`

## 🐛 Troubleshooting

### Backend Issues

#### Database Connection Error
```
Error: Unable to create requested service
```
**Solution:** Check MySQL is running and credentials in `hibernate.cfg.xml` are correct.

#### Port Already in Use
```
Error: Address already in use: bind
```
**Solution:** Stop any process using port 8080 or change the port in `Main.java`:
```java
private static final int SERVER_PORT = 8081; // Change port
```

#### JWT Dependency Error
**Solution:** Ensure both JWT dependencies are in `pom.xml`:
```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.13.0</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.13.0</version>
</dependency>
```

### Mobile App Issues

#### Cannot Connect to Backend (Emulator)
**Solution:** Use `http://10.0.2.2:8080/api/v1/` for emulators, not `localhost`.

#### Cannot Connect to Backend (Physical Device)
**Solution:** 
1. Ensure phone and computer are on the same WiFi
2. Use your computer's IP address: `http://192.168.1.XXX:8080/api/v1/`
3. Disable Windows Firewall temporarily or add exception for port 8080

#### Login Fails with 400 Bad Request
**Solution:** Check that user exists in database with correct credentials.

#### Token Expired Error
**Solution:** The app should automatically refresh. If not, clear app data and login again.

#### Gradle Sync Issues
**Solution:** 
1. File → Invalidate Caches → Restart
2. Clean Project: Build → Clean Project
3. Rebuild Project: Build → Rebuild Project

## 📱 Screenshots & Demo

After setup, you should be able to:
1. ✅ Login with your credentials
2. ✅ View the student list in a RecyclerView
3. ✅ Search for students using the AutoComplete field
4. ✅ See authenticated API calls with JWT tokens

## 📝 License

This project is created for educational purposes.

## 👨‍💻 Author

**Achintha-999**

---

**Happy Coding! 🚀**

If you have any questions or issues, please create an issue in the GitHub repository.
