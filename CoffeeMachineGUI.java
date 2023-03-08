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

    static final int LATTE_WATER_ML_PER_CUP = 350;
    static final int LATTE_MILK_ML_PER_CUP = 75;
    static final int LATTE_BEANS_G_PER_CUP = 20;

    static final int CAPPUCCINO_WATER_ML_PER_CUP = 200;
    static final int CAPPUCCINO_MILK_ML_PER_CUP = 100;
    static final int CAPPUCCINO_BEANS_G_PER_CUP = 12;

    private int count = 0;
    private int sizecount =0;
    private int water = 1000;
    private int milk = 500;
    private int beans= 300;
    private int cups = 30;

    private float setmon = 0;
    private float moneyInMachine;
    private float cash;
    private float sizeprice;
    private float price;
    private String coffee;
    private String coffeeSize;

    //    Var GUI
    private JPanel MainPanel1,MainPanel2,MainPanel3, MainPanel4,BackPanel,fillPanel1,fillPanel2,fillPanel3;
    private JButton button1,button2,backButton;
    private JCheckBox check1, check2, check3;

    Container c = getContentPane();
    public CoffeeMachineGUI(){
        //GUI Setup
        super("CoffeeMachine");
//       main statement
        Color color = new Color(226,218,196,255);
        MainPanel1 = new JPanel();
        MainPanel2 = new JPanel();
        MainPanel3 = new JPanel();
        MainPanel4 = new JPanel();
        BackPanel = new JPanel();
        c.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        //Panel 2 Choose Coffee

        /* All Image */


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

        backButton = new JButton("Back");;
        backButton.setVisible(false);
        BackPanel.setVisible(false);
        MainPanel4.setLayout(new BoxLayout(MainPanel4, BoxLayout.Y_AXIS));
        BackPanel.add(backButton);
        BackPanel.setBounds(0,0,0,0);
        MainPanel4.add(label);
        MainPanel4.add(label1);
        MainPanel1.setBackground(color);
        MainPanel2.setBackground(color);
        MainPanel4.setBackground(color);
//        BackPanel.setBackground(color);
        c.setBackground(color);
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
        //Size Coffee
        JButton sizeS = new JButton();
        JButton sizeL = new JButton();
        JButton sizeM = new JButton();
        //Show Label Menue
        JPanel priceMain = new JPanel();
        JPanel priceShow = new JPanel();
        JPanel buyCoffeeButton = new JPanel();
        priceShow.setLayout(new BoxLayout(priceShow ,BoxLayout.Y_AXIS));
        priceMain.setLayout(new BoxLayout(priceMain ,BoxLayout.X_AXIS));
        JButton buyButton = new JButton("BUY");
        JLabel priceText = new JLabel("Price");
        JLabel price = new JLabel("฿ " + getPrice());
        priceShow.add(priceText);
        priceShow.add(Box.createRigidArea(new Dimension(0,15)));
        priceShow.add(price);
        buyCoffeeButton.add(buyButton);
        priceMain.add(priceShow);
        priceMain.add(Box.createRigidArea(new Dimension(210,0)));
        priceMain.add(buyCoffeeButton);
        priceShow.setBackground(color);
        buyCoffeeButton.setBackground(color);
        priceMain.setBackground(color);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel1.setVisible(true);
                MainPanel2.setVisible(true);
                MainPanel3.setVisible(true);
                backButton.setVisible(false);
                BackPanel.setVisible(false);
//                fillPanel1.setVisible(false);
                sizeS.setBackground(color);
                sizeM.setBackground(color);
                sizeL.setBackground(color);
                setSizePrice(0);
                setPrice(0);
                sizecount = 0;
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
                    setPrice(45);
                    price.setText("฿ " + getPrice() );
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
                    setPrice(50);
                    price.setText("฿ " + getPrice() );
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
                    setPrice(60);
                    price.setText("฿ " + getPrice() );
                }
            }
        });
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f=new JFrame();
                float change;
                try {
                    if(water < LATTE_WATER_ML_PER_CUP || water < CAPPUCCINO_WATER_ML_PER_CUP || water < ESPRESSO_WATER_ML_PER_CUP){
                        JOptionPane.showMessageDialog(f,"Not enough WATER ,Please Fill!","Alert",JOptionPane.WARNING_MESSAGE);
                    }else if(milk < LATTE_MILK_ML_PER_CUP || milk < CAPPUCCINO_MILK_ML_PER_CUP || milk < ESPRESSO_MILK_ML_PER_CUP){
                        JOptionPane.showMessageDialog(f,"Not enough MILK ,Please Fill!","Alert",JOptionPane.WARNING_MESSAGE);
                    }else if(beans < LATTE_BEANS_G_PER_CUP || beans < CAPPUCCINO_BEANS_G_PER_CUP || beans < ESPRESSO_BEANS_G_PER_CUP){
                        JOptionPane.showMessageDialog(f,"Not enough BEANS ,Please Fill!","Alert",JOptionPane.WARNING_MESSAGE);
                    }else{
                        String input = JOptionPane.showInputDialog("ENTER MONEY");
                        setCash(Integer.parseInt(input));
                        change = getCash() - getPrice();
                        setmon += getPrice();
                        setMachineCash(setmon);
                        if(getCash() - getPrice() < 0){
                            JOptionPane.showMessageDialog(f,"Not enough Money.","Alert",JOptionPane.WARNING_MESSAGE);
                        }else{
                            setCash(getPrice() - getCash());
                            if(getCash() - getPrice()  != 0){
                                JOptionPane.showMessageDialog(f,"Change: " + change);
                            }
                            switch (getCoffee()){
                                case "LATTE":
                                    water -= LATTE_WATER_ML_PER_CUP;
                                    milk -= LATTE_MILK_ML_PER_CUP;
                                    beans -= LATTE_BEANS_G_PER_CUP;
                                    break;
                                case "CAPPUCCINO":
                                    water -= CAPPUCCINO_WATER_ML_PER_CUP;
                                    milk -= CAPPUCCINO_MILK_ML_PER_CUP;
                                    beans -= CAPPUCCINO_BEANS_G_PER_CUP;
                                    break;
                                case "ESPRESSO":
                                    water -= ESPRESSO_WATER_ML_PER_CUP;
                                    milk -= ESPRESSO_MILK_ML_PER_CUP;
                                    beans -= ESPRESSO_BEANS_G_PER_CUP;
                                    break;
                                default:
                                    break;
                            }
                            JOptionPane.showMessageDialog(f, "Buy "+ getCoffee() + " Size" + getCoffeeSize() +" Successful", "Successes", JOptionPane.INFORMATION_MESSAGE);
                            System.out.println("Money in CoffeeMachine:" +getMachineCash());
                            System.out.println("water: " + water);
                            System.out.println("milk: " + milk);
                            System.out.println("beans: " + beans);
                        }
                    }
                }catch (Exception ex){
                        JOptionPane.showMessageDialog(f,"Invalid Input","Error",JOptionPane.ERROR_MESSAGE);
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
//                    JOptionPane.showMessageDialog(null,"Please Choose Coffee!");
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
                SizePanel1.setVisible(false);
                priceMain.setVisible(false);
                //have to set this back button at the bottom of the page
//                backButton.setVisible(true);
                BackPanel.setVisible(true);
                check1.setSelected(false);
                check2.setSelected(false);
                check3.setSelected(false);
                fillPanel1.setVisible(true);
                backButton.setVisible(true);




                setSizePrice(0) ;
                setPrice(0);
                sizecount = 0;
            }
        });


//        set imageicon to Jbutton
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

            //            @Override
//            public void mouseReleased(MouseEvent e) {
//                sizeS.setContentAreaFilled(true);
//                sizeS.setBackground(new Color(228, 210, 159, 255));
//            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                JButton j = (JButton) e.getSource();
                sizeM.setBackground(color);
                sizeL.setBackground(color);
                if(count >= 1 ){
                    sizeS.setBackground(new Color(234, 202, 113, 255));
                }else {
                    sizeS.setBackground(color);
                }
                count = 0;
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(sizecount == 1){
                    setPrice(getPrice()-getSizePrice());
                }
                sizecount = 1;
                count += 1;
                sizeS.setBackground(new Color(234, 202, 113, 255));
                sizeM.setBackground(color);
                sizeL.setBackground(color);
                setCoffeeSize("S");
                setSizePrice(0);
                price.setText("฿ " + getPrice());
            }
        });
        // add button sizeM
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

            //            @Override
//            public void mouseReleased(MouseEvent e) {
//                sizeM.setContentAreaFilled(true);
//                sizeM.setBackground(new Color(228, 210, 159, 255));
//            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                JButton j = (JButton) e.getSource();
                sizeS.setBackground(color);
                sizeL.setBackground(color);
                if(count >= 1){
                    sizeM.setBackground(new Color(234, 202, 113, 255));
                }else {
                    sizeM.setBackground(color);
                }
                count = 0;
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(sizecount == 1){
                    setPrice(getPrice()-getSizePrice());
                }
                sizecount = 1;
                count += 1;
                sizeS.setBackground(color);
                sizeM.setBackground(new Color(234, 202, 113, 255));
                sizeL.setBackground(color);
                setCoffeeSize("M");
                setSizePrice(5);
                setPrice(getPrice()+getSizePrice());
                price.setText("฿ " + getPrice() );
            }

        });

        //add button sizeL
        File lFile = new File("L.png");
        ImageIcon L = new ImageIcon(lFile.getAbsolutePath());
        Image lSizePicture = L.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        L.setImage(lSizePicture);
        sizeL.setIcon(L);
        sizeL.setBackground(color);
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
            public void mouseExited(java.awt.event.MouseEvent e) {
                JButton j = (JButton) e.getSource();
                sizeS.setBackground(color);
                sizeM.setBackground(color);
                if(count >= 1 ){
                    sizeL.setBackground(new Color(234, 202, 113, 255));
                }else {
                    sizeL.setBackground(color);
                }
                count = 0;
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(sizecount == 1){
                    setPrice(getPrice()-getSizePrice());
                }
                sizecount = 1;
                count += 1;
                sizeS.setBackground(color);
                sizeM.setBackground(color);
                sizeL.setBackground(new Color(234, 202, 113, 255));
                setCoffeeSize("L");
                setSizePrice(10);
                setPrice(getPrice()+getSizePrice());
                price.setText("฿ " + getPrice() );
            }

        });


        //image Size
        SizePanel1.add(sizeS);
        SizePanel1.add(sizeM);
        SizePanel1.add(sizeL);
        BackPanel.setPreferredSize(new Dimension(350, 35));
        BackPanel.setBackground(color);
