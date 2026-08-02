package com.flashcards.app;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flashcards")
@CrossOrigin(origins = "*") // allows the frontend (opened as a local file) to call this API
public class FlashcardController {

    @Autowired
    private FlashcardRepository repository;

    @GetMapping
    public List<Flashcard> getAllFlashcards() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flashcard> getFlashcardById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Flashcard createFlashcard(@Valid @RequestBody Flashcard flashcard) {
        return repository.save(flashcard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flashcard> updateFlashcard(@PathVariable Long id, @Valid @RequestBody Flashcard updatedCard) {
        return repository.findById(id)
                .map(card -> {
                    card.setQuestion(updatedCard.getQuestion());
                    card.setAnswer(updatedCard.getAnswer());
                    Flashcard saved = repository.save(card);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlashcard(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
