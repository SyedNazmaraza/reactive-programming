package com.example.reactive_programming.service;

import com.example.reactive_programming.domain.BookDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
    Flux<BookDto> getBooks();

    Flux<BookDto> getBooksRetry();

    Mono<BookDto> getBookById(long bookId);
}
