package com.sovadeveloper.numbers.service.impl;

import com.sovadeveloper.numbers.dto.ManyNumbers;
import com.sovadeveloper.numbers.dto.OneDoubleNumber;
import com.sovadeveloper.numbers.dto.OneIntegerNumber;
import com.sovadeveloper.numbers.property.StorageProperty;
import com.sovadeveloper.numbers.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

@Service
public class NumberServiceImpl implements NumberService {

    private final StorageProperty storageProperty;

    @Autowired
    public NumberServiceImpl(StorageProperty storageProperty) {
        this.storageProperty = storageProperty;
    }

    @Cacheable("list")
    @Override
    public List<Integer> getNumbersFromFile() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(storageProperty.getUploadDirectory() + "10m.txt"));
        return bufferedReader.lines().mapToInt(Integer::parseInt).boxed().toList();
    }

    @Cacheable("max")
    @Override
    public OneIntegerNumber getMaxNumber() throws FileNotFoundException {
        List<Integer> numbers = getNumbersFromFile();
        return new OneIntegerNumber(Collections.max(numbers));

//        List<Integer> numbers = getNumbersFromFile();
//        Integer max = Integer.MIN_VALUE;
//        for(Integer number: numbers){
//            if(number > max){
//                max = number;
//            }
//        }
//        return new OneIntegerNumber(max);
    }

    @Cacheable("min")
    @Override
    public OneIntegerNumber getMinNumber() throws FileNotFoundException {
        List<Integer> numbers = getNumbersFromFile();
        return new OneIntegerNumber(Collections.min(numbers));

//        List<Integer> numbers = getNumbersFromFile();
//        Integer min = Integer.MAX_VALUE;
//        for(Integer number: numbers){
//            if(number < min){
//                min = number;
//            }
//        }
//        return new OneIntegerNumber(min);
    }

    @Cacheable("median")
    @Override
    public OneIntegerNumber getMedian() throws FileNotFoundException {
        List<Integer> numbers = Collections.unmodifiableList(getNumbersFromFile());
        List<Integer> newNumbers = new ArrayList<>(numbers);
        Collections.sort(newNumbers);
        return new OneIntegerNumber(newNumbers.get(newNumbers.size() / 2));
    }

    @Cacheable("average")
    @Override
    public OneDoubleNumber getAverage() throws FileNotFoundException {
        List<Integer> numbers = getNumbersFromFile();
        OptionalDouble average = numbers.stream().mapToInt(elem -> elem).average();
        return new OneDoubleNumber(average.getAsDouble());
    }

    @Cacheable("increasingSequence")
    @Override
    public ManyNumbers getIncreasingSequence() throws FileNotFoundException {
        List<List<Integer>> sequences = new ArrayList<>();
        List<Integer> numbers = getNumbersFromFile();
        List<Integer> maxes = new ArrayList<>();
        int max = 0;
        maxes.add(0, 0);
        for(int i = 1; i < numbers.size(); i++){
            if (numbers.get(i) > numbers.get(i - 1))
                maxes.add(i, maxes.get(i - 1) + 1);
            else maxes.add(i, 0);
            max = Math.max(maxes.get(i), max);
        }
        for(int i = 0; i < numbers.size(); i++){
            if (maxes.get(i) == max){
                List<Integer> sequence = new ArrayList<>();
                int k = 0;
                for(int j = i - maxes.get(i); j <= i; j++) {
                    sequence.add(k, numbers.get(j));
                    k++;
                }
                sequences.add(sequence);
            }
        }
        return new ManyNumbers(sequences);
    }

    @Cacheable("decreasingSequence")
    @Override
    public ManyNumbers getDecreasingSequence() throws FileNotFoundException {
        List<List<Integer>> sequences = new ArrayList<>();
        List<Integer> numbers = getNumbersFromFile();
        List<Integer> maxes = new ArrayList<>();
        int max = 0;
        maxes.add(0, 0);
        for(int i = 1; i < numbers.size(); i++){
            if (numbers.get(i) < numbers.get(i - 1))
                maxes.add(i, maxes.get(i - 1) + 1);
            else maxes.add(i, 0);
            max = Math.max(maxes.get(i), max);
        }
        for(int i = 0; i < numbers.size(); i++){
            if (maxes.get(i) == max){
                List<Integer> sequence = new ArrayList<>();
                int k = 0;
                for(int j = i - maxes.get(i); j <= i; j++) {
                    sequence.add(k, numbers.get(j));
                    k++;
                }
                sequences.add(sequence);
            }
        }
        return new ManyNumbers(sequences);
    }
}
