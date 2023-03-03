import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
public class CoffeeMachineGUI extends JFrame {
//   Coffee ingredient
    static final int ESPRESSO_WATER_ML_PER_CUP = 250;
    static final int ESPRESSO_MILK_ML_PER_CUP = 0;
    static final int ESPRESSO_BEANS_G_PER_CUP = 16;
    static final int ESPRESSO_PRICE = 4;
    static final int LATTE_WATER_ML_PER_CUP = 350;
    static final int LATTE_MILK_ML_PER_CUP = 75;
    static final int LATTE_BEANS_G_PER_CUP = 20;
    static final int LATTE_PRICE = 7;
    static final int CAPPUCCINO_WATER_ML_PER_CUP = 200;
    static final int CAPPUCCINO_MILK_ML_PER_CUP = 100;
    static final int CAPPUCCINO_BEANS_G_PER_CUP = 12;
    static final int CAPPUCCINO_PRICE = 6;
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int cash;
    private String coffee;
    private String coffeeSize;

//    Var GUI
    private int checklatte;
    private int checkkapu;
    private int checkexpresso;
    private JPanel MainPanel1,MainPanel2,MainPanel3, MainPanel4,BackPanel,fillPanel1,fillPanel2,fillPanel3;
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
        BackPanel = new JPanel();
        c.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        //Panel 2 Choose Coffee

        /* All Image */
//        JLabel S = new JLabel( new ImageIcon(((new ImageIcon("S.png")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
//        JLabel M = new JLabel( new ImageIcon(((new ImageIcon("M.png")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
//        JLabel L = new JLabel( new ImageIcon(((new ImageIcon("L.png")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        File latteFile = new File("lat.png");
        File CapuccinoFile = new File("cap.png");
        File espressoFile = new File("es.png");
        File turFile = new File("t.png");
        System.out.println(latteFile.getAbsolutePath());
        JLabel latte = new JLabel( new ImageIcon(((new ImageIcon(latteFile.getAbsolutePath())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        JLabel capu = new JLabel( new ImageIcon(((new ImageIcon(CapuccinoFile.getAbsolutePath())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        JLabel esp = new JLabel( new ImageIcon(((new ImageIcon(espressoFile.getAbsolutePath())).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        ImageIcon icon = new ImageIcon(((new ImageIcon(turFile.getAbsolutePath()).getImage()).getScaledInstance( 60, 60, java.awt.Image.SCALE_SMOOTH)));
        JLabel label = new JLabel(icon,JLabel.CENTER);
        JLabel label1 = new JLabel("TAOJOM");


//        Create types of coffee label add them to the Jlabel Object

        backButton = new JButton("Back");
        backButton.setHorizontalAlignment(SwingConstants.LEFT);
        backButton.setVisible(false);
        BackPanel.setVisible(false);
        MainPanel4.setLayout(new BoxLayout(MainPanel4, BoxLayout.Y_AXIS));
        BackPanel.add(backButton);
        MainPanel4.add(label);
        MainPanel4.add(label1);
        MainPanel1.setBackground(color);
        MainPanel2.setBackground(color);
        MainPanel4.setBackground(color);
        BackPanel.setBackground(color);
        c.setBackground(color);
        c.add(BackPanel);
        c.add(MainPanel4);

//       add Pictures and back button to container

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
        button1 = new JButton("Buy");
        button2 = new JButton("Fill");
        MainPanel3.add(button1);
        MainPanel3.add(button2);
        MainPanel3.setBackground(color);
        c.add(MainPanel1);
        c.add(MainPanel2);
        c.add(MainPanel3);
        //Buy Select Size Menue
        JPanel SizePanel1 = new JPanel();
        SizePanel1.setBackground(color);
        //Show Label Menue
        JPanel Showingredient = new JPanel();
        JLabel typetext = new JLabel("CAPACAPCAP");
        JLabel watertext = new JLabel("Water Use: ");
        JLabel milktext = new JLabel("Milk Use: ");
        JLabel coffeetext = new JLabel("Coffee Use: ");
        JLabel cupstext = new JLabel("Cups Use: ");
        Showingredient.add(typetext);
        Showingredient.setVisible(false);
        c.add(Showingredient);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel1.setVisible(true);
                MainPanel2.setVisible(true);
                MainPanel3.setVisible(true);
                backButton.setVisible(false);
                BackPanel.setVisible(false);
                Showingredient.setVisible(false);

            }
        });
        //Event Handle
        check1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(check1.isSelected()){
                    check2.setSelected(false);
                    check3.setSelected(false);
                    setCoffee("LATTE");
                }
            }
        });
        check2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(check2.isSelected()){
                    check1.setSelected(false);
                    check3.setSelected(false);
                    setCoffee("CAPPUCCINO");

                }
            }
        });
        check3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(check3.isSelected()){
                    check1.setSelected(false);
                    check2.setSelected(false);
                    setCoffee("ESPRESSO");
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
                    backButton.setVisible(true);
                    BackPanel.setVisible(true);
                    SizePanel1.setVisible(true);


                }
                //User choose check2
                else if(check2.isSelected()){
//                    JOptionPane.showMessageDialog(null,"Buy CAPPUCCINO Successful!");
                    backButton.setVisible(true);
                    BackPanel.setVisible(true);
                    SizePanel1.setVisible(true);

                }
                //User choose check3
                else if (check3.isSelected()) {
//                    JOptionPane.showMessageDialog(null,"Buy ESPRESSO Successful!");
                    backButton.setVisible(true);
                    BackPanel.setVisible(true);
                    SizePanel1.setVisible(true);
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
                backButton.setVisible(true);
            }
        });




//        set imageicon to Jbutton
        JButton sizeS = new JButton();
        File sFile = new File("S.png");
        ImageIcon S = new ImageIcon(sFile.getAbsolutePath());
        Image sSizePicture = S.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        S.setImage(sSizePicture);
        sizeS.setIcon(S);
        sizeS.setBackground(color);
        Border emptyBorder = BorderFactory.createEmptyBorder();
        sizeS.setBorder(emptyBorder);
        sizeS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                JButton j = (JButton) e.getSource();
                j.setBackground(new Color(228, 210, 159, 255));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                sizeS.setContentAreaFilled(false);
                sizeS.setOpaque(true);
                sizeS.setBackground(new Color(234, 202, 113, 255));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                sizeS.setContentAreaFilled(true);
                sizeS.setBackground(new Color(234, 202, 113, 255));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                JButton j = (JButton) e.getSource();
                j.setBackground(color);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setCoffeeSize("S");
                Showingredient.setVisible(true);
                SizePanel1.setVisible(false);
            }
        });
        // add button sizeM
        JButton sizeM = new JButton();
        File mFile = new File("M.png");
        ImageIcon M = new ImageIcon(mFile.getAbsolutePath());
        Image mSizePicture = M.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        M.setImage(mSizePicture);
        sizeM.setIcon(M);
        sizeM.setBackground(color);
