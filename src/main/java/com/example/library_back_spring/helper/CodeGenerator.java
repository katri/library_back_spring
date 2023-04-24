package com.example.library_back_spring.helper;

import java.util.UUID;

public class CodeGenerator {
    public Long generate() {
        return Math.abs(UUID.randomUUID().getLeastSignificantBits() / 1_000_000_000_000L);
    }
}