import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;
import java.sql.*; 

class Login extends JFrame implements ActionListener {
    JLabel lrole, ltitle, luser, lpassword;
    JTextField tuser, tpassword; 
    JComboBox cmb;
    JButton blogin;
    JPanel p1;
    Font ftitle, f1;

    public Login() {
        ltitle = new JLabel("Login Form");
        ftitle = new Font("monotype corsiva", Font.BOLD, 40);
        ltitle.setFont(ftitle);
        f1 = new Font("times new roman", Font.BOLD, 30);
        
        luser = new JLabel("User Name");
        lrole = new JLabel("Choose Role");
        luser.setFont(f1);
        lrole.setFont(f1);
        lpassword = new JLabel("Enter Password");
        lpassword.setFont(f1);
        
        tuser = new JTextField();
        tpassword = new JTextField();

        cmb = new JComboBox();
        cmb.addItem("--Select Role--");
        cmb.addItem("Admin");
        cmb.addItem("Students");

        blogin = new JButton("Login");

        ltitle.setBounds(250, 20, 380, 50);
        lrole.setBounds(100, 90, 200, 40);
        cmb.setBounds(350, 90, 200, 40);
        luser.setBounds(100, 150, 200, 40);
        lpassword.setBounds(100, 210, 250, 40);
        tuser.setBounds(350, 150, 250, 40);
        tpassword.setBounds(350, 210, 250, 40);
        blogin.setBounds(200, 270, 250, 40);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.add(ltitle);
        p1.add(luser);
        p1.add(lrole);
        p1.add(lpassword);
        p1.add(tuser);
        p1.add(tpassword);
        p1.add(cmb);
        p1.add(blogin);
        blogin.addActionListener(this);

        p1.setBackground(Color.decode("#AED6F1"));
        add(p1);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == blogin) {
            String role = (String) cmb.getSelectedItem();
            String username = tuser.getText();
            String password = tpassword.getText();

            if (role.equals("--Select Role--")) {
                JOptionPane.showMessageDialog(this, "Please select a role!");
                return;
            }

            try {
                // Connection string: Update localhost port if necessary (usually 3306)
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "12345");
                Statement stmt = con.createStatement();
                
                String query = "";
                if (role.equals("Admin")) {
                    query = "SELECT * FROM admin WHERE name = '" + username + "' AND password = '" + password + "'";
                } else {
                    query = "SELECT * FROM student WHERE name = '" + username + "' AND email = '" + password + "'";
                }

                ResultSet rs = stmt.executeQuery(query);

                if (rs.next()) {
                    // Successful Login
                    if (role.equals("Admin")) {
                        Admin obj = new Admin(username);
                        obj.setSize(800, 600);
                        obj.setVisible(true);
                    } else {
                        Students obj = new Students(username);
                        obj.setSize(800, 600);
                        obj.setVisible(true);
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                }
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] ar) {
        Login obj = new Login();
        obj.setSize(800, 600);
        obj.setVisible(true);
    }
}
