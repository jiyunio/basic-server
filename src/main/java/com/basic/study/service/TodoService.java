package com.basic.study.service;

import com.basic.study.domain.Member;
import com.basic.study.domain.Todo;
import com.basic.study.dto.TodoReq;
import com.basic.study.dto.TodoRes;
import com.basic.study.repository.MemberRepository;
import com.basic.study.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    final private MemberRepository memberRepository;
    final private TodoRepository todoRepository;

    // CRUD
    public TodoRes createTodo(TodoReq todoReq) {
        Todo todo = Todo.builder()
                .content(todoReq.getContent())
                .deadLine(todoReq.getDeadLine())
                .member(memberRepository.findById(todoReq.getMemberId()).get())
                .build();
        todoRepository.save(todo);

        return TodoRes.builder()
                .memberId(todoReq.getMemberId())
                .content(todoReq.getContent())
                .build();
    }

    public List<TodoRes> readTodoes(Long memberId) {
        List<Todo> todoList = todoRepository.findAllByMemberId(memberId);
        ArrayList<TodoRes> todoResList = new ArrayList<>();

        for (Todo todo: todoList) {
            TodoRes todoRes = TodoRes.builder()
                    .memberId(todo.getMember().getId())
                    .content(todo.getContent())
                    .build();
            todoResList.add(todoRes);
        }
        return todoResList;
    }

}
