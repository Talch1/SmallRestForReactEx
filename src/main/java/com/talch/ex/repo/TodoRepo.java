package com.talch.ex.repo;

import com.talch.ex.beans.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo, Long> {

}
