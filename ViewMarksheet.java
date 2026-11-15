import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ViewMarksheet extends JFrame implements ActionListener {
    JLabel ltitle, lname, lroll_no, lemail, lphone, laddress, leng_marks, lscience_marks_marks, lmaths_marks_marks, lcomputer_marks, ltotal, lgrade, lresult, lper;
    JTextField tname, troll_no, temail, tphone, taddress, teng_marks, tscience_marks_marks, tmaths_marks_marks, tcomputer_marks, ttotal, tgrade, tresult, tper;
    JButton bsubmit, bsearch,bback;
    JPanel p1;
    Font f1;
    JSeparator sp;
    Connection con;
    Statement st;
    ResultSet rs;

    public ViewMarksheet() {
        ltitle = new JLabel("STUDENT MARKSHEET");
        f1 = new Font("monotype corsiva", Font.BOLD, 40);
        ltitle.setFont(f1);
        sp = new JSeparator();

        lname = new JLabel("Student Name:");
        lroll_no = new JLabel("Student Roll number:");
        lemail = new JLabel("Student Email_id:");
        lphone = new JLabel("Student Phone_no:");
        laddress = new JLabel("Student Address:");
        lmaths_marks_marks = new JLabel("Maths Marks: ");
        leng_marks = new JLabel("English Marks:");
        lcomputer_marks = new JLabel("Computer Marks:");
        lscience_marks_marks = new JLabel("Science Marks:");
        ltotal = new JLabel("Total Marks Obtained");
        lper = new JLabel("Total Percentage Obtained");
        lgrade = new JLabel("Grade");
        lresult = new JLabel("Result");

        tname = new JTextField();
        troll_no = new JTextField();
        temail = new JTextField();
        tphone = new JTextField();
        taddress = new JTextField();
        tmaths_marks_marks = new JTextField();
        teng_marks = new JTextField();
        tcomputer_marks = new JTextField();
        tscience_marks_marks = new JTextField();
        ttotal = new JTextField();
        tper = new JTextField();
        tgrade = new JTextField();
        tresult = new JTextField();
        bsubmit = new JButton("Submit");
        bsearch = new JButton("Search");

        ltitle.setBounds(250, 10, 500, 40);
        sp.setBounds(1, 50, 1000, 10);
        lroll_no.setBounds(100, 70, 400, 30);
        troll_no.setBounds(240, 70, 250, 30);
        bsearch.setBounds(520, 70, 200, 30);

        lname.setBounds(20, 110, 200, 30);
        tname.setBounds(240, 110, 250, 30);
        lemail.setBounds(20, 150, 200, 30);
        temail.setBounds(240, 150, 250, 30);
        lphone.setBounds(20, 190, 200, 30);
        tphone.setBounds(240, 190, 250, 30);
        laddress.setBounds(20, 230, 200, 30);
        taddress.setBounds(240, 230, 250, 30);
        
        lmaths_marks_marks.setBounds(20, 270, 200, 30);
        tmaths_marks_marks.setBounds(240, 270, 250, 30);
        leng_marks.setBounds(20, 310, 200, 30);
        teng_marks.setBounds(240, 310, 250, 30);
        lscience_marks_marks.setBounds(20, 350, 200, 30);
        tscience_marks_marks.setBounds(240, 350, 250, 30);
        lcomputer_marks.setBounds(20, 390, 200, 30);
        tcomputer_marks.setBounds(240, 390, 250, 30);
        
        ltotal.setBounds(20, 430, 200, 30);
        ttotal.setBounds(240, 430, 250, 30);
        lper.setBounds(20, 470, 200, 30);
        tper.setBounds(240, 470, 250, 30);
        lgrade.setBounds(20, 510, 200, 30);
        tgrade.setBounds(240, 510, 250, 30);
        lresult.setBounds(20, 550, 200, 30);
        tresult.setBounds(240, 550, 250, 30);

        bsubmit.setBounds(150, 620, 200, 30);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.add(ltitle); p1.add(sp); p1.add(lroll_no); p1.add(troll_no); p1.add(bsearch);
        p1.add(lname); p1.add(tname); p1.add(lemail); p1.add(temail); p1.add(lphone); p1.add(tphone);
        p1.add(laddress); p1.add(taddress); p1.add(lmaths_marks_marks); p1.add(tmaths_marks_marks);
        p1.add(leng_marks); p1.add(teng_marks); p1.add(lscience_marks_marks); p1.add(tscience_marks_marks);
        p1.add(lcomputer_marks); p1.add(tcomputer_marks); p1.add(ltotal); p1.add(ttotal);
        p1.add(lper); p1.add(tper); p1.add(lgrade); p1.add(tgrade); p1.add(lresult); p1.add(tresult);
        p1.add(bsubmit);


bback = new JButton("Exit");
bback.setBounds(400, 620, 200, 30);
p1.add(bback);
bback.addActionListener(this);

        add(p1);
        bsubmit.addActionListener(this);
        bsearch.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bsearch) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "12345");
                String query = "SELECT * FROM student WHERE roll_no = " + troll_no.getText().trim();
                st = con.createStatement();
                rs = st.executeQuery(query);
                if (rs.next()) {
                    tname.setText(rs.getString("name"));
                    temail.setText(rs.getString("email"));
                    tphone.setText(rs.getString("phone"));
                    taddress.setText(rs.getString("address"));
                    tmaths_marks_marks.setText(rs.getString("maths_marks"));
                    teng_marks.setText(rs.getString("eng_marks"));
                    tcomputer_marks.setText(rs.getString("computer_marks"));
                    tscience_marks_marks.setText(rs.getString("science_marks"));
                } else {
                    JOptionPane.showMessageDialog(null, "Roll No not found!");
                }
            } catch (Exception ex) { ex.printStackTrace(); }
        }
        if (e.getSource() == bsubmit) {
            try {
                int maths = Integer.parseInt(tmaths_marks_marks.getText());
                int eng = Integer.parseInt(teng_marks.getText());
                int comp = Integer.parseInt(tcomputer_marks.getText());
                int sci = Integer.parseInt(tscience_marks_marks.getText());
                int total = (maths + eng + comp + sci);
                ttotal.setText(String.valueOf(total));
                float per = (float) total / 4.0f;
                tper.setText(String.valueOf(per));

	if (per >= 80 && per < 100) {
            tgrade.setText("A");
            tresult.setText("Pass");
        } else if (per >= 60 && per < 80) {
            tgrade.setText("B");
            tresult.setText("Pass");
        } else if (per >= 35 && per < 60) {
            tgrade.setText("C");
            tresult.setText("Pass");
        } else {
            tgrade.setText("D");
            tresult.setText("Fail");
        }

            } catch (Exception ex) { JOptionPane.showMessageDialog(null, "Error in calculation"); }
        }
if(e.getSource()==bback)
{
System.exit(0);
}
    }

    public static void main(String[] ar) {
        ViewMarksheet obj = new ViewMarksheet();
        obj.setSize(1000, 800);
        obj.setVisible(true);
    }
}