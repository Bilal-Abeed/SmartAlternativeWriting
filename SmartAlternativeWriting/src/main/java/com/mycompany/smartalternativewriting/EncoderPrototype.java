package com.mycompany.smartalternativewriting;

public abstract class EncoderPrototype implements Cloneable {
    public abstract String encode(char c);
    public abstract char decode(String code);

    @Override
    public EncoderPrototype clone() {
        try {
            return (EncoderPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}



