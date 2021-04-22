package com.erotronics.hps.domain;

import lombok.Data;

import java.util.List;

@Data
public class Verses {
    private final String type;
    private final String number;
    private final List<String> lyrics;
}
