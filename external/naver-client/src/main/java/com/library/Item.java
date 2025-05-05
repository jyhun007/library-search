package com.library;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.LinkedHashMap;

@Getter
@ToString
@NoArgsConstructor
//@Builder
//@AllArgsConstructor
public class Item {
    private String title;
    private String link;
    private String image;
    private String author;
    private String discount;
    private String publisher;
    @JsonProperty("pubdate")
    private String pubDate;
    private String isbn;
    private String description;

//    public Item(String title, String author, String publisher, String pubDate, String isbn) {
//        this.title = title;
//        this.author = author;
//        this.publisher = publisher;
//        this.pubDate = pubDate;
//        this.isbn = isbn;
//    }

}
