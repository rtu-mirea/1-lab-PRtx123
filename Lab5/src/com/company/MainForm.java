package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JButton SignIn;
    private JButton Register;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton saveUsersButton;
    private JButton findButton;
    private JButton saveButton;
    private JButton loadButton;
    private SummitSystem summitSystem;
    private Leader currentUser;


    public MainForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(SignIn);

        SignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signIn();
            }
        });

        Register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        saveUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, SummitSystem.processRequests().toString());
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SerializableFile fileSave = new SerializableFile("users.dat");
                    fileSave.write(SummitSystem.getUsers());
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Ошибка с файлом");
                }

            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SummitSystem.loadUsers("users.dat");
                    JOptionPane.showMessageDialog(null,"Вы успешно загрузили пользователей");
                }
                catch (IOException ex){
                    JOptionPane.showMessageDialog(null, "Ошибка с файлом");
                }
            }
        });
    }

    private void signIn() {
        var login = textField1.getText();
        var password = new String(passwordField1.getPassword());
        try {
            currentUser = SummitSystem.findUser(login, password);
        }
        catch (RuntimeException e){
            JOptionPane.showMessageDialog(null, "Неверный логин или пароль");
        }
    }

    private void register() {
        var login = textField1.getText();
        var password = passwordField1.getPassword().toString();
        var name = textField2.getText();
        var tempLeader = new Leader(name, login, password);
        RequestForm.main(tempLeader);
        SummitSystem.addUser(tempLeader);
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
