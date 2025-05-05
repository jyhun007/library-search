package com.library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.naming.directory.SearchResult;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class NaverBookResponse {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<Item> items;



}
