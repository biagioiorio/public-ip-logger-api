# Public IP Logger API

🌐 A lightweight, privacy-conscious API for logging click events and redirecting users while **avoiding permanent IP storage**.

## 🚀 Features

- Log incoming user clicks via a simple API
- Capture and log user agent and IP (configurable to hash/store it)
- Timestamped records in a MySQL database
- Lightweight redirect handler with tracking
- Built with Spring Boot

## 📦 Endpoints

### `POST /api/logs`
Logs a click or visit event.

**Request Body:**
```json
{
  "hashedIp": "hashed_ip_1",
  "userAgent": "user_agent_1"
}
```

---

### `GET /api/logs`
Returns all logged entries.

---

### `GET /r?to=URL`
Logs the visit and redirects to the given URL.

**Example:**
```
/r?to=https://google.com
```

---

## ⚙️ Technologies

- Java 21
- Spring Boot 3
- MySQL (configurable)
- Maven

## 🛠️ Setup

1. Clone the repo  
   ```bash
   git clone https://github.com/biagioiorio/public-ip-logger-api.git
   ```

2. Configure your `application.properties` with your DB credentials:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/public_ip_logger
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## 📌 Roadmap

- [x] Redirect with logging
- [x] IP + User-Agent logging
- [ ] Optional IP hashing
- [ ] `.env` support for credentials
- [ ] Access stats endpoint

---

## 📄 License

This project is licensed under the **GNU General Public License v3.0** – see the [LICENSE](LICENSE) file for details.
