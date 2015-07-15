package de.codeshelf.drift;

import de.codeshelf.drift.repositories.DriftRepositoryIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DriftApplication {

    @Autowired
    private DriftRepositoryIF repository;

    public static void main(String[] args) {
        SpringApplication.run(DriftApplication.class, args);
    }
}