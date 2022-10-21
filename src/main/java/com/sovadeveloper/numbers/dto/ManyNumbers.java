package com.sovadeveloper.numbers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ManyNumbers {
    private List<List<Integer>> sequences;
}