//        c.add(fillPanel1);
//        c.add(SizePanel1);
//        c.add(BackPanel);
//        c.add(priceMain);
//      End Buy Select Size Menue

//     Fill Menue  ( water , milk , coffee , cups )
        fillPanel1 = new JPanel();
        fillPanel2 = new JPanel();
        fillPanel3 = new JPanel();
        JLabel textlabel1 = new JLabel("water / ml : ");
        JLabel textlabel2 = new JLabel("milk / ml : ");
        JLabel textlabel3 = new JLabel("coffee / grams : ");
        JLabel textlabel4 = new JLabel("disposable cups : ");
        fillPanel1.setLayout(new BoxLayout(fillPanel1,BoxLayout.Y_AXIS));

        fillPanel1.add(textlabel1);fillPanel1.add(textlabel2);
        fillPanel1.add(textlabel3);fillPanel1.add(textlabel4);


        //     End Fill

        c.add(fillPanel1);
        c.add(SizePanel1);
        c.add(BackPanel);
        c.add(priceMain);


        setSize(350,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public void setMachineCash(float cash){
        this.moneyInMachine = cash;
    }
    public float getMachineCash(){
        return this.moneyInMachine;
    }
    public void setCash(float cash){
        this.cash = cash;
    }
    public float getCash(){
        return this.cash;
    }
    public void setSizePrice(float size){
        this.sizeprice = size;
    }
    public float getSizePrice(){
        return this.sizeprice ;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return this.price;
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