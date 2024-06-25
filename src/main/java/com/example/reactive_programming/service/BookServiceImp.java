package com.example.reactive_programming.service;

import com.example.reactive_programming.domain.BookDto;
import com.example.reactive_programming.entity.BookInfo;
import com.example.reactive_programming.entity.Review;
import com.example.reactive_programming.exception.BookException;
import com.example.reactive_programming.repository.BookInfoRepository;
import com.example.reactive_programming.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService{

    private BookInfoRepository bookRepository;
    private ReviewRepository reviewRepository;

    @Override
    public Flux<BookDto> getBooks() {
        Flux<BookInfo> allBooks = bookRepository.findAll();
        return allBooks
                .flatMap(bookInfo -> {
                    Mono<List<Review>> reviews =
                            reviewRepository.findByBookId(bookInfo.getBookId()).collectList();
                    return reviews
                            .map(review -> new BookDto(bookInfo,review));
                })
                .onErrorMap(throwable -> {
                    log.error("Exception is :" + throwable);
                    return new BookException("Exception occurred while fetching Books");
                })
                .log();
    }
    @Override
    public Flux<BookDto> getBooksRetry() {
        Flux<BookInfo> allBooks = bookRepository.findAll();
        return allBooks
                .flatMap(bookInfo -> {
                    Mono<List<Review>> reviews =
                            reviewRepository.findByBookId(bookInfo.getBookId()).collectList();
                    return reviews
                            .map(review -> new BookDto(bookInfo,review));
                })
                .onErrorMap(throwable -> {
                    log.error("Exception is :" + throwable);
                    return new BookException("Exception occurred while fetching Books");
                })
                .retry(3)
                .log();
    }
    @Override
    public Mono<BookDto> getBookById(long bookId) {
        Mono<BookInfo> book = bookRepository.findById(bookId);
        Mono<List<Review>> review = reviewRepository
                .findByBookId(bookId)
                .collectList();

        return  book
                .zipWith(review, BookDto::new);

    }
}
