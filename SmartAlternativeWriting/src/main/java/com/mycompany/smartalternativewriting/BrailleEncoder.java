package com.mycompany.smartalternativewriting;

import java.util.HashMap;
import java.util.Map;

public class BrailleEncoder extends EncoderPrototype {

    private Map<Character, String> map = new HashMap<>();
    private Map<String, Character> reverseMap = new HashMap<>();

    public BrailleEncoder() {
        map.put('A', "⠁"); map.put('B', "⠃"); map.put('C', "⠉");
        map.put('D', "⠙"); map.put('E', "⠑"); map.put('F', "⠋");
        map.put('G', "⠛"); map.put('H', "⠓"); map.put('I', "⠊");
        map.put('J', "⠚"); map.put('K', "⠅"); map.put('L', "⠇");
        map.put('M', "⠍"); map.put('N', "⠝"); map.put('O', "⠕");
        map.put('P', "⠏"); map.put('Q', "⠟"); map.put('R', "⠗");
        map.put('S', "⠎"); map.put('T', "⠞"); map.put('U', "⠥");
        map.put('V', "⠧"); map.put('W', "⠺"); map.put('X', "⠭");
        map.put('Y', "⠽"); map.put('Z', "⠵"); map.put(' ', " ");

        for (var e : map.entrySet())
            reverseMap.put(e.getValue(), e.getKey());
    }

    @Override
    public String encode(char c) {
        return map.getOrDefault(c, "?");
    }

    @Override
    public char decode(String code) {
        return reverseMap.getOrDefault(code, '?');
    }
}


