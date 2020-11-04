package com.talch.ex.repo;

import com.talch.ex.beans.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepo extends JpaRepository<Todo, Long> {
Optional<Todo> findByTitle(String id);
}
