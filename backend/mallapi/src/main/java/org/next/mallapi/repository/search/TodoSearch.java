package org.next.mallapi.repository.search;

import org.next.mallapi.domain.Todo;
import org.next.mallapi.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface TodoSearch {

    Page<Todo> search1(PageRequestDTO pageRequestDTO);
}
