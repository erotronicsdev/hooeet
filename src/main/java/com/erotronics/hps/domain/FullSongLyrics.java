package com.erotronics.hps.domain;

import lombok.Data;

import java.util.List;

@Data
public class FullSongLyrics {
    private final List<Verses> verses;
}
