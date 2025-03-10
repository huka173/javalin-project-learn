package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class MainPage {
    private Boolean visited;
    private String userName;

    public Boolean isVisited() {
        return visited;
    }
}
