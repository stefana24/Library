package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    //labels
    private JLabel bookLabel = new JLabel("Insert book info:");
    private JLabel bookTitleLabel = new JLabel("Title: ");
    private JLabel bookAuthorLabel = new JLabel("Author: ");
    private JLabel bookNoLabel = new JLabel("Number: ");
    //textfields
    private JTextField bookTitleTF = new JTextField(30);
    private JTextField bookAuthorTF = new JTextField(30);
    private JTextField bookNoTF = new JTextField(30);
    //buttons
    private JButton insertBookbtn = new JButton("Insert book");
    private JButton deleteBookbtn = new JButton("Delete book");
    private JButton updateBookbtn = new JButton("Update book");
    private JButton displayBookbtn = new JButton("Display books");

    private JTextArea displayField = new JTextArea(10,10);

    public void setDisplayField(JTextArea displayField){
        this.displayField = displayField;
    }

    public JTextArea getDisplayField() {
        return displayField;
    }


    public View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);

        bookTitleTF.setMaximumSize(bookTitleTF.getPreferredSize());
        bookAuthorTF.setMaximumSize(bookAuthorTF.getPreferredSize());
        bookNoTF.setMaximumSize(bookNoTF.getPreferredSize());


        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.add(panel);

        JPanel pStDr = new JPanel();
        JPanel pVertSt = new JPanel();
        JPanel pVertDr = new JPanel();
        JPanel pOrizontal = new JPanel();
        JPanel displayResultPanel = new JPanel();

        pStDr.setLayout(new BoxLayout(pStDr, BoxLayout.X_AXIS));
        pVertSt.setLayout(new BoxLayout(pVertSt, BoxLayout.Y_AXIS));
        pVertDr.setLayout(new BoxLayout(pVertDr, BoxLayout.Y_AXIS));
        pOrizontal.setLayout(new BoxLayout(pOrizontal, BoxLayout.X_AXIS));
        displayResultPanel.setLayout(new BoxLayout(displayResultPanel, BoxLayout.X_AXIS));



        pStDr.add(pVertSt);
        pStDr.add(Box.createRigidArea(new Dimension(20, 0)));

        pStDr.add(pVertDr);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        panel.add(bookLabel);

        bookLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(pStDr);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(pOrizontal);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(displayResultPanel);

        pVertSt.add(bookTitleLabel);
        pVertSt.add(Box.createRigidArea(new Dimension(0, 20)));
        pVertSt.add(bookAuthorLabel);
        pVertSt.add(Box.createRigidArea(new Dimension(0, 20)));
        pVertSt.add(bookNoLabel);

        pVertDr.add(bookTitleTF);
        pVertDr.add(Box.createRigidArea(new Dimension(0, 20)));
        pVertDr.add(bookAuthorTF);
        pVertDr.add(Box.createRigidArea(new Dimension(0, 20)));
        pVertDr.add(bookNoTF);


        pOrizontal.add(insertBookbtn);
        pOrizontal.add(Box.createRigidArea(new Dimension(20, 0)));
        pOrizontal.add(deleteBookbtn);
        pOrizontal.add(Box.createRigidArea(new Dimension(20, 0)));
        pOrizontal.add(updateBookbtn);
        pOrizontal.add(Box.createRigidArea(new Dimension(20, 0)));
        pOrizontal.add(displayBookbtn);


        displayResultPanel.add(displayField);
        displayField.setMargin( new Insets(10,10,10,10) );


        this.setTitle("Book");
        this.setVisible(true);
    }

    public JTextField getBookTitleTF() {
        return bookTitleTF;
    }

    public JTextField getBookAuthorTF() {
        return bookAuthorTF;
    }

    public JTextField getBookNoTF() {
        return bookNoTF;
    }

    public JButton getInsertBookbtn() {
        return insertBookbtn;
    }

    public JButton getDeleteBookbtn() {
        return deleteBookbtn;
    }

    public JButton getUpdateBookbtn() {
        return updateBookbtn;
    }

    public JButton getDisplayBookbtn() {
        return displayBookbtn;
    }

    public void addBtnBookListener(ActionListener l) {
        insertBookbtn.addActionListener(l);
    }

    public void deleteBtnBookListener(ActionListener l) {
        deleteBookbtn.addActionListener(l);
    }

    public void updateBtnBookListener(ActionListener l) {
        updateBookbtn.addActionListener(l);
    }

    public void displayBtnBookListener(ActionListener l) {
        displayBookbtn.addActionListener(l);
    }


}
