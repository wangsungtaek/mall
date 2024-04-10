package org.next.mallapi.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.next.mallapi.domain.Todo;
import org.next.mallapi.dto.PageRequestDTO;
import org.next.mallapi.dto.PageResponseDTO;
import org.next.mallapi.dto.TodoDTO;
import org.next.mallapi.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;


    @Override
    public TodoDTO get(Long tno) {

        Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow(() -> new RuntimeException("No todo"));

        return entityToDTO(todo);
    }

    @Override
    public Long register(TodoDTO dto) {

        Todo todo = dtoToEntity(dto);

        Todo result = todoRepository.save(todo);

        return result.getTno();
    }

    @Override
    public void modity(TodoDTO dto) {

        Optional<Todo> result = todoRepository.findById(dto.getTno());

        Todo todo = result.orElseThrow();

        todo.changeTitle(dto.getTitle());
        todo.changeContent(dto.getContent());
        todo.changeComplete(dto.isComplete());
        todo.changeDueDate(dto.getDueDate());

        todoRepository.save(todo);
    }

    @Override
    public void remove(Long tno) {

        todoRepository.deleteById(tno);
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {

        // JPA
        Page<Todo> todos = todoRepository.search1(pageRequestDTO);

        List<TodoDTO> dtoList = todos
                .get()
                .map(todo -> entityToDTO(todo)).collect(Collectors.toList());

        PageResponseDTO<TodoDTO> responseDTO =
                PageResponseDTO.<TodoDTO>withAll()
                    .dtoList(dtoList)
                    .pageRequestDTO(pageRequestDTO)
                    .total(todos.getTotalElements())
                    .build();

        return responseDTO;
    }
}
