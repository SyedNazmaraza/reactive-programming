package com.example.reactive_programming.domain;

import com.example.reactive_programming.entity.BookInfo;
import com.example.reactive_programming.entity.CarEntity;
import com.example.reactive_programming.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private BookInfo bookInfo;
    private List<Review> reviews;
}
