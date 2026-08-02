package com.flashcards.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
    // JpaRepository already gives us save, findAll, findById, deleteById, etc.
}
