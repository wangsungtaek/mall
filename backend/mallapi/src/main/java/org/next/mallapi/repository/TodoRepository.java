package org.next.mallapi.repository;

import org.next.mallapi.domain.Todo;
import org.next.mallapi.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long>, TodoSearch {
}
