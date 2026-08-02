# Flashcard Quiz App

A full-stack flashcard app for studying — flip cards to reveal answers, navigate between them, and add/edit/delete your own flashcards. Built with a Spring Boot REST API backend and a vanilla JavaScript frontend.

# Screenshots 
<img width="325" height="400" alt="Screenshot 2026-08-02 232200" src="https://github.com/user-attachments/assets/c85cd4e6-4749-43d6-837c-eea04ef60f2e" />
<img width="325" height="400" alt="Screenshot 2026-08-02 232821" src="https://github.com/user-attachments/assets/a6a62082-3cda-4abd-8ba0-7225cce614c4" />

## Features

- Flip any card to reveal its answer
- Navigate between cards with Next/Previous
- Add, edit, and delete flashcards
- Data persists in a real database (H2), not just browser storage

## Tech stack

**Backend**
- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- H2 database (file-based)
- Maven

**Frontend**
- HTML / CSS / vanilla JavaScript
- No frameworks, no build step — just `fetch()` calls to the backend

## Project structure

```
flashcard-quiz-app/
├── backend/                 → Spring Boot REST API
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/flashcards/app/
│       │   ├── FlashcardApplication.java   → entry point
│       │   ├── Flashcard.java              → JPA entity
│       │   ├── FlashcardRepository.java    → data access layer
│       │   ├── FlashcardController.java    → REST endpoints
│       │   └── DataSeeder.java             → sample data on first run
│       └── resources/application.properties
└── frontend/
    └── index.html            → the entire frontend (HTML + CSS + JS in one file)
```

## API endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/flashcards` | Get all flashcards |
| GET | `/api/flashcards/{id}` | Get a single flashcard |
| POST | `/api/flashcards` | Create a flashcard |
| PUT | `/api/flashcards/{id}` | Update a flashcard |
| DELETE | `/api/flashcards/{id}` | Delete a flashcard |

## How to run locally

**Requirements:** Java 17+, Maven

1. Clone the repo:
   ```
   git clone https://github.com/singhgaurav7905/CodeAlpha_Flashcard-Quiz-App.git
   cd flashcard-quiz-app
   ```

2. Start the backend:
   ```
   cd backend
   mvn spring-boot:run
   ```
   The server starts on `http://localhost:8080`. On first run it creates a local H2 database at `backend/data/flashcards.mv.db` and seeds 3 sample cards.

3. Open the frontend:
   Open `frontend/index.html` directly in your browser (double-click it, or right-click → Open With → your browser).

4. (Optional) Inspect the database directly at `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:file:./data/flashcards`
   - Username: `sa`
   - Password: *(leave blank)*

## Possible future improvements

- Swap H2 for PostgreSQL for a production-ready database
- Add user accounts so each user has their own flashcard set
- Add a quiz/scoring mode
- Add search and category tags for flashcards