//        Border emptyBorder = BorderFactory.createEmptyBorder();
        sizeM.setBorder(emptyBorder);

        sizeM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                JButton j = (JButton) e.getSource();
                j.setBackground(new Color(228, 210, 159, 255));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                sizeM.setContentAreaFilled(false);
                sizeM.setOpaque(true);
                sizeM.setBackground(new Color(234, 202, 113, 255));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                sizeM.setContentAreaFilled(true);
                sizeM.setBackground(new Color(228, 210, 159, 255));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {

                JButton j = (JButton) e.getSource();
                j.setBackground(color);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setCoffeeSize("M");
                SizePanel1.setVisible(false);
            }

        });

        //add button sizeL
        JButton sizeL = new JButton();
        File lFile = new File("L.png");
        ImageIcon L = new ImageIcon(lFile.getAbsolutePath());
        Image lSizePicture = L.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        L.setImage(lSizePicture);
        sizeL.setIcon(L);
        sizeL.setBackground(color);
//        Border emptyBorder = BorderFactory.createEmptyBorder();
        sizeL.setBorder(emptyBorder);

        sizeL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                JButton j = (JButton) e.getSource();
                j.setBackground(new Color(228, 210, 159, 255));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                sizeL.setContentAreaFilled(false);
                sizeL.setOpaque(true);
                sizeL.setBackground(new Color(234, 202, 113, 255));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                sizeL.setContentAreaFilled(true);
                sizeL.setBackground(new Color(228, 210, 159, 255));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {

                JButton j = (JButton) e.getSource();
                j.setBackground(color);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setCoffeeSize("L");
                SizePanel1.setVisible(false);
            }

        });


        //image Size
        SizePanel1.add(sizeS);
        SizePanel1.add(sizeM);
        SizePanel1.add(sizeL);
        c.add(SizePanel1);
//      End Buy Select Size Menue

//     Fill Menue  ( water , milk , coffee , cups )
        fillPanel1 = new JPanel();
        fillPanel2 = new JPanel();
        fillPanel3 = new JPanel();
        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();
        JTextField textField3 = new JTextField();
        JLabel textlabel1 = new JLabel("water / ml : ");
        JLabel textlabel2 = new JLabel("milk / ml : ");
        JLabel textlabel3 = new JLabel("coffee / grams : ");
        JLabel textlabel4 = new JLabel("disposable cups : ");
        //     End Fill




        setSize(350,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public void setCoffee(String coffee){
        this.coffee = coffee;
    }
    public String getCoffee(){
        return this.coffee;
    }
    public void setCoffeeSize(String coffeeSize){
        this.coffeeSize = coffeeSize;
    }
    public String getCoffeeSize(){
        return this.coffeeSize;
    }
    public static void main(String[] args) {new CoffeeMachineGUI();}
}