package com.example.reactive_programming.controller;

import com.example.reactive_programming.domain.BookDto;
import com.example.reactive_programming.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RequestMapping("/books")
@RestController
public class BookController {

    private final BookService bookService;
    @GetMapping("/")
    public Flux<BookDto> getBooks() {
        return bookService.getBooks();
    }
    @GetMapping("/{id}")
    public Mono<BookDto> getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

}
