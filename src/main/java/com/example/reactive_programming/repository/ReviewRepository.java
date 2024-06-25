package com.example.reactive_programming.repository;

import com.example.reactive_programming.entity.Review;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface ReviewRepository extends R2dbcRepository<Review,Long> {
    Flux<Review> findByBookId(Long bookId);
}
