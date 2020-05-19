package login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Login {

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    new Login().createComponents();
                }
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void openBook() {
        JFrame j = new JFrame();
        JPanel p = new JPanel();
        j.setLayout(new GridLayout(1, 2, 2, 2));
        j.setBounds(0, 0, 650, 300);
        p.setBounds(j.getBounds());
        j.add(p);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        
        JComboBox cb = new JComboBox();
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                JComboBox cb = (JComboBox) evt.getSource();

                Object item = evt.getItem();

                if (evt.getStateChange() == ItemEvent.SELECTED) {
                  // Item was just selected
                  if(((String)item).equals("Chapter 1")) {
                    openChapter1();
                  }
                  if(((String)item).equals("Chapter 2")) {
                    openChapter2();
                  }
                  if(((String)item).equals("Chapter 3")) {
                    openChapter3();
                  }
                } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                  // Item is no longer selected
                }
            }
        });
        cb.addItem("Chapter 1");
        cb.addItem("Chapter 2");
        cb.addItem("Chapter 3");
        cb.setSize(100, 30);
        p.add(cb);

        jt.setSize(440, 500);
        p.add(jt);
        
        openFileDefaultOpen();
        
        j.pack();
    }
    
    private void openFileDefaultOpen() {
        try {
          File myObj = new File("newfile");
          Scanner myReader = new Scanner(myObj);
          jt.setText("");
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            jt.setText(jt.getText() + data);
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }

    public void openChapter1() {
        try {
          File myObj = new File("newfile");
          Scanner myReader = new Scanner(myObj);
          jt.setText("");
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            jt.setText(jt.getText() + data);
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
    
    public void openChapter2() {
        try {
          File myObj = new File("newfile1");
          Scanner myReader = new Scanner(myObj);
          jt.setText("");
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            jt.setText(jt.getText() + data);
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }

    public void openChapter3() {
        try {
          File myObj = new File("newfile2");
          Scanner myReader = new Scanner(myObj);
          jt.setText("");
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            jt.setText(jt.getText() + data);
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }

    TextArea jt = new TextArea();
    //Step1 - Declaring variables
    private JFrame myFrame;
    // Added by me
    private JPanel contentPane;
    private JPanel myPanel;
    private JLabel username=null;
    private JLabel password=null;
    private JTextField usernameField=null;
    private JPasswordField passwordField=null;
    private Color myColor=new Color(200, 102, 204);
    private Font myFont11=new Font("Tahoma", 1, 11);
    private Font myFont12bold=new Font("Tahoma", Font.BOLD, 12);
    private Font myFont11bold=new Font("Tahoma", Font.BOLD, 11);

    //Step2 - Creating Components
    public void createComponents() {

        contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBorder(BorderFactory.createTitledBorder("Martin Luther"));

        username=new JLabel("Username");
        username.setLabelFor(usernameField);
        username.setFont(myFont11);
        username.setForeground(Color.white);
        password=new JLabel("Password");
        password.setLabelFor(passwordField);
        password.setFont(myFont11);
        password.setForeground(Color.white);
        usernameField=new JTextField(10);
        usernameField.setBorder(new LineBorder(null, 0, false));
        passwordField=new JPasswordField(10);
        passwordField.setBorder(new LineBorder(null, 0, false));
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = "berto";
                String password = "berto123";
                if(usernameField.getText().equals(username) &&
                        passwordField.getText().equals(password)) {
                    openBook();
                }
            }
        });

        //Panel
        myPanel=new JPanel();
        myPanel.setOpaque(true);
        myPanel.setBorder(BorderFactory.createTitledBorder("Login"));
        myPanel.setBackground(myColor);
        myPanel.setLayout(new GridLayout(2, 2, 2, 2));
        myPanel.add(username);
        myPanel.add(usernameField);
        myPanel.add(password);
        myPanel.add(passwordField);
        //----------------------------------------------------------
        contentPane.add(myPanel);

        myFrame=new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //myFrame.setPreferredSize(new Dimension(400,300));//width:400px, height:300px
        myFrame.setLocationRelativeTo(null);//to show at center of screen
        myFrame.setTitle("Martin Luther");
        //myFrame.add(myPanel);
        myFrame.setContentPane(contentPane);
        myFrame.pack();//this alone will not give the frame a size
        myFrame.setVisible(true);
    }   
}