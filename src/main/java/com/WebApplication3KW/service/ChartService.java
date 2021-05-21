package com.WebApplication3KW.service;

import com.WebApplication3KW.dto.ChartDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class ChartService {

    public ChartDTO createRandomNumbers() {
        ArrayList<Integer> numberList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++)
            numberList.add(random.nextInt(100) + 1);
        return ChartDTO.builder()
                .numbers(numberList)
                .build();
    }
}
