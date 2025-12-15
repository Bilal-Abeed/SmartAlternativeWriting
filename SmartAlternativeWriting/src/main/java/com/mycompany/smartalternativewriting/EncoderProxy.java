package com.mycompany.smartalternativewriting;

import javax.swing.JOptionPane;

public class EncoderProxy {
    private User user;

    public EncoderProxy(User user) {
        this.user = user;
    }

    public EncoderPrototype getEncoder(String type, boolean isDecoding) {
        // Check access permissions for Secret Cipher
        if (type.equals("Secret Cipher")) {
            if (user.getRole().equalsIgnoreCase("Student")) {
                String operation = isDecoding ? "decode" : "encode";
                JOptionPane.showMessageDialog(null,
                    "Access Denied!\n\n" +
                    "You are logged in as: Student\n" +
                    "Operation: " + operation + " using Secret Cipher\n" +
                    "Permission: Not Allowed\n\n" +
                    "Only Researchers can use the Secret Cipher system.",
                    "Access Restricted",
                    JOptionPane.WARNING_MESSAGE);
                return null;
            }
        }

        
        switch (type) {
            case "Morse Code":
                return new MorseEncoder().clone();
            case "Braille":
                return new BrailleEncoder().clone();
            case "Secret Cipher":
                return new SecretEncoder().clone();
            default:
                return null;
        }
    }
}

