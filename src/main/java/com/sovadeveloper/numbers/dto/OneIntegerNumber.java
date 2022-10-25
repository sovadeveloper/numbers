package com.sovadeveloper.numbers.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JacksonXmlRootElement
public class OneIntegerNumber {
    private Integer value;
}
