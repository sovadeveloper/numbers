package com.sovadeveloper.numbers.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JacksonXmlRootElement
public class ManyNumbers {
    private List<List<Integer>> sequences;
}
