package com.flashcards.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final FlashcardRepository repository;

    public DataSeeder(FlashcardRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.save(new Flashcard("What is a variable?",
                    "A named storage location that holds a value which can change during program execution."));
            repository.save(new Flashcard("What does CPU stand for?",
                    "Central Processing Unit."));
            repository.save(new Flashcard("What is Big O notation used for?",
                    "To describe how the runtime or memory usage of an algorithm grows as input size increases."));
        }
    }
}
