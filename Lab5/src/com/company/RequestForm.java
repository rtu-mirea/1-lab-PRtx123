package com.company;

import javax.swing.*;
import java.awt.event.*;

public class RequestForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonCount;
    private JButton buttonCancel;
    private JButton setRequestButton;
    private JTextField placeTextField;
    private JTextField monthTextField;
    private JTextField onTextField;
    private JTextField forTextField;
    private JTextField countTextField;
    private JLabel label1;
    private Integer requestsCount = 0;
    private int setRequestsCount = 1;
    private static Leader curLeader;
    public RequestForm(Leader curLeader) {
        this.curLeader = curLeader;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCount);

        buttonCount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setCount();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        setRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setRequest();
            }
        });
    }

    private void setCount() {
        requestsCount = Integer.parseInt(countTextField.getText());
        setRequestsCount = 1;
        label1.setText("Введите " + requestsCount + " встреч");
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void setRequest(){
        if (setRequestsCount != requestsCount){
            var place = placeTextField.getText();
            var month = Integer.parseInt(monthTextField.getText());
            var on = Integer.parseInt(onTextField.getText());
            var to = Integer.parseInt(forTextField.getText());
            curLeader.addRequest(place, month, on, to);
            label1.setText("Введите " + (requestsCount-setRequestsCount) + " встреч");
            setRequestsCount++;
        }
        else {
            label1.setText("Все встречи заполнены");
        }
    }

    public static void main(Leader curLeader) {
        RequestForm dialog = new RequestForm(curLeader);
        dialog.pack();
        dialog.setVisible(true);
        //System.exit(0);
    }
}