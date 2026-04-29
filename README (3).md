<p align="center">
  <img src="assets/Anajsetu_pic.png" alt="AnajSetu - Bridge to Food, Hope to Lives" width="80%"/>
</p>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![Java](https://img.shields.io/badge/Java-21+-orange.svg)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE.md)

</div>

---

<p align="center">
  AnajSetu connects food donors with NGOs and individuals in need — reducing food waste and fighting hunger, one meal at a time. 🍱
</p>

---

## 📝 Table of Contents

- [About](#about)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Backend Setup](#backend-setup)
  - [Frontend Setup](#frontend-setup)
- [Environment Variables](#environment-variables)
- [API Overview](#api-overview)
- [Authors](#authors)
- [License](#license)

---

## 🧐 About <a name="about"></a>

**AnajSetu** (meaning *"Bridge of Grain"*) is a full-stack web platform built to:

- Allow donors (restaurants, households, events) to list surplus food
- Connect NGOs and volunteers to collect and redistribute food
- Enable transparent, trackable donations with payment support via Razorpay
- Promote a zero-waste culture across communities

---

## ✨ Features <a name="features"></a>

- 🔐 Secure JWT-based User Authentication (Register / Login)
- 🍱 Post & Browse Food Donations
- 🤝 NGO & Donor Dashboards
- 💳 Razorpay Payment Integration
- 📱 Responsive Frontend UI
- 🔒 Role-based Access Control
- ✅ OTP-Verified Handover for secure delivery
- ♻️ Auto-redirect to compost center if NGO misses deadline
- 🌿 Biogas generation tracking for uncollected food
- 🛡️ FSSAI Compliant with digital audit trails

---

## ⛏️ Tech Stack <a name="tech-stack"></a>

### 🖥️ Backend
| Technology | Purpose |
|---|---|
| Java 21+ | Core Language |
| Spring Boot 4.0.6 | REST API Framework |
| Spring Data JPA | ORM / Database Layer |
| MySQL | Relational Database |
| JWT (jjwt 0.12.6) | Authentication |
| Razorpay Java SDK | Payment Gateway |
| Lombok | Boilerplate Reduction |
| Maven | Build Tool |

### 🎨 Frontend
| Technology | Purpose |
|---|---|
| React.js | UI Framework |
| Axios | HTTP Client |
| React Router | Client-side Routing |
| Tailwind CSS / Bootstrap | Styling |
| Razorpay Checkout | Payment UI |

> ✏️ Update the frontend table if your stack is different.

---

## 📁 Project Structure <a name="project-structure"></a>

\`
\`
\`anajsetu/
│
├── 📂 backend/                        # Spring Boot Project
│   └── src/
│       ├── main/
│       │   ├── java/com/example/anajsetu/
│       │   │   ├── controller/        # REST Controllers
│       │   │   ├── service/           # Business Logic
│       │   │   ├── repository/        # JPA Repositories
│       │   │   ├── model/             # Entity Classes
│       │   │   ├── dto/               # Data Transfer Objects
│       │   │   ├── config/            # Security & App Config
│       │   │   └── AnajsetuApplication.java
│       │   └── resources/
│       │       └── application.properties
│       └── test/
│
├── 📂 frontend/                       # React Frontend
│   └── src/
│       ├── components/                # Reusable UI Components
│       ├── pages/                     # Page-level Views
│       ├── services/                  # Axios API Calls
│       ├── context/                   # Auth & Global State
│       ├── assets/                    # Images & Icons
│       ├── App.js
│       └── index.js
│
└── 📂 assets/
    └── Anajsetu_pic.png               # Project Banner
\`
\`
\`

---

## 🏁 Getting Started <a name="getting-started"></a>

### Prerequisites

Make sure the following are installed on your machine:

- [Java JDK 21+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [MySQL 8+](https://dev.mysql.com/downloads/)
- [Node.js 18+](https://nodejs.org/)
- [Git](https://git-scm.com/)

---

### 🖥️ Backend Setup <a name="backend-setup"></a>

**1. Clone the repository**
\`
\`
\`bash
git clone https://github.com/YOUR_USERNAME/anajsetu.git
cd anajsetu/backend
\`bash

**2. Create MySQL database**
\`
\`
\`sql
CREATE DATABASE anajsetu;
\`sql

**3. Configure \`application.properties\`**

Create/edit \`src/main/resources/application.properties\` — see [Environment Variables](#environment-variables).

**4. Run the backend**
\`
\`
\`bash
./mvnw spring-boot:run
\`bash

✅ Backend runs at: **http://localhost:8080**

---

### 🎨 Frontend Setup <a name="frontend-setup"></a>

**1. Navigate to frontend folder**
\`
\`
\`bash
cd anajsetu/frontend
\`bash

**2. Install dependencies**
\`
\`
\`bash
npm install
\`bash

**3. Create \.env file** — see [Environment Variables](#environment-variables).

**4. Start the frontend**
\`
\`
\`bash
npm start
\`bash

✅ Frontend runs at: **http://localhost:3000**

---

## 🔐 Environment Variables <a name="environment-variables"></a>

### Backend — \`src/main/resources/application.properties\`

\`
\`
\`properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/anajsetu
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT
jwt.secret=YOUR_SECRET_KEY
jwt.expiration=86400000

# Razorpay
razorpay.key.id=YOUR_RAZORPAY_KEY_ID
razorpay.key.secret=YOUR_RAZORPAY_KEY_SECRET

# Server
server.port=8080
\`
\`
\`

### Frontend — \.env (in frontend root)

\`
\`
\`env
REACT_APP_API_BASE_URL=http://localhost:8080/api
REACT_APP_RAZORPAY_KEY_ID=YOUR_RAZORPAY_KEY_ID
\`
\`
\`

> ⚠️ **Never commit real credentials.** Add \`application.properties\` and \.env to your \.gitignore.

---

## 📡 API Overview <a name="api-overview"></a>

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | \`/api/auth/register\` | Register a new user |
| POST | \`/api/auth/login\` | Login & receive JWT token |
| GET | \`/api/donations\` | Fetch all food donations |
| POST | \`/api/donations\` | Create a new donation |
| PUT | \`/api/donations/{id}\` | Update a donation |
| DELETE | \`/api/donations/{id}\` | Delete a donation |
| POST | \`/api/payment/create-order\` | Create Razorpay order |
| POST | \`/api/payment/verify\` | Verify Razorpay payment |

> Full API documentation coming soon (Postman / Swagger).

---

## ✍️ Authors <a name="authors"></a>

- **Your Name** — [@your-github](https://github.com/your-github)

---

## 📄 License <a name="license"></a>

This project is licensed under the [MIT License](LICENSE.md).

---

<p align="center">Made with ❤️ to fight food waste 🌾</p>
<p align="center"><b>RESCUE FOOD • FEED PEOPLE • REDUCE WASTE • RESTORE PLANET</b></p>