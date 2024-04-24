import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {


        //Creating a frame object with name jFrame to access the methods of class JFrame
        JFrame jFrame = new JFrame("Application form !");

        //Changing hidden to visible
        jFrame.setVisible(true);

        //setting size of frame
        jFrame.setSize(1024,640);

        //Reset default layout to null
        jFrame.setLayout(null);

        //Create Labels

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(20,20,150,50);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(20,60,150,50);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(20,100,150,50);



        //Adding label to frame
        jFrame.add(lblName);
        jFrame.add(lblAddress);
        jFrame.add(lblGender);



        //Creating text fields and other components
        JTextField txtName = new JTextField();
        txtName.setBounds(100,25,170,30);

        JTextField txtAddress = new JTextField();
        txtAddress.setBounds(100,75,170,30);

        //Radio Button
        JRadioButton maleRadio=new JRadioButton("Male");
       maleRadio.setBounds(100,105,150,50);

        JRadioButton femaleRadio=new JRadioButton("Female");
        femaleRadio.setBounds(250,105,150,50);

        //Create grp for selection only one among others
        ButtonGroup grp=new ButtonGroup();
        grp.add(maleRadio);
        grp.add(femaleRadio);


        //Add in frame
        jFrame.add(txtName);
        jFrame.add(txtAddress);
        jFrame.add(maleRadio);
        jFrame.add(femaleRadio);



        JMenuBar mb=new JMenuBar();
        mb.setBounds(30, 350, 200, 20);

        JMenu menu1=new JMenu("File");

        JMenuItem item1,item3;
        item1=new JMenuItem("New");

        JMenu item2=new JMenu("Open");
        JMenuItem i1,i2;
        i1=new JMenuItem("Open Project");
        i2=new JMenuItem("Open File");
        item2.add(i1);
        item2.add(i2);
        item3=new JMenuItem("Close");
        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        mb.add(menu1);

        JMenu menu2=new JMenu("Edit");
        JMenuItem it1,it2;
        it1=new JMenuItem("Copy");
        it2=new JMenuItem("Paste");
        menu2.add(it1);
        menu2.add(it2);
        mb.add(menu2);
        jFrame.add(mb);


        jFrame.setJMenuBar(mb);




        //For Buttons and Action Listeners
        //Save Button
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(20,250,100,50);
        jFrame.add(btnSave);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int choice = JOptionPane.showOptionDialog(null, //Component parentComponent
                        "DO you want To Save and See in the Table?", //Object message,
                        "Choose an option", //String title
                        JOptionPane.YES_NO_OPTION, //int optionType
                        JOptionPane.INFORMATION_MESSAGE, //int messageType
                        null, //Icon icon,
                        new String[]{"OK", "No"}, //Object[] options,
                        "No");//Object initialValue
                if(choice == 0 ){
//Saved was chosen
                    System.out.println("Saved !!!!");

                    String name = txtName.getText();
                    String address = txtAddress.getText();
                    System.out.println(name);
                    System.out.println(address);


                }else{
                    //
                    System.out.println("Not Saved");

                }

            }
        });


        //For Buttons and Action Listeners
        //Clear Button
        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(200,250,100,50);
        jFrame.add(btnClear);

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String address = txtAddress.getText();
                txtName.setText("");
                txtAddress.setText("");

                //get radio + checkbox (same process)
                String gender="";
                if(maleRadio.isSelected()) {
                    gender = maleRadio.getText();

                }
                else {
                    gender = femaleRadio.getText();
                   // femaleRadio.setSelected(false);
                }

                grp.clearSelection();

                System.out.println(name);
                System.out.println(address);
                System.out.println(gender);



            }
        });

        //For Buttons and Action Listeners
        //Close
        JButton btnClose = new JButton("Close");
        btnClose.setBounds(350,250,100,50);
        jFrame.add(btnClose);

        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    // create a dialog Box
                    JDialog d = new JDialog(jFrame, "Program Execution Ended !! ");

                    // create a label
                    JLabel l = new JLabel("Closing The Program !!!!! ");
                    d.add(l);

                    // setsize of dialog
                    d.setSize(500, 500);

                    // set visibility of dialog
                    d.setVisible(true);
            }
        });


        //For Table

        //name of columns
        String[] columnNames = { "Name", "Address", "Gender" };

        // Data to be displayed in the JTable
        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Anand Jha", "6014", "IT" }
        };

        JTable jTable = new JTable(data,columnNames);
        jTable.setBounds(700,120,400,400);
        jFrame.add(jTable);





        //exiting program after closing frame
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);





        }
}