package net.company.view;

import net.company.controller.Controller;
import net.company.model.Model;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class UserView extends JFrame {
    private JTextArea text;
    private JButton sendButton;
    private JLabel info;
    private Controller controller;

    public UserView(Controller controller){
        this.controller = controller;
    }

    public void init(){
        setSize(400,300);
        text = new JTextArea();
        sendButton = new JButton("Sent");
        info = new JLabel("Info");
        add(text, BorderLayout.CENTER);
        add(sendButton, BorderLayout.SOUTH);
        add(info, BorderLayout.NORTH);

        sendButton.addActionListener(e -> {

            int pin;
            String textPin = this.text.getText();
            text.setText("");
            try {
                pin = Integer.parseInt(textPin);
                info.setText("Waiting.....");
                Thread thread = new Thread(() -> {
                    sendButton.setEnabled(false);
                    boolean result = controller.checkPin(pin);
                    String resultMessage;
                    if (result) {
                        resultMessage = "Right pin";
                    } else {
                        resultMessage = "Wrong pin";
                    }
                    info.setText(resultMessage);
                    sendButton.setEnabled(true);
                });
                thread.start();
            } catch (ClassCastException ex){
                info.setText("Only numbers allowed!!!");
            }
        });
        setVisible(true);
    }
}
