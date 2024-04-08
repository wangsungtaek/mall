package org.next.mallapi.service;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.next.mallapi.dto.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class TodoServiceTests {

    @Autowired
    TodoService todoService;

    @Test
    public void testGet() {

        Long tno = 102L;

        log.info(todoService.get(tno));
    }

    @Test
    public void testRegister() {

        TodoDTO todoDTO = TodoDTO.builder()
                .title("test DTO...")
                .content("content...")
                .dueDate(LocalDate.of(2024, 4, 8))
                .build();

        log.info(todoService.register(todoDTO));

    }

    @Test
    public void testModify() {

        TodoDTO todoDTO = TodoDTO.builder()
                .tno(102L)
                .title("update Title..")
                .content("modify Content...")
                .complete(false)
                .dueDate(LocalDate.of(2024,4,9))
                .build();

        todoService.modity(todoDTO);

    }

    @Test
    public void testDelete() {

        Long tno = 102L;

        todoService.remove(tno);
    }
}
