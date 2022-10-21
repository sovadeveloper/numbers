package com.sovadeveloper.numbers.service;

import com.sovadeveloper.numbers.dto.ManyNumbers;
import com.sovadeveloper.numbers.dto.OneDoubleNumber;
import com.sovadeveloper.numbers.dto.OneIntegerNumber;

import java.io.FileNotFoundException;
import java.util.List;

public interface NumberService {
    List<Integer> getNumbersFromFile() throws FileNotFoundException;
    OneIntegerNumber getMaxNumber() throws FileNotFoundException;
    OneIntegerNumber getMinNumber() throws FileNotFoundException;
    OneIntegerNumber getMedian() throws FileNotFoundException;
    OneDoubleNumber getAverage() throws FileNotFoundException;
    ManyNumbers getIncreasingSequence() throws FileNotFoundException;
    ManyNumbers getDecreasingSequence() throws FileNotFoundException;
}
