import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class ManageStudents extends JFrame implements ActionListener 
{
JLabel ltitle, lroll_no,lname,lemail,laddress,lphone,leng_marks,lmaths_marks,lscience_marks,lcomputer_marks;
JTextField troll_no,tname,temail,taddress,tphone,teng_marks,tmaths_marks,tscience_marks,tcomputer_marks;
JButton bsubmit;
JPanel p1;
Font f1;
JSeparator sp;
Connection con;
Statement st;
ResultSet rs;

public ManageStudents()
{
ltitle=new JLabel("Students Record");
f1=new Font("monotype corsiva",Font.BOLD,40);
ltitle.setFont(f1);
sp=new JSeparator();
lroll_no=new JLabel("Enter Roll_no:");
lname=new JLabel("Enter Student Name:");
lemail=new JLabel("Enter Email:");
laddress=new JLabel("Enter Address:");
lphone=new JLabel("Enter Phone_no:");
leng_marks=new JLabel("Enter English Marks:");
lmaths_marks=new JLabel("Enter Maths Marks:");
lscience_marks=new JLabel("Enter Science Marks:");
lcomputer_marks=new JLabel("Enter Computer Marks:");


troll_no=new JTextField();
tname=new JTextField();
temail=new JTextField();
taddress=new JTextField();
tphone=new JTextField();
teng_marks=new JTextField();
tmaths_marks=new JTextField();
tscience_marks=new JTextField();
tcomputer_marks=new JTextField();
bsubmit=new JButton("Save");

p1=new JPanel();
p1.setLayout(null);

//set label bounds
ltitle.setBounds(250,10,350,40);
sp.setBounds(1,50,1000,10);
lroll_no.setBounds(20,110,200,30);
lname.setBounds(20,150,200,30);
lemail.setBounds(20,190,200,30);
laddress.setBounds(20,230,200,30);
lphone.setBounds(20,270,200,30);
leng_marks.setBounds(20,310,200,30);
lmaths_marks.setBounds(20,350,200,30);
lscience_marks.setBounds(20,390,200,30);
lcomputer_marks.setBounds(20,420,200,30);

troll_no.setBounds(240,110,250,30);
tname.setBounds(240,150,250,30);
temail.setBounds(240,190,250,30);
taddress.setBounds(240,230,250,30);
tphone.setBounds(240,270,250,30);
teng_marks.setBounds(240,310,250,30);
tmaths_marks.setBounds(240,350,250,30);
tscience_marks.setBounds(240,390,250,30);
tcomputer_marks.setBounds(240,450,250,30);


//set button bounds
bsubmit.setBounds(150,620,250,30);

//initializing panel
p1=new JPanel();
p1.setLayout(null);

//adding components to panel
p1.add(ltitle);
p1.add(lname);
p1.add(lroll_no);
p1.add(laddress);
p1.add(lphone);
p1.add(lemail);

p1.add(lmaths_marks);
p1.add(leng_marks);
p1.add(lcomputer_marks);
p1.add(lscience_marks);

p1.add(tname);
p1.add(troll_no);
p1.add(taddress);
p1.add(tphone);
p1.add(temail);

p1.add(tmaths_marks);
p1.add(teng_marks);
p1.add(tcomputer_marks);
p1.add(tscience_marks);
p1.add(sp);
p1.add(bsubmit);

//adding panel to frame
add(p1);
bsubmit.addActionListener(this);
}

public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bsubmit) {
            String roll = troll_no.getText();
            String name = tname.getText();
            String email = temail.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String eng = teng_marks.getText();
            String math = tmaths_marks.getText();
            String sci = tscience_marks.getText();
            String comp = tcomputer_marks.getText();

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
String connectionString="Jdbc:mysql://localhost:3306/sms";
String username="root";
String password="12345";
con=DriverManager.getConnection(connectionString,username,password);
String str = "INSERT INTO student VALUES('" + troll_no.getText() + "','" + tname.getText() + "','" + temail.getText() + "','" + taddress.getText() + "','" + tphone.getText() + "','" + teng_marks.getText() + "','" + tmaths_marks.getText() + "','" + tscience_marks.getText() + "','" + tcomputer_marks.getText() + "')"; /*Values('"+roll_no+"','"+name+"','"+email+"','"+address+"','"+phone+"','"+eng_marks+"','"+maths_marks+"','"+science_marks+"','"+computer_marks+"')";*/
st=con.createStatement();
st.executeUpdate(str);
System.out.println("record inserted..");
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
}
}
}
public static void main(String []ar)
{
ManageStudents obj=new ManageStudents();
obj.setSize(1000,800);
obj.setVisible(true);
}
}