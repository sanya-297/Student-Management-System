import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class ViewProfile extends JFrame implements ActionListener 
{
JLabel ltitle, lroll_no,lname,lemail,laddress,lphone;
JTextField troll_no,tname,temail,taddress,tphone;
JButton bsubmit,bsearch,bback;
JPanel p1;
Font f1;
JSeparator sp;
Connection con;
Statement st;
ResultSet rs;

public ViewProfile()
{
ltitle=new JLabel("Student Profile");
f1=new Font("monotype corsiva",Font.BOLD,40);
ltitle.setFont(f1);
sp=new JSeparator();
lroll_no=new JLabel("Enter Roll_no:");
lname=new JLabel("Enter Student Name:");
lemail=new JLabel("Enter Email:");
laddress=new JLabel("Enter Address:");
lphone=new JLabel("Enter Phone_no:");



troll_no=new JTextField();
tname=new JTextField();
temail=new JTextField();
taddress=new JTextField();
tphone=new JTextField();

bsubmit=new JButton("Save");
bback=new JButton("Exit");


//set label bounds
ltitle.setBounds(250,10,350,40);
sp.setBounds(1,50,1000,10);
lroll_no.setBounds(20,110,200,30);
lname.setBounds(20,150,200,30);
lemail.setBounds(20,190,200,30);
laddress.setBounds(20,230,200,30);
lphone.setBounds(20,270,200,30);


troll_no.setBounds(240,110,250,30);
tname.setBounds(240,150,250,30);
temail.setBounds(240,190,250,30);
taddress.setBounds(240,230,250,30);
tphone.setBounds(240,270,250,30);



//set button bounds

bback.setBounds(100,310,250,30);
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
p1.add(bback);


p1.add(tname);
p1.add(troll_no);
p1.add(taddress);
p1.add(tphone);
p1.add(temail);


p1.add(sp);


bsearch = new JButton("Search");
bsearch.setBounds(500, 110, 100, 30);
p1.add(bsearch);
bsearch.addActionListener(this);
bback.addActionListener(this);
add(p1);
}

public void actionPerformed(ActionEvent e) {
	if (e.getSource() == bsearch) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/sms", "root", "12345");

        String query = "SELECT * FROM student WHERE roll_no = " + troll_no.getText().trim();
        st = con.createStatement();
        rs = st.executeQuery(query);

        if (rs.next()) {
            tname.setText(rs.getString("name"));
            temail.setText(rs.getString("email"));
            taddress.setText(rs.getString("address"));
            tphone.setText(rs.getString("phone"));
;
        } else {
            JOptionPane.showMessageDialog(null, "Roll No not found!");
        }
    } catch (Exception ex) {
 	JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage()); 
}
}
 if (e.getSource() == bback){
System.exit(0);
}
}

public static void main(String []ar)
{
ViewProfile obj=new ViewProfile();
obj.setSize(1000,800);
obj.setVisible(true);
}
}