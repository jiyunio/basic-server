package com.basic.study.controller;

import com.basic.study.dto.TodoReq;
import com.basic.study.dto.TodoUpdateReq;
import com.basic.study.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/todos")
public class TodoController {
    final private TodoService todoService;

    @PostMapping("")
    public ResponseEntity<?> postTodo(@RequestBody TodoReq todoReq) {
        return ResponseEntity.ok(todoService.createTodo(todoReq));
    }

    @GetMapping("")
    public ResponseEntity<?> getTodoes(@RequestParam Long memberId) {
        return ResponseEntity.ok(todoService.readTodoes(memberId));
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<?> putTodo(@PathVariable Long todoId, @RequestBody TodoUpdateReq todoUpdateReq) {
        return ResponseEntity.ok(todoService.updateTodo(todoId, todoUpdateReq));
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long todoId) {
        return todoService.deleteTodo(todoId)
                ? ResponseEntity.ok("todo 삭제 성공")
                : ResponseEntity.ok("todo 삭제 실패");
    }

}
