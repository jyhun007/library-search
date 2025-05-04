package com.library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class NaverBookResponse {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<Item> items;


}
