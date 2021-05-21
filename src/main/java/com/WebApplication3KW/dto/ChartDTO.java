package com.WebApplication3KW.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class ChartDTO {
    private final ArrayList<Integer> numbers;
}
