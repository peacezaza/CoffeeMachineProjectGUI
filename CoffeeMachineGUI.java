import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CoffeeMachineGUI extends JFrame {
    private int checklatte;
    private int checkkapu;
    private int checkexpresso;
    private JPanel MainPanel1,MainPanel2,MainPanel3, MainPanel4,fillPanel1,fillPanel2,fillPanel3;
    private JButton button1,button2,backButton;
    private JCheckBox check1, check2, check3;
    Container c = getContentPane();
    public CoffeeMachineGUI(){
        //GUI Setup
        super("CoffeeMachine");
//        Container c = getContentPane();
        //main statement
        Color color = new Color(226,218,196,255);
        MainPanel1 = new JPanel();
        MainPanel2 = new JPanel();
        MainPanel3 = new JPanel();
        MainPanel4 = new JPanel();
        c.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        //Panel 2 Choose Coffee

        /* All Image */
//        JLabel S = new JLabel( new ImageIcon(((new ImageIcon("S.png")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        JLabel M = new JLabel( new ImageIcon(((new ImageIcon("M.png")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        JLabel L = new JLabel( new ImageIcon(((new ImageIcon("L.png")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        JLabel latte = new JLabel( new ImageIcon(((new ImageIcon("latte.png")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        JLabel capu = new JLabel( new ImageIcon(((new ImageIcon("Cappuccino.png")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        JLabel esp = new JLabel( new ImageIcon(((new ImageIcon("espresso.png")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        ImageIcon icon = new ImageIcon(((new ImageIcon("tur.png").getImage()).getScaledInstance( 70, 70, java.awt.Image.SCALE_SMOOTH)));
        JLabel label = new JLabel("TAOJOM", icon,JLabel.CENTER);


//        Create types of coffee label add them to the Jlabel Object



        backButton = new JButton("Back");
        backButton.setHorizontalAlignment(SwingConstants.LEFT);
        backButton.setVisible(false);
        MainPanel4.add(backButton);
        MainPanel4.add(label);
        MainPanel1.setBackground(color);
        MainPanel2.setBackground(color);
        MainPanel4.setBackground(color);
//        MainPanel4.setLayout(new BorderLayout());
        c.setBackground(color);


//        backButton = new JButton("Back");



        c.add(MainPanel4);


//        add Pictures and back button to container

        // Panel1 Coffee image
        MainPanel1.add(latte);
        MainPanel1.add(capu);
        MainPanel1.add(esp);
        //Panel 2 CheckBox
        check1 = new JCheckBox("LATTE");
        check2 = new JCheckBox("CAPPUCCINO");
        check3 = new JCheckBox("ESPRESSO");
        check1.setBackground(color);
        check2.setBackground(color);
        check3.setBackground(color);
        MainPanel2.add(check1);
        MainPanel2.add(check2);
        MainPanel2.add(check3);
        //Panel 3 BUY/FILL Button
        button1 = new JButton("BUY");
        button2 = new JButton("Fill");
        MainPanel3.add(button1);
        MainPanel3.add(button2);
        MainPanel3.setBackground(color);
        c.add(MainPanel1);
        c.add(MainPanel2);
        c.add(MainPanel3);
 //       Buy Select Size Menue
        JPanel SizePanel1 = new JPanel();
        JPanel SizePanel2 = new JPanel();
        JPanel SizePanel3 = new JPanel();
        SizePanel1.setBackground(color);


//        set imageicon to jbutton
        JButton sizeS = new JButton();

        ImageIcon S = new ImageIcon("S.png");
        Image sSizePicture = S.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        S.setImage(sSizePicture);
        sizeS.setIcon(S);
        sizeS.setBackground(color);
        sizeS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                JButton j = (JButton) e.getSource();
                j.setBackground(new Color(226,218,196,255));
            }
//            public void mouseExited(java.awt.event.MouseEvent e) {
//                JButton j = (JButton) e.getSource();
//                j.setBackground(Color.GREEN);
//            }
        });

        //image Size
        SizePanel1.add(sizeS);
        SizePanel1.add(M);
        SizePanel1.add(L);
//      End Buy Select Size Menue

 //     Fill Menue
        fillPanel1 = new JPanel();
        fillPanel2 = new JPanel();
        fillPanel3 = new JPanel();
        JLabel textlabel1 = new JLabel();
        JLabel textlabel2 = new JLabel();
        JLabel textlabel3 = new JLabel();
        JLabel textlabel4 = new JLabel();
 //     End Fill


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel1.setVisible(true);
                MainPanel2.setVisible(true);
                MainPanel3.setVisible(true);
                backButton.setVisible(false);
            }
        });
        //Event Handle
        check1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(check1.isSelected()){
                    check2.setSelected(false);
                    check3.setSelected(false);


                }
            }
        });
        check2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(check2.isSelected()){
                    check1.setSelected(false);
                    check3.setSelected(false);

                }
            }
        });
        check3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(check3.isSelected()){
                        check1.setSelected(false);
                        check2.setSelected(false);

                    }
                }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(check1.isSelected() || check2.isSelected() || check3.isSelected()){
                    MainPanel1.setVisible(false);
                    MainPanel2.setVisible(false);
                    MainPanel3.setVisible(false);
                }
                //User not Choose
                if(!check1.isSelected() && !check2.isSelected() && !check3.isSelected()){
                    JOptionPane.showMessageDialog(null,"Please Choose Coffee!");
                    MainPanel1.setVisible(true);
                    MainPanel2.setVisible(true);
                    MainPanel3.setVisible(true);
                }
                //User choose check1
                else if(check1.isSelected() ){
//                    JOptionPane.showMessageDialog(null,"Buy LATTE Successful!");
                    String coffee = "LATTE";
                    c.add(SizePanel1);
                    backButton.setVisible(true);
                    buyCoffee();


                }
                //User choose check2
                else if(check2.isSelected()){
//                    JOptionPane.showMessageDialog(null,"Buy CAPPUCCINO Successful!");
                    String coffee = "CAPPUCCINO";
                    c.add(SizePanel1);
                    backButton.setVisible(true);

                }
                //User choose check3
                else if (check3.isSelected()) {
//                    JOptionPane.showMessageDialog(null,"Buy ESPRESSO Successful!");
                    String coffee = "ESPRESSO";
                    c.add(SizePanel1);
                    backButton.setVisible(true);
                }

            }
        });
        //Event for button Fill
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel1.setVisible(false);
                MainPanel2.setVisible(false);
                MainPanel3.setVisible(false);
            }
        });



        setSize(350, 370);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void buyCoffee(){

    }

    public static void main(String[] args) {new CoffeeMachineGUI();}
}
