package org.next.mallapi.service;

import jakarta.transaction.Transactional;
import org.next.mallapi.domain.Todo;
import org.next.mallapi.dto.TodoDTO;

@Transactional
public interface TodoService {

    TodoDTO get(Long tno);

    Long register(TodoDTO dto);

    void modity(TodoDTO dto);

    void remove(Long tno);

    default TodoDTO entityToDTO(Todo todo) {

        TodoDTO todoDTO =
                TodoDTO.builder()
                        .tno(todo.getTno())
                        .title(todo.getTitle())
                        .content(todo.getContent())
                        .complete(todo.isComplete())
                        .dueDate(todo.getDueDate())
                        .build();

        return todoDTO;
    }

    default Todo dtoToEntity(TodoDTO todoDTO) {

        Todo todo =
                Todo.builder()
                .tno(todoDTO.getTno())
                .title(todoDTO.getTitle())
                .content(todoDTO.getContent())
                .complete(todoDTO.isComplete())
                .dueDate(todoDTO.getDueDate())
                .build();

        return todo;
    }
}
