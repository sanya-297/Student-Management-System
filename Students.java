import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Students extends JFrame implements ActionListener
{
JPanel p1;
JMenuBar mb;
JMenu file, Academics;
JMenuItem logout , exit , viewprofile, Marksheet ; 
JTextArea jta;
JLabel lname,myImage,l1;
ImageIcon image;
Font f,f1;
  public Students(String name)
	{
	p1 = new JPanel();
	p1.setLayout(null);
	mb = new JMenuBar();
	mb.setBounds(1,1, 800, 30);

	lname = new JLabel("Welcome," +name+"!");
	f = new Font("Serif",Font.BOLD, 70);
	lname.setFont(f);	
	lname.setBounds(100,230,700,80);
	l1=new JLabel("Students-Portal");
	l1.setBounds(200,330,500,50);
	f1 = new Font("Serif",Font.BOLD, 50);
	l1.setFont(f1);
	p1.add(l1);

//	jta= new JTextArea();
//	jta.setBounds(1, 31 , 800, 600);
		
	file = new JMenu("File");
	Academics = new JMenu("Academics");
	
	logout = new JMenuItem("Logout");	
	exit = new JMenuItem("Exit");	
	viewprofile = new JMenuItem("View Profile");	

	Marksheet = new JMenuItem("View Marksheet");		


//Add Action Listener
	logout.addActionListener(this);
	exit.addActionListener(this);
	viewprofile.addActionListener(this);
	Marksheet.addActionListener(this);
// add menu item into menu
	
	file.add(logout);
	file.add(exit);
	Academics.add(viewprofile);
	Academics.add(Marksheet);

//adding logo
String path="logo.png";
image=new ImageIcon(path);
myImage=new JLabel();
myImage.setBounds(300,60,300,150);
myImage.setIcon(image);
p1.add(myImage);
// add Menu into Menubar
	mb.add(file);
	mb.add(Academics);
	
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
else if(e.getSource()==viewprofile)
{
ViewProfile ob=new ViewProfile();
ob.setSize(800,600);
ob.setVisible(true);
dispose();
}
else if(e.getSource()==Marksheet)
{
ViewMarksheet ob=new ViewMarksheet();
ob.setSize(1000,800);
ob.setVisible(true);
dispose();
}
else if(e.getSource()==exit)
{
System.exit(0);
}
}
   public static void main(String []ar)
	{
	Students obj = new Students("");
	  obj.setSize(800,600);
	  obj.setVisible(true);
	  obj.setTitle("Students Form");
	}
}