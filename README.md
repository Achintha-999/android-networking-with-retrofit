# 🚀 Android Networking with Retrofit

<div align="center">

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Retrofit](https://img.shields.io/badge/Retrofit-48B983?style=for-the-badge&logo=square&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)

### 📱 A Full-Stack Android Application with RESTful API Integration

*Demonstrating JWT Authentication, Retrofit Networking, and Modern Android Architecture*

[Features](#-features) • [Architecture](#-architecture) • [Setup](#-setup-instructions) • [API Docs](#-api-endpoints) • [Testing](#-testing-with-postman)

</div>

---

## 📖 Table of Contents

- [🎯 Project Overview](#-project-overview)
- [✨ Features](#-features)
- [🏗️ Architecture](#️-architecture)
- [📦 Requirements](#-requirements)
- [🚀 Setup Instructions](#-setup-instructions)
  - [⚙️ Backend Setup](#️-backend-setup)
  - [📱 Mobile App Setup](#-mobile-app-setup)
- [🔧 How It Works](#-how-it-works)
- [📡 API Endpoints](#-api-endpoints)
- [🧪 Testing with Postman](#-testing-with-postman)
- [🐛 Troubleshooting](#-troubleshooting)
- [📸 Screenshots](#-screenshots)
- [📄 License](#-license)

---

## 🎯 Project Overview

This project demonstrates a complete **full-stack Android application** with a RESTful API backend, showcasing modern development practices and industry-standard technologies.

### 🎨 What's Inside?

| Component | Technology |
|-----------|-----------|
| **Backend** 🖥️ | Java REST API with Jersey, Embedded Tomcat, Hibernate ORM & MySQL |
| **Mobile** 📱 | Android app using Retrofit, JWT Authentication & Material Design |
| **Security** 🔐 | Token-based authentication with JWT (Access + Refresh tokens) |
| **Architecture** 🏛️ | Clean separation with MVC pattern and Repository layer |

---

## ✨ Features

<table>
<tr>
<td width="50%">

### 🔐 Authentication & Security
- ✅ JWT Token-based authentication
- ✅ Access Token + Refresh Token system
- ✅ Automatic token refresh mechanism
- ✅ Secure credential storage
- ✅ Protected API endpoints

</td>
<td width="50%">

### 📊 Data Management
- ✅ RESTful API architecture
- ✅ Hibernate ORM integration
- ✅ MySQL database persistence
- ✅ Real-time data synchronization
- ✅ CRUD operations support

</td>
</tr>
<tr>
<td width="50%">

### 📱 Mobile Features
- ✅ Modern Material Design UI
- ✅ RecyclerView with adapters
- ✅ AutoComplete search functionality
- ✅ Retrofit networking library
- ✅ OkHttp interceptors

</td>
<td width="50%">

### 🛠️ Developer Experience
- ✅ Clean code architecture
- ✅ Easy setup and configuration
- ✅ Comprehensive error handling
- ✅ Postman-ready API
- ✅ Well-documented codebase

</td>
</tr>
</table>

---

## 🏗️ Architecture

### 🎯 System Architecture Diagram

```
┌─────────────────────────────────────────────────────────────┐
│                     📱 MOBILE APP LAYER                      │
├─────────────────────────────────────────────────────────────┤
│  LoginActivity  │  StudentListActivity  │  UI Components    │
│       ↕️                    ↕️                    ↕️          │
│  RetrofitClient │  AuthApi │ StudentApi │ Interceptors     │
└─────────────────────���──┬────────────────────────────────────┘
                         │ 🌐 HTTP/REST API
                         ↕️
┌────────────────────────┴────────────────────────────────────┐
│                    🖥️ BACKEND API LAYER                      │
├─────────────────────────────────────────────────────────────┤
│  Controllers: Login │ Student │ Refresh │ Test             │
│       ↕️                    ↕️                                │
│  Services: UserService │ JWT Utils │ Token Management       │
│       ↕️                    ↕️                                │
│  Entities: User │ Student  (Hibernate ORM)                  │
└────────────────────────┬────────────────────────────────────┘
                         ↕️
                    ┌────────────┐
                    │ 🗄️ MySQL DB │
                    └────────────┘
```

### 💻 Backend Technology Stack

<div align="center">

| Technology | Version | Purpose |
|:----------:|:-------:|:-------:|
| ☕ **Java** | 17 | Programming Language |
| 🎯 **Jersey** | 3.1.10 | JAX-RS REST Framework |
| 🐱 **Tomcat** | 11.0.12 | Embedded Web Server |
| 🗃️ **Hibernate** | 7.1.6 | Object-Relational Mapping |
| 🐬 **MySQL** | 8.0+ | Relational Database |
| 🔑 **JJWT** | 0.13.0 | JWT Token Management |
| 📦 **Maven** | 3.6+ | Build & Dependency Tool |

</div>

### 📱 Mobile Technology Stack

<div align="center">

| Technology | Version | Purpose |
|:----------:|:-------:|:-------:|
| 🤖 **Android** | API 27+ | Mobile Platform |
| ☕ **Java** | 11 | Programming Language |
| 🌐 **Retrofit** | 2.x | HTTP Client |
| 📝 **Gson** | 2.x | JSON Serialization |
| 🔌 **OkHttp** | 4.x | HTTP Interceptor |
| 🎨 **Material** | Latest | UI Components |
| 📋 **RecyclerView** | Latest | List Display |

</div>

---

## 📦 Requirements

### 🖥️ Backend Requirements

#### 💿 Software Prerequisites

| Software | Version | Download Link | Purpose |
|----------|---------|---------------|---------|
| ☕ **Java JDK** | 17+ | [Download](https://www.oracle.com/java/technologies/downloads/) | Runtime Environment |
| 📦 **Maven** | 3.6+ | [Download](https://maven.apache.org/download.cgi) | Build Tool |
| 🐬 **MySQL** | 8.0+ | [Download](https://dev.mysql.com/downloads/mysql/) | Database Server |
| 💻 **IDE** | Latest | [IntelliJ](https://www.jetbrains.com/idea/) / [Eclipse](https://www.eclipse.org/) | Development Environment |

#### 📚 Backend Dependencies

> 🔄 All dependencies are automatically managed by Maven via `pom.xml`

<details>
<summary>📋 Click to view all dependencies</summary>

- ✅ Jersey Framework 3.1.10
- ✅ Jersey Jackson (JSON Converter) 3.1.10
- ✅ Jersey HK2 3.1.10
- ✅ Tomcat Embed Core 11.0.12
- ✅ Tomcat Embed Jasper 11.0.12
- ✅ Hibernate Core 7.1.6.Final
- ✅ MySQL Connector 9.3.0
- ✅ JJWT 0.13.0
- ✅ JJWT Jackson 0.13.0

</details>

### 📱 Mobile Requirements

#### 💿 Software Prerequisites

| Software | Version | Download Link | Purpose |
|----------|---------|---------------|---------|
| 🤖 **Android Studio** | Latest | [Download](https://developer.android.com/studio) | IDE |
| ☕ **JDK** | 11+ | [Download](https://www.oracle.com/java/technologies/downloads/) | Runtime |
| 📱 **Android Device/Emulator** | API 27+ | Built-in | Testing Platform |

#### 📚 Mobile Dependencies

> 🔄 All dependencies are automatically managed by Gradle via `build.gradle`

<details>
<summary>📋 Click to view all dependencies</summary>

- ✅ Retrofit 2
- ✅ Gson Converter
- ✅ OkHttp Logging Interceptor
- ✅ AndroidX AppCompat
- ✅ Material Design Components
- ✅ ConstraintLayout
- ✅ RecyclerView
- ✅ JUnit (Testing)
- ✅ Espresso (UI Testing)

</details>

---

## 🚀 Setup Instructions

### ⚙️ Backend Setup

#### 📝 Step 1: Install MySQL Database

1. **Download MySQL** from the [official website](https://dev.mysql.com/downloads/mysql/)
2. **Install** following the setup wizard
3. **Remember** your root password (you'll need it later!)

#### 📝 Step 2: Create Database

Open **MySQL Workbench** or **MySQL Command Line** and execute:

```sql
-- Create the database
CREATE DATABASE network_practical;

-- Verify creation
SHOW DATABASES;
```

#### 📝 Step 3: Configure Database Connection

Navigate to the Hibernate configuration file:

📁 **Path**: `backend/src/main/resources/hibernate.cfg.xml`

```xml
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
    "-//Hibernate/Hibernate Configuration DTD//EN"
    "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
  <session-factory>
      <!-- 🔧 MySQL Driver Configuration -->
      <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
      <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
    
      <!-- 🌐 Database Connection URL -->
      <property name="hibernate.connection.url">
          jdbc:mysql://localhost:3306/network_practical?allowPublicKeyRetrieval=true&amp;useSSL=false
      </property>
    
      <!-- 👤 Database Credentials -->
      <property name="hibernate.connection.username">root</property>
      
      <!-- ⚠️ IMPORTANT: Replace with YOUR MySQL password -->
      <property name="hibernate.connection.password">YOUR_MYSQL_PASSWORD_HERE</property>
      
      <!-- 🔄 Auto-create/update tables -->
      <property name="hibernate.hbm2ddl.auto">update</property>
      
      <!-- 📝 Show SQL queries in console -->
      <property name="hibernate.show_sql">true</property>

      <!-- 📋 Entity Mappings -->
      <mapping class="lk.acx.np.entity.User"/>
      <mapping class="lk.acx.np.entity.Student"/>
  </session-factory>
</hibernate-configuration>
```

> ⚠️ **CRITICAL**: Replace `YOUR_MYSQL_PASSWORD_HERE` with your actual MySQL root password!

#### 📝 Step 4: Build the Backend

Open terminal in the **backend** directory:

```bash
# Navigate to backend folder
cd backend

# Clean and build with Maven
mvn clean install

# 🎉 You should see "BUILD SUCCESS"
```

#### 📝 Step 5: Run the Backend Server

**Option A - Using Maven:**
```bash
mvn exec:java -Dexec.mainClass="lk.acx.np.Main"
```

**Option B - Using IDE:**
1. Open `backend/src/main/java/lk/acx/np/Main.java`
2. Right-click → **Run 'Main.main()'**

**✅ Success Output:**
```
API URL: http://localhost:8080/api/v1
```

#### 📝 Step 6: Seed the Database (Optional but Recommended)

Hibernate will auto-create tables. Add test data:

```sql
USE network_practical;

-- 👤 Insert a test user for login
INSERT INTO User (email, password) VALUES 
('admin@gmail.com', 'admin123'),
('test@test.com', 'test123');

-- 👨‍🎓 Insert sample students
INSERT INTO Student (name, age, course) VALUES 
('John Doe', 20, 'Computer Science'),
('Jane Smith', 22, 'Software Engineering'),
('Mike Johnson', 21, 'Information Technology'),
('Sarah Williams', 23, 'Data Science'),
('David Brown', 20, 'Cybersecurity');

-- ✅ Verify data
SELECT * FROM User;
SELECT * FROM Student;
```

---

### 📱 Mobile App Setup

#### 📝 Step 1: Open Project in Android Studio

1. **Launch** Android Studio
2. **Select** "Open an Existing Project"
3. **Navigate** to the `mobile` folder
4. **Click** "OK" and wait for Gradle sync

#### 📝 Step 2: Configure Base URL

Open the Retrofit client configuration:

📁 **Path**: `mobile/app/src/main/java/lk/acx/networkpractical/client/RetrofitClient.java`

```java
public class RetrofitClient {
    private static Retrofit retrofit;

    // 🌐 CONFIGURE YOUR BASE URL HERE
    public static final String BASE_URL = "http://10.0.2.2:8080/api/v1/";
    
    // 📱 For Android Emulator: http://10.0.2.2:8080/api/v1/
    // 📱 For Physical Device: http://YOUR_IP:8080/api/v1/
    
    // ... rest of the code
}
```

#### 🔍 Finding Your IP Address

**For Physical Devices:**

<table>
<tr>
<td width="50%">

**Windows** 💻
```bash
# Open Command Prompt
cmd

# Run this command
ipconfig

# Look for "IPv4 Address"
# Example: 192.168.1.100
```

</td>
<td width="50%">

**Mac/Linux** 🍎
```bash
# Open Terminal
terminal

# Run this command
ifconfig

# Look for "inet"
# Example: 192.168.1.100
```

</td>
</tr>
</table>

**Then update the BASE_URL:**
```java
public static final String BASE_URL = "http://192.168.1.100:8080/api/v1/";
```

> 📌 **Important**: Ensure your phone and computer are on the **same WiFi network**!

#### 📝 Step 3: Sync Gradle Dependencies

1. **Click** the Gradle sync icon (🐘) or
2. **File** → **Sync Project with Gradle Files**
3. **Wait** for dependencies to download

#### 📝 Step 4: Run the Application

**For Emulator:**
1. **Select** an emulator from the device dropdown
2. **Click** the Run button ▶️
3. **Wait** for the app to launch

**For Physical Device:**
1. **Enable** Developer Options on your phone
2. **Enable** USB Debugging
3. **Connect** phone via USB
4. **Select** your device from dropdown
5. **Click** Run ▶️

#### 📝 Step 5: Login and Test

1. **Open** the app
2. **Enter** credentials:
   - **Email**: `admin@gmail.com`
   - **Password**: `admin123`
3. **Click** Login
4. **View** the student list! 🎉

---

## 🔧 How It Works

### 🔐 Authentication Flow

```mermaid
sequenceDiagram
    participant U as 📱 User
    participant LA as LoginActivity
    participant RC as RetrofitClient
    participant API as 🖥️ Backend API
    participant DB as 🗄️ Database
    participant TM as TokenManager

    U->>LA: Enter credentials
    LA->>RC: POST /auth/login
    RC->>API: {email, password}
    API->>DB: Validate credentials
    DB-->>API: User found ✅
    API-->>RC: {accessToken, refreshToken}
    RC-->>LA: Tokens received
    LA->>TM: Save tokens to SharedPreferences
    TM-->>LA: Saved ✅
    LA->>U: Navigate to StudentListActivity 🎉
```

#### 🔄 Detailed Authentication Steps

| Step | Component | Action | Result |
|:----:|-----------|--------|--------|
| 1️⃣ | **User** | Enters email & password | Input validation |
| 2️⃣ | **LoginActivity** | Calls `authApi.userLogin()` | API request created |
| 3️⃣ | **Retrofit** | Sends POST to `/auth/login` | HTTP request |
| 4️⃣ | **Backend** | Validates credentials in DB | User verification |
| 5️⃣ | **JwtUtil** | Generates access + refresh tokens | JWT creation |
| 6️⃣ | **Backend** | Returns token response | JSON response |
| 7️⃣ | **TokenManager** | Saves tokens to SharedPreferences | Secure storage |
| 8️⃣ | **App** | Navigates to Student List | Success! 🎉 |

### 🔄 Token Refresh Mechanism

```mermaid
sequenceDiagram
    participant App as 📱 App
    participant AI as AuthInterceptor
    participant API as 🖥️ API
    participant TM as TokenManager

    App->>AI: Make API request
    AI->>API: Request with expired token ⏱️
    API-->>AI: 401 Unauthorized ❌
    AI->>TM: Get refresh token
    TM-->>AI: Refresh token
    AI->>API: POST /auth/refresh
    API-->>AI: New access token ✅
    AI->>TM: Save new token
    AI->>API: Retry original request
    API-->>App: Success! 🎉
```

### 📊 Data Flow Architecture

```
┌─────────────────────────────────────────────────────────┐
│                    📱 PRESENTATION LAYER                 │
│  ┌───────────────┐         ┌──────────────────┐        │
│  │ LoginActivity │         │ StudentListActivity│        │
│  └───────┬───────┘         └────────┬─────────┘        │
│          │                          │                   │
└──────────┼────────────────��─────────┼───────────────────┘
           │                          │
           ↕️                          ↕️
┌──────────┼──────────────────────────┼───────────────────┐
│          │     🌐 NETWORK LAYER     │                   │
│  ┌───────┴────────┐         ┌──────┴──────┐           │
│  │   AuthApi      │         │ StudentApi  │           │
│  └───────┬────────┘         └──────┬──────┘           │
│          └────────┬─────────────────┘                  │
│                   ↕️                                    │
│          ┌────────────────────┐                        │
│          │  RetrofitClient    │                        │
│          │  + AuthInterceptor │                        │
│          └────────┬───────────┘                        │
└───────────────────┼────────────────────────────────────┘
                    │ 🔐 JWT Token
                    ↕️
┌───────────────────┼────────────────────────────────────┐
│                   │    🖥️ BACKEND LAYER                 │
│       ┌───────────┴──────────┐                         │
│       │   JAX-RS Controllers │                         │
│       └───────────┬──────────┘                         │
│                   ↕️                                    │
│       ┌───────────┴──────────┐                         │
│       │  Business Services   │                         │
│       └───────────┬──────────┘                         │
│                   ↕️                                    │
│       ┌───────────┴──────────┐                         │
│       │   Hibernate ORM      │                         │
│       └───────────┬──────────┘                         │
└───────────────────┼────────────────────────────────────┘
                    ↕️
            ┌───────────────┐
            │ 🗄️ MySQL DB    │
            └───────────────┘
```

### 🔑 Key Components Explained

#### 🖥️ Backend Components

| Component | File | Purpose |
|-----------|------|---------|
| 🎯 **Server** | `Main.java` | Initializes Tomcat server on port 8080 |
| 🔐 **Auth Controller** | `LoginController.java` | Handles user login requests |
| 👨‍🎓 **Student Controller** | `StudentController.java` | Manages student data endpoints |
| 🔄 **Refresh Controller** | `RefreshController.java` | Issues new access tokens |
| 💼 **User Service** | `UserService.java` | Business logic for authentication |
| 🔑 **JWT Utility** | `JwtUtil.java` | Token generation & validation |
| 🗄️ **Hibernate Utility** | `HibernateUtil.java` | Database session management |
| 👤 **User Entity** | `User.java` | User data model |
| 📚 **Student Entity** | `Student.java` | Student data model |

#### 📱 Mobile Components

| Component | File | Purpose |
|-----------|------|---------|
| 🌐 **Retrofit Client** | `RetrofitClient.java` | Singleton HTTP client with interceptor |
| 🔐 **Auth Interceptor** | `AuthInterceptor.java` | Adds JWT to all requests |
| 💾 **Token Manager** | `TokenManager.java` | SharedPreferences token storage |
| 🔑 **Login Activity** | `LoginActivity.java` | User authentication UI |
| 📋 **Student List Activity** | `StudentListActivity.java` | Displays students with search |
| 🎨 **Student Adapter** | `StudentAdapter.java` | RecyclerView data binding |
| 🌐 **Auth API** | `AuthApi.java` | Authentication endpoint interface |
| 📚 **Student API** | `StudentApi.java` | Student endpoint interface |
| 📦 **DTOs** | `*.java` | Data transfer objects |

---

## 📡 API Endpoints

### 🌐 Base URL

```
http://localhost:8080/api/v1
```

---

### 🔐 Authentication Endpoints

#### 1️⃣ User Login

**Authenticate user and receive JWT tokens**

```http
POST /auth/login
Content-Type: application/json
```

**📤 Request Body:**
```json
{
  "email": "admin@gmail.com",
  "password": "admin123"
}
```

**📥 Response (200 OK):**
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJpYXQiOjE3MDgwMDAwMDAsImV4cCI6MTcwODAwMDMwMH0.abc123...",
  "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE3MDgwODY0MDB9.def456..."
}
```

**❌ Error Response (400 Bad Request):**
```json
{
  "error": "Invalid credentials"
}
```

| Status Code | Description |
|------------|-------------|
| 🟢 200 | Login successful, tokens returned |
| 🔴 400 | Invalid email or password |
| 🔴 500 | Server error |

---

#### 2️⃣ Refresh Access Token

**Get a new access token using refresh token**

```http
POST /auth/refresh
Content-Type: application/json
```

**📤 Request Body:**
```json
{
  "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE3MDgwODY0MDB9.def456..."
}
```

**📥 Response (200 OK):**
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiJ9.NEW_TOKEN_HERE...",
  "refreshToken": "eyJhbGciOiJIUzI1NiJ9.SAME_REFRESH_TOKEN..."
}
```

| Status Code | Description |
|------------|-------------|
| 🟢 200 | New access token issued |
| 🔴 401 | Invalid or expired refresh token |
| 🔴 500 | Server error |

---

### 👨‍🎓 Student Endpoints

#### 3️⃣ Get All Students (Protected 🔒)

**Retrieve list of all students (requires authentication)**

```http
GET /students/get-all
Authorization: Bearer <access_token>
Content-Type: application/json
```

**📥 Response (200 OK):**
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
  },
  {
    "id": 3,
    "name": "Mike Johnson",
    "age": 21,
    "course": "Information Technology"
  }
]
```

| Status Code | Description |
|------------|-------------|
| 🟢 200 | Students retrieved successfully |
| 🔴 401 | Missing or invalid token |
| 🔴 500 | Server error |

---

### 🧪 Test Endpoints

#### 4️⃣ Generate Test Token

**Quickly generate a JWT token for testing**

```http
GET /test
```

**📥 Response (200 OK):**
```json
"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJpYXQiOjE3MDgwMDAwMDAsImV4cCI6MTcwODAwMzYwMH0.test_token_here..."
```

---

#### 5️⃣ Get Students (No Auth - Test Only)

**Test endpoint to fetch students without authentication**

```http
GET /test/students
```

**📥 Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "age": 20,
    "course": "Computer Science"
  }
]
```

> ⚠️ **Note**: This is a test endpoint. Use `/students/get-all` for production with proper authentication.

---

### 📊 JWT Token Information

#### Access Token
- ⏱️ **Expiration**: 5 minutes
- 🎯 **Purpose**: Access protected endpoints
- 🔑 **Location**: `Authorization: Bearer <token>`

#### Refresh Token
- ⏱️ **Expiration**: 24 hours
- 🎯 **Purpose**: Obtain new access tokens
- 🔄 **Usage**: Call `/auth/refresh` when access token expires

---

## 🧪 Testing with Postman

### 📥 Step 1: Install Postman

Download and install from [**postman.com**](https://www.postman.com/downloads/)

---

### 🔐 Step 2: Test Login Endpoint

#### 📋 Detailed Instructions:

1. **Create a new request**
   - Click **"New"** → **"HTTP Request"**

2. **Configure the request:**
   ```
   Method: POST
   URL: http://localhost:8080/api/v1/auth/login
   ```

3. **Set Headers:**
   
   | Key | Value |
   |-----|-------|
   | `Content-Type` | `application/json` |

4. **Set Body:**
   - Select **"raw"** and **"JSON"**
   ```json
   {
     "email": "admin@gmail.com",
     "password": "admin123"
   }
   ```

5. **Click Send** 🚀

6. **Copy the tokens from response:**
   ```json
   {
     "accessToken": "COPY_THIS_TOKEN",
     "refreshToken": "COPY_THIS_TOKEN"
   }
   ```

---

### 🎯 Step 3: Generate a Quick Test Token

**For rapid testing without login:**

```
Method: GET
URL: http://localhost:8080/api/v1/test
```

**Click Send** → **Copy the token from response**

---

### 👨‍🎓 Step 4: Test Protected Endpoint (Get Students)

#### 📋 Step-by-step:

1. **Create a new request**
   ```
   Method: GET
   URL: http://localhost:8080/api/v1/students/get-all
   ```

2. **Add Headers:**
   
   | Key | Value |
   |-----|-------|
   | `Authorization` | `Bearer YOUR_ACCESS_TOKEN_HERE` |
   | `Content-Type` | `application/json` |

3. **Click Send** 🚀

4. **You should see the student list!** 📋

**Example Response:**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "age": 20,
    "course": "Computer Science"
  }
]
```

---

### 🔄 Step 5: Test Token Refresh

1. **Create a new request**
   ```
   Method: POST
   URL: http://localhost:8080/api/v1/auth/refresh
   ```

2. **Set Headers:**
   
   | Key | Value |
   |-----|-------|
   | `Content-Type` | `application/json` |

3. **Set Body (raw JSON):**
   ```json
   {
     "refreshToken": "YOUR_REFRESH_TOKEN_HERE"
   }
   ```

4. **Click Send** 🚀

5. **Receive new access token** ✅

---

### 💾 Step 6: Save as Postman Collection

#### 🎯 Create a reusable collection:

1. **Click "Save"** on each request
2. **Create new collection**: `"Android Networking API"`
3. **Use Environment Variables**:

   | Variable | Initial Value | Current Value |
   |----------|---------------|---------------|
   | `base_url` | `http://localhost:8080/api/v1` | Same |
   | `access_token` | (empty) | Paste after login |
   | `refresh_token` | (empty) | Paste after login |

4. **Update requests to use variables:**
   ```
   URL: {{base_url}}/students/get-all
   Authorization: Bearer {{access_token}}
   ```

---

### 📚 Complete Postman Collection Structure

```
📁 Android Networking API
├── 🔐 Authentication
│   ├── Login (POST)
│   └── Refresh Token (POST)
├── 👨‍🎓 Students
│   └── Get All Students (GET)
└── 🧪 Testing
    ├── Generate Test Token (GET)
    └── Get Students (No Auth) (GET)
```

---

### 🎬 Quick Testing Workflow

1. **🔐 Login** → Copy `accessToken`
2. **🔄 Set Environment Variable** → Paste token
3. **👨‍🎓 Get Students** → Use `{{access_token}}`
4. **✅ Success!**

---

## 🐛 Troubleshooting

### 🖥️ Backend Issues

#### ❌ Database Connection Error

**Error Message:**
```
Error: Unable to create requested service
SQLException: Access denied for user 'root'@'localhost'
```

**✅ Solutions:**

1. **Check MySQL is running:**
   ```bash
   # Windows
   services.msc → Look for "MySQL80"
   
   # Mac
   brew services list | grep mysql
   
   # Linux
   systemctl status mysql
   ```

2. **Verify credentials in `hibernate.cfg.xml`:**
   ```xml
   <property name="hibernate.connection.username">root</property>
   <property name="hibernate.connection.password">YOUR_ACTUAL_PASSWORD</property>
   ```

3. **Test MySQL connection:**
   ```bash
   mysql -u root -p
   # Enter your password
   SHOW DATABASES;
   ```

4. **Check database exists:**
   ```sql
   CREATE DATABASE IF NOT EXISTS network_practical;
   USE network_practical;
   ```

---

#### ❌ Port Already in Use

**Error Message:**
```
Error: Address already in use: bind
java.net.BindException: Address already in use: bind
```

**✅ Solutions:**

**Option A - Kill the process:**
```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID_NUMBER> /F

# Mac/Linux
lsof -i :8080
kill -9 <PID>
```

**Option B - Change port:**

Edit `Main.java`:
```java
private static final int SERVER_PORT = 8081; // Change to 8081
```

Don't forget to update mobile app BASE_URL!

---

#### ❌ JWT/Dependencies Not Found

**Error Message:**
```
ClassNotFoundException: io.jsonwebtoken.Jwts
```

**✅ Solutions:**

1. **Verify both JWT dependencies in `pom.xml`:**
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

2. **Rebuild Maven:**
   ```bash
   mvn clean install -U
   ```

3. **Reload Maven in IDE:**
   - IntelliJ: Right-click `pom.xml` → **Maven** → **Reload Project**
   - Eclipse: Right-click project → **Maven** → **Update Project**

---

#### ❌ Hibernate/SQL Errors

**Error Message:**
```
Table 'network_practical.user' doesn't exist
```

**✅ Solutions:**

1. **Check Hibernate auto-create is enabled:**
   ```xml
   <property name="hibernate.hbm2ddl.auto">update</property>
   ```

2. **Manually create tables:**
   ```sql
   USE network_practical;
   
   CREATE TABLE User (
       id INT AUTO_INCREMENT PRIMARY KEY,
       email VARCHAR(150) UNIQUE NOT NULL,
       password VARCHAR(15) NOT NULL
   );
   
   CREATE TABLE Student (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(150),
       age INT,
       course VARCHAR(255)
   );
   ```

---

### 📱 Mobile App Issues

#### ❌ Cannot Connect to Backend (Emulator)

**Error Message:**
```
java.net.ConnectException: Failed to connect to localhost/127.0.0.1:8080
```

**✅ Solution:**

❌ **DON'T USE:** `http://localhost:8080/api/v1/`  
✅ **USE:** `http://10.0.2.2:8080/api/v1/`

**In `RetrofitClient.java`:**
```java
public static final String BASE_URL = "http://10.0.2.2:8080/api/v1/";
```

> 📌 `10.0.2.2` is the special IP that emulators use to reach host machine's localhost

---

#### ❌ Cannot Connect to Backend (Physical Device)

**Error Message:**
```
java.net.ConnectException: Failed to connect to 10.0.2.2:8080
```

**✅ Solutions:**

1. **Find your computer's IP:**
   ```bash
   # Windows
   ipconfig
   # Look for "IPv4 Address": 192.168.1.XXX
   
   # Mac
   ifconfig | grep "inet "
   
   # Linux
   ip addr show
   ```

2. **Update BASE_URL:**
   ```java
   public static final String BASE_URL = "http://192.168.1.100:8080/api/v1/";
   ```

3. **Ensure same WiFi network:**
   - Phone and computer must be on **same network**
   - Check WiFi name matches on both devices

4. **Disable firewall temporarily:**
   ```
   Windows: Control Panel → Firewall → Turn off (temporarily)
   Mac: System Preferences → Security → Firewall → Off (temporarily)
   ```

5. **Add firewall exception (better solution):**
   - Allow Java/Tomcat through firewall on port 8080

---

#### ❌ Login Fails with 400 Bad Request

**Error:** User credentials rejected

**✅ Solutions:**

1. **Verify user exists in database:**
   ```sql
   USE network_practical;
   SELECT * FROM User WHERE email = 'admin@gmail.com';
   ```

2. **Insert user if missing:**
   ```sql
   INSERT INTO User (email, password) VALUES ('admin@gmail.com', 'admin123');
   ```

3. **Check exact credentials in app match database**

4. **Enable SQL logging to see query:**
   ```xml
   <property name="hibernate.show_sql">true</property>
   ```

---

#### ❌ Token Expired Error (401 Unauthorized)

**Error Message:**
```
HTTP 401: Token expired or invalid
```

**✅ Solutions:**

1. **App should auto-refresh** - check `AuthInterceptor.java` is working

2. **Manual fix - Clear app data:**
   - Settings → Apps → Your App → Storage → **Clear Data**
   - Re-login

3. **Check token expiration in backend:**
   ```java
   // In JwtUtil.java
   .expiration(new Date(System.currentTimeMillis() + 5 * 60 * 1000)) // 5 minutes
   ```

---

#### ❌ Gradle Sync Failed

**Error Message:**
```
Gradle sync failed: Could not resolve all dependencies
```

**✅ Solutions:**

1. **Invalidate caches:**
   ```
   File → Invalidate Caches → Invalidate and Restart
   ```

2. **Clean project:**
   ```
   Build → Clean Project
   Build → Rebuild Project
   ```

3. **Update Gradle wrapper:**
   ```bash
   ./gradlew wrapper --gradle-version 8.2
   ```

4. **Check internet connection** - Gradle downloads dependencies

5. **Update `gradle-wrapper.properties`:**
   ```properties
   distributionUrl=https\://services.gradle.org/distributions/gradle-8.2-bin.zip
   ```

---

#### ❌ App Crashes on Launch

**Check Logcat for errors:**

1. **Open Logcat** in Android Studio
2. **Filter** by your package name
3. **Look for** red error messages

**Common causes:**

- **Missing internet permission** in `AndroidManifest.xml`:
  ```xml
  <uses-permission android:name="android.permission.INTERNET" />
  ```

- **Network on main thread:**
  - Retrofit should handle this automatically
  - Check you're not doing synchronous calls

- **Backend not running:**
  - Verify backend is running on port 8080
  - Test with browser: `http://localhost:8080/api/v1/test`

---

### 🔍 General Debugging Tips

#### ✅ Backend Testing Checklist

- [ ] MySQL service is running
- [ ] Database `network_practical` exists
- [ ] Tables are created (check with `SHOW TABLES;`)
- [ ] Test user exists in database
- [ ] Backend server started successfully
- [ ] Can access `http://localhost:8080/api/v1/test` in browser
- [ ] Firewall allows port 8080

#### ✅ Mobile Testing Checklist

- [ ] Backend is running first
- [ ] Correct BASE_URL for emulator/device
- [ ] Same WiFi network (for physical device)
- [ ] Internet permission in manifest
- [ ] Gradle sync successful
- [ ] No build errors
- [ ] Backend accessible from browser on phone

---

### 📞 Still Having Issues?

1. **Check Backend Logs** - Look at console output for errors
2. **Check Android Logcat** - Filter by your package name
3. **Test API with Postman** - Isolate backend issues
4. **Enable SQL Logging** - See actual database queries
5. **Check Network Inspector** - Use Android Studio's Network Profiler

---

## 📸 Screenshots

<div align="center">

### 📱 Mobile App Screens

| Login Screen | Student List | Search Feature |
|:---:|:---:|:---:|
| 🔐 User Authentication | 📋 RecyclerView Display | 🔍 AutoComplete Search |

### 🧪 API Testing

| Postman Login | Get Students | Token Refresh |
|:---:|:---:|:---:|
| ✅ JWT Token Generated | 📊 JSON Response | 🔄 New Access Token |

</div>

> 📸 *Add your actual screenshots here by replacing the table cells with image links*

---

## 🎓 Learning Resources

### 📚 Documentation

- 📘 [Retrofit Documentation](https://square.github.io/retrofit/)
- 📗 [Jersey JAX-RS Guide](https://eclipse-ee4j.github.io/jersey/)
- 📙 [Hibernate ORM Docs](https://hibernate.org/orm/documentation/)
- 📕 [JWT Introduction](https://jwt.io/introduction)
- 📓 [Android Developer Guide](https://developer.android.com/guide)

### 🎥 Video Tutorials

- 🎬 Retrofit Tutorial for Android
- 🎬 REST API with Java Jersey
- 🎬 JWT Authentication Explained
- 🎬 Hibernate ORM Tutorial

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. 🍴 **Fork** the repository
2. 🌿 **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. 💾 **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. 📤 **Push** to the branch (`git push origin feature/AmazingFeature`)
5. 🎉 **Open** a Pull Request

---

## 📋 Roadmap

- [ ] 🔐 Add user registration endpoint
- [ ] 🖼️ Add profile image upload feature
- [ ] 🔍 Implement advanced search filters
- [ ] 📊 Add pagination for large datasets
- [ ] 🌙 Dark mode support
- [ ] 🔔 Push notifications
- [ ] 🧪 Unit tests coverage
- [ ] 📱 iOS version with Swift

---

## 📄 License

This project is created for **educational purposes** and is free to use.

```
MIT License

Copyright (c) 2024 Achintha-999

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction.
```

---

## 👨‍💻 Author

<div align="center">

### **Achintha-999**

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Achintha-999)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](#)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](#)

</div>

---

## ⭐ Show Your Support

If this project helped you learn something new, please give it a ⭐!

<div align="center">

### 🎉 **Happy Coding!** 🎉

**Made with ❤️ and ☕**

---

*📌 If you encounter any issues or have questions, feel free to open an issue in the repository!*

</div>

---

<div align="center">

**[⬆ Back to Top](#-android-networking-with-retrofit)**

</div>
