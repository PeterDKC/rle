package com.example.rle;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompressionTest {
    @Test
    public void compressionAndRatioWork() {
        String input = "AAABBCCCCDEEFGGGG";
        String compressed = "3A2B4C1D2E1F4G";
        double ratio = 1.21;
        Compression compression = new Compression();

        assertEquals(
                compressed + ", " + ratio,
                compression.compress(input)
        );
    }
}
