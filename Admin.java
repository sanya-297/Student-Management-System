import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Admin extends JFrame implements ActionListener
{
JPanel p1;
JMenuBar mb;
JMenu file, manageStudents;
JMenuItem logout , exit , addnewStudent, UpdateRecord , DeleteRecord; 
JTextArea jta;
JLabel lname,myImage,l1;
ImageIcon image;
Font f,f1;
  public Admin(String name)
	{
	p1 = new JPanel();
	p1.setLayout(null);
	mb = new JMenuBar();
	mb.setBounds(1,1, 800, 30);

	lname = new JLabel("Welcome," +name+"!");
	f = new Font("Serif",Font.BOLD, 50);
	lname.setFont(f);	
	lname.setBounds(200,230,500,60);
	l1=new JLabel("Admin Dashboard - Student Portal");
	l1.setBounds(150,300,500,30);
	f1 = new Font("Serif",Font.BOLD, 30);
	l1.setFont(f1);
	p1.add(l1);

//	jta= new JTextArea();
//	jta.setBounds(1, 31 , 800, 600);
		
	file = new JMenu("File");
	manageStudents = new JMenu("Manage Students");
	
	logout = new JMenuItem("Logout");	
	exit = new JMenuItem("Exit");	
	addnewStudent = new JMenuItem("Add New Student");	
	UpdateRecord = new JMenuItem("Retrieve & Update Record");		
	DeleteRecord = new JMenuItem("Delete Record");	


//Add Action Listener
	logout.addActionListener(this);
	exit.addActionListener(this);
	addnewStudent.addActionListener(this);
	UpdateRecord.addActionListener(this);
	DeleteRecord.addActionListener(this);
// add menu item into menu
	
	file.add(logout);
	file.add(exit);
	manageStudents.add(addnewStudent);
	manageStudents.add(UpdateRecord);
	manageStudents.add(DeleteRecord);

//adding logo
String path="logo.png";
image=new ImageIcon(path);
myImage=new JLabel();
myImage.setBounds(300,60,300,150);
myImage.setIcon(image);
p1.add(myImage);
// add Menu into Menubar
	mb.add(file);
	mb.add(manageStudents);
	
// add Menubar into Panel

	p1.add(mb);
	//p1.add(jta);
	p1.add(lname);

// add Panel into Frame
	add(p1);
	
	}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==logout)
{
Login ob=new Login();
ob.setSize(800,600);
ob.setVisible(true);
dispose();
}
else if(e.getSource() == addnewStudent) {
         AddStudents as = new AddStudents();
        as.setSize(1000, 800);
        as.setVisible(true);
dispose();
    }
else if(e.getSource() == UpdateRecord) {
        UpdateRecord ur = new UpdateRecord();
        ur.setSize(1000, 800);
        ur.setVisible(true);
dispose();
}
else if(e.getSource() == DeleteRecord) {
        DeleteRecord dr = new DeleteRecord();
        dr.setSize(1000, 800);
        dr.setVisible(true);
dispose();
}
else if(e.getSource()==exit)
{
System.exit(0);
}
}
   public static void main(String []ar)
	{
	Admin obj = new Admin("");
	  obj.setSize(800,600);
	  obj.setVisible(true);
	  obj.setTitle("Admin Form"); 
	}
}