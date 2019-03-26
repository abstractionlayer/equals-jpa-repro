package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Author;


public interface AuthorsRepository extends JpaRepository<Author, Long> {
}
