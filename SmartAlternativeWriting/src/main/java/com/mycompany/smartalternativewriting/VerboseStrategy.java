package com.mycompany.smartalternativewriting;

public class VerboseStrategy implements DisplayStrategy {

    @Override
    public String display(String input, EncoderPrototype encoder) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toUpperCase().toCharArray()) {
            sb.append(c).append("=")
              .append(encoder.encode(c))
              .append(", ");
        }
        if (sb.length() > 2)
            sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}


