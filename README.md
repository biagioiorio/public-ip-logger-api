# 🌍 Public IP Logger API

Un'alternativa etica e open-source per tracciare click sui link.  
Semplice, privacy-friendly e pronta per essere integrata ovunque.

![Java](https://img.shields.io/badge/java-21-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.2-green)

## 🚀 Funzionalità

- 🎯 Genera link tracciabili e anonimizzati
- 📊 Ricevi statistiche: paese, browser, OS, device
- 🔐 Niente IP salvati, zero cookie, GDPR-friendly
- 🔁 Redirect immediato alla destinazione originale
- 🧰 API REST pronte all'uso

## 📦 API Principali

```http
POST   /trackers           # Crea un nuovo link di tracking
GET    /track/{id}         # Registra un click e reindirizza
GET    /trackers/{id}/stats # Statistiche click (JSON)
