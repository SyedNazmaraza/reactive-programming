package com.example.reactive_programming.repository;

import com.example.reactive_programming.entity.BookInfo;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface BookInfoRepository extends R2dbcRepository<BookInfo,Long> {
}
