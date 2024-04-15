package org.next.mallapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.next.mallapi.dto.PageRequestDTO;
import org.next.mallapi.dto.PageResponseDTO;
import org.next.mallapi.dto.TodoDTO;
import org.next.mallapi.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/{tno}")
    public TodoDTO getTodo(@PathVariable("tno") Long tno) {

        return todoService.get(tno);
    }

    @GetMapping("/list")
    public PageResponseDTO<TodoDTO> getTodoList(PageRequestDTO pageRequestDTO) {

        return todoService.getList(pageRequestDTO);
    }

    @PostMapping("/")
    public Map<String, Long> register(@RequestBody TodoDTO dto) {

        log.info("todo DTO: " + dto);

        Long tno = todoService.register(dto);

        return Map.of("TNO", tno);

    }

    @PutMapping("/{tno}")
    public Map<String, String> modify(@PathVariable("tno") Long tno, @RequestBody TodoDTO dto) {

        dto.setTno(tno);

        todoService.modity(dto);

        return Map.of("RESULT", "SUCCESS");
    }

    @DeleteMapping("/{tno}")
    public Map<String, String> remove(@PathVariable("tno") Long tno) {

        todoService.remove(tno);

        return Map.of("RESULT", "SUCCESS");
    }
}
