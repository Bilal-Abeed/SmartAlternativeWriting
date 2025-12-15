package com.mycompany.smartalternativewriting;

public class CompactStrategy implements DisplayStrategy {

    @Override
    public String display(String input, EncoderPrototype encoder) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toUpperCase().toCharArray()) {
            sb.append(encoder.encode(c)).append(" ");
        }
        return sb.toString().trim();
    }
}

