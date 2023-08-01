

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.regex.Pattern;


public class Registrationform{
    public static void main(String args[])
    {




        Frame f =new Frame();
       f.setBackground(Color.lightGray);
        f.setSize(700,500);
        f.setTitle("form validation");
        f.setLayout(null);
        f.setVisible(true);

        Label first = new Label("first name");
        first.setBounds(20,50,80,20);
        f.add(first);

        TextField firstt=new TextField();
        firstt.setBounds(120,50,100,20);
        f.add(firstt);

        Label firstl = new Label("only characters allowed");
        firstl.setBounds(230,50,150,20);
        f.add(firstl);
        firstl.setVisible(false);



        firstt.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e) {
                String s1=firstt.getText();
                String nameregex ="^[A-Za-z]*$";
                if(!Pattern.matches(nameregex,s1))
                {
                    firstl.setVisible(true);
                } else{
                   firstl.setVisible(false);
                }

            }
        });


        Label second = new Label("last name");
        second.setBounds(20,90,80,20);
        f.add(second);

        TextField secondt=new TextField();
        secondt.setBounds(120,90,100,20);
        f.add(secondt);

        Label secondl = new Label("only characters allowed");
        secondl.setBounds(230,90,150,20);
        f.add(secondl);
        secondl.setVisible(false);

        secondt.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e) {
                String s1=secondt.getText();
                String nameregex ="^[A-Za-z]*$";
                if(!Pattern.matches(nameregex,s1))
                {
                   secondl.setVisible(true);
                } else {
                    secondl.setVisible(false);
                }

            }

        });



        Label third = new Label("email");
        third.setBounds(20,130,100,20);
        f.add(third);

        TextField thirdt=new TextField();
        thirdt.setBounds(120,130,100,20);
        f.add(thirdt);

        Label thirdl = new Label("Invalid Mail");
        thirdl.setBounds(230,130,150,20);
        f.add(thirdl);
        thirdl.setVisible(false);
        thirdt.addTextListener(new TextListener()
        {
            public void textValueChanged(TextEvent e) {
                String s1=thirdt.getText();
                String nameregex =   "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

                if(!Pattern.matches(nameregex,s1))
                {
                    thirdl.setVisible(true);
                } else {
                    thirdl.setVisible(false);
                }

            }

        });


        Label fourth = new Label("password");
        fourth.setBounds(20,170,100,20);
        f.add(fourth);

        TextField fourtht=new TextField();
        fourtht.setBounds(120,170,100,20);
        f.add(fourtht);

        Label fourthl = new Label("Please enter a valid password");
        fourthl.setBounds(230,170,200,20);
        f.add(fourthl);
        fourthl.setVisible(false);

        fourtht.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                String s1 = fourtht.getText();
                String nameregex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=.*[a-zA-Z\\d@#$%^&+=!]).{8,}$";
                if(!Pattern.matches(nameregex,s1)){
                    fourthl.setVisible(true);
                } else {
                    fourthl.setVisible(false);
                }
            }
        });

        Label check = new Label("Gender");
        check.setBounds(20,220,100,20);
        f.add(check);
        CheckboxGroup cbg = new CheckboxGroup();
        Checkbox checkBox1 = new Checkbox("Male",cbg, false);
        checkBox1.setBounds(120,210, 100,20);
        Checkbox checkBox2 = new Checkbox("Female", cbg,false);
        checkBox2.setBounds(120,230, 100,20);
        f.add(checkBox1);
        f.add(checkBox2);


        Label fifth = new Label("age");
        fifth.setBounds(20,270,100,20);
        f.add(fifth);
        TextField fiftht=new TextField();
        fiftht.setBounds(120,270,100,20);
        f.add(fiftht);

        Label fifthl = new Label("Only numbers");
        fifthl.setBounds(230,270,200,20);
        f.add(fifthl);
        fifthl.setVisible(false);
        fiftht.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                String s1 = fiftht.getText();
                String nameregex = "^\\d+$";
                if(!Pattern.matches(nameregex,s1)){
                    fifthl.setVisible(true);
                } else {
                    fifthl.setVisible(false);
                }
            }
        });

        Label sixth = new Label("phone");
        sixth.setBounds(20,310,100,20);
        f.add(sixth);
        TextField sixtht=new TextField();
        sixtht.setBounds(120,310,100,20);
        f.add(sixtht);

        Label sixthl = new Label("Only numbers");
        sixthl.setBounds(230,310,200,20);
        f.add(sixthl);
        sixthl.setVisible(false);

        sixtht.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                String s1 = sixtht.getText();
                String nameregex = "^\\d+$";
                if(!Pattern.matches(nameregex,s1)){
                    sixthl.setVisible(true);
                } else {
                    sixthl.setVisible(false);
                }
            }
        });
        Label[] userDetailsLabels = new Label[6];


        Button btn = new Button("submit");
        btn.setBounds(80,340,100,30);
        f.add(btn);

        Label inform = new Label("Please enter valid details");
        inform.setBounds(80,390,200,40);
        f.add(inform);
        inform.setVisible(false);






         btn.addActionListener(e ->{
             String fname = firstt.getText();
             String sname = secondt.getText();
             String email = thirdt.getText();
             String password = fourtht.getText();
             String gender = (checkBox1.getState() ? "Male" : "Female");
             String age = fiftht.getText();
             String pno = sixtht.getText();






if (!isValidForm(fname,sname,email,password,age,pno)) {


    Label alert = new Label("Enter valid credentails");
    alert.setBounds(330,150,200,20);
    f.add(alert);



            alert.setVisible(true);



    } else if (isValidForm(fname,sname,email,password,age,pno)){



    onvalid(fname,sname,email,password,age,pno);









}

         });




    }
    public static boolean isValidForm(String firstName, String lastName, String email, String password , String age, String phone) {
        String nameRegex = "^[A-Za-z]*$";
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=.*[a-zA-Z\\d@#$%^&+=!]).{8,}$";
        String ageRegex = "^\\d+$";
        String phoneregex = "^\\d+$";

        if ((!Pattern.matches(nameRegex,firstName)) || (!Pattern.matches(nameRegex, lastName)) || (!Pattern.matches(emailRegex, email)) ||(!Pattern.matches(passwordRegex, password))||(!Pattern.matches(ageRegex , age)) || (!Pattern.matches(phoneregex, phone))){
            return false;

        } else {
            return true;
        }


    }

    public static void onvalid(String fname,String sname, String email, String password, String age,String pno){

        Frame myframe = new Frame();
        myframe.setLayout(null);
        myframe.setSize(300,450);
        myframe.setVisible(true);

        Label fnamel = new Label(fname);
        fnamel.setBounds(20,50,200,20);
        fnamel.setVisible(true);
        myframe.add(fnamel);

        Label snamel = new Label(sname);
        snamel.setBounds(20, 80,200,20);
        snamel.setVisible(true);
        myframe.add(snamel);

        Label emaill = new Label(email);
        emaill.setBounds(20, 110,200,20);
        emaill.setVisible(true);
        myframe.add(emaill);

        Label passwordl = new Label(password);
        passwordl.setBounds(20, 140,200,20);
        passwordl.setVisible(true);
        myframe.add(passwordl);

        Label agel = new Label(age);
        agel.setBounds(20, 170,200,20);
        agel.setVisible(true);
        myframe.add(agel);

        Label pnol = new Label(pno);
        pnol.setBounds(20, 200,200,20);
        pnol.setVisible(true);
        myframe.add(pnol);
    }


}
