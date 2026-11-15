import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class DeleteRecord extends JFrame implements ActionListener 
{
JLabel ltitle, lroll_no;
JTextField troll_no;
JButton bsubmit,bback;
JPanel p1;
Font f1;
JSeparator sp;
Connection con;
Statement st;
ResultSet rs;

public DeleteRecord()
{
ltitle=new JLabel("Delete Record");
f1=new Font("monotype corsiva",Font.BOLD,40);
ltitle.setFont(f1);
sp=new JSeparator();
lroll_no=new JLabel("Enter Roll_no:");



troll_no=new JTextField();

bsubmit=new JButton("Delete");
bback=new JButton("Exit");
p1=new JPanel();
p1.setLayout(null);

//set label bounds
ltitle.setBounds(100,10,250,40);
sp.setBounds(1,50,600,10);
lroll_no.setBounds(20,110,150,30);


troll_no.setBounds(180,110,150,30);



//set button bounds
bsubmit.setBounds(100,150,100,30);
bback.setBounds(220,150,100,30);
//initializing panel
p1=new JPanel();
p1.setLayout(null);

//adding components to panel
p1.add(ltitle);
p1.add(sp);
p1.add(lroll_no);

p1.add(troll_no);

p1.add(bsubmit);
p1.add(bback);
//adding panel to frame
add(p1);
bsubmit.addActionListener(this);
bback.addActionListener(this);
}

public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bsubmit) {
            String roll = troll_no.getText();
   

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
String connectionString="Jdbc:mysql://localhost:3306/sms";
String username="root";
String password="12345";
con=DriverManager.getConnection(connectionString,username,password);
String str ="DELETE FROM student WHERE roll_no='" + troll_no.getText() + "'";
st=con.createStatement();
st.executeUpdate(str);
JOptionPane.showMessageDialog(null,"Record Deleted Successfully..");
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
}
}
 if (e.getSource() == bback){
System.exit(0);
}
}
public static void main(String []ar)
{
DeleteRecord obj=new DeleteRecord();
obj.setSize(500,500);
obj.setVisible(true);
}
}