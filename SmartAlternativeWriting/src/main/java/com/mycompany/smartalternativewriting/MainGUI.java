package com.mycompany.smartalternativewriting;

import javax.swing.*;
import java.awt.*;

public class MainGUI {
    private JTextArea input, output;
    private JComboBox<String> encoderBox;
    private JRadioButton compact, verbose, encode, decode;
    private User user;
    private JFrame frame;

    public MainGUI(User user) {
        this.user = user;
        init();
    }

    private void init() {
        frame = new JFrame("Smart Alternative Writing Systems");
        frame.setSize(550, 500);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        input = new JTextArea(3, 40);
        output = new JTextArea(6, 40);
        output.setEditable(false);

        encoderBox = new JComboBox<>(new String[]{
                "Morse Code", "Braille", "Secret Cipher"
        });

        compact = new JRadioButton("Compact", true);
        verbose = new JRadioButton("Verbose");

        encode = new JRadioButton("Encode", true);
        decode = new JRadioButton("Decode");

        ButtonGroup displayGroup = new ButtonGroup();
        displayGroup.add(compact);
        displayGroup.add(verbose);

        ButtonGroup operationGroup = new ButtonGroup();
        operationGroup.add(encode);
        operationGroup.add(decode);

        JButton transformBtn = new JButton("Transform");
        transformBtn.addActionListener(e -> transform());

        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> {
            input.setText("");
            output.setText("");
        });

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(e -> logout());

        
        frame.add(new JLabel("User: " + user.getName() + " | Role: " + user.getRole()));
        frame.add(new JLabel("Input Text:"));
        frame.add(new JScrollPane(input));
        frame.add(new JLabel("Writing System:"));
        frame.add(encoderBox);
        frame.add(new JLabel("Display Mode:"));
        frame.add(compact);
        frame.add(verbose);
        frame.add(new JLabel("Operation:"));
        frame.add(encode);
        frame.add(decode);
        frame.add(transformBtn);
        frame.add(clearBtn);
        frame.add(logoutBtn);
        frame.add(new JLabel("Output:"));
        frame.add(new JScrollPane(output));

        frame.setVisible(true);
    }

    private void transform() {
        boolean isDecoding = decode.isSelected();
        EncoderProxy proxy = new EncoderProxy(user);
        
        String encoderType = (String) encoderBox.getSelectedItem();
        EncoderPrototype encoder = proxy.getEncoder(encoderType, isDecoding);
        
        if (encoder == null) return;

        if (isDecoding) {
            StringBuilder sb = new StringBuilder();
            String text = input.getText().trim();
            if (text.isEmpty()) {
                output.setText("Please enter text to decode.");
                return;
            }
            
            String[] parts = text.split("\\s+");
            for (String part : parts) {
                char decodedChar = encoder.decode(part);
                sb.append(decodedChar);
            }
            output.setText(sb.toString());
            return;
        }

        
        DisplayStrategy strategy = compact.isSelected() 
                ? new CompactStrategy() 
                : new VerboseStrategy();

        String text = input.getText().trim();
        if (text.isEmpty()) {
            output.setText("Please enter text to encode.");
            return;
        }
        
        output.setText(strategy.display(text, encoder));
    }

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(frame,
            "Do you want to logout and exit the program?",
            "Confirm Logout",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(frame,
                "Thank you for using Smart Alternative Writing Systems!",
                "Goodbye",
                JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            User user = loginUser();
            if (user != null) {
                new MainGUI(user);
            } else {
                JOptionPane.showMessageDialog(null,
                    "Login cancelled. Application will now exit.",
                    "Exit",
                    JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
    }

    private static User loginUser() {
        
        String name = JOptionPane.showInputDialog(null, 
            "Please enter your name:", 
            "User Login", 
            JOptionPane.PLAIN_MESSAGE);
        
        
        if (name == null) {
            return null;
        }
        
       
        if (name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "Name cannot be empty. Please enter a valid name.",
                "Invalid Input",
                JOptionPane.WARNING_MESSAGE);
            return loginUser(); // Retry
        }

        
        String[] roles = {"Student", "Researcher"};
        String role = (String) JOptionPane.showInputDialog(null,
            "Please select your role:", 
            "Select Role",
            JOptionPane.QUESTION_MESSAGE,
            null, roles, roles[0]);
        
        
        if (role == null) {
            return null;
        }

        return new User(name.trim(), role);
    }
}


