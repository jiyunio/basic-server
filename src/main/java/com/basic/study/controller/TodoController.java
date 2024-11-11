package com.basic.study.controller;

import com.basic.study.dto.TodoReq;
import com.basic.study.service.MemberService;
import com.basic.study.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/todos")
public class TodoController {
    final private TodoService todoService;
    //CRUD

    //createTodo
    @PostMapping("")
    public ResponseEntity<?> postTodo(@RequestBody TodoReq todoReq) {
        return ResponseEntity.ok(todoService.createTodo(todoReq));
    }

    //readTodos
    @GetMapping("/{memberId}")
    public ResponseEntity<?> getTodoes(@PathVariable Long memberId){
        return ResponseEntity.ok(todoService.readTodoes(memberId));
    }

//    //updateTodo
//    @PatchMapping("")
//    public ResponseEntity<?> patchTodo(@RequestBody TodoReq todoReq){
//
//    }
//
//    //deleteTodo
//    @DeleteMapping("/{memberId}/{todoId}")
//    public ResponseEntity<?> deleteTodo(@PathVariable Long memberId, @PathVariable Long todoId){
//
//    }

}
