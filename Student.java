import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MyStudent
	extends JFrame
	implements ActionListener
{
	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JLabel dob;
	private JComboBox date;
	private JComboBox month;
	private JComboBox year;
	private JLabel gender;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup gengp;
	private JLabel mailIdLabel;
	private JTextField mailIdField;
	private JLabel mno;
	private JTextField tmno;
	private JLabel add;
	private JTextArea tadd;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JLabel rePasswordLabel;
	private JPasswordField rePasswordField;
	private JLabel deg;
	private JComboBox degs;
	private JLabel uni;
	private JComboBox cmp;
	private JCheckBox term;
	private JButton reg;
	private JButton reset;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;

	private String dates[]
		= { "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20",
			"21", "22", "23", "24", "25",
			"26", "27", "28", "29", "30",
			"31" };
	private String months[]
		= { "Jan", "feb", "Mar", "Apr",
			"May", "Jun", "July", "Aug",
			"Sup", "Oct", "Nov", "Dec" };
	private String years[]
		= {"1998","1999", "2000",
			"2001", "2002"};
	private String degrees[]
		={"Information Technology","Engineering",
          "Medical Science","Computer Science",
          "Biological Sceince","Physical Science"};
	private String universities[]
		={"Moratuwa","Colombo",
		  "Sabaragamuwa","Jayawardanapuara","Ruhuna"};

	public MyStudent()
	{
		setTitle("University Student Registration Form");
		setBounds(400, 200, 1100, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("2022 UGC Registration");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(600,30);
	    	title.setLocation(400, 20);
		c.add(title);

		name = new JLabel("Name    :");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		name.setSize(100, 20);
		name.setLocation(70, 80);
		c.add(name);

		tname = new JTextField();
		tname.setFont(new Font("Arial", Font.PLAIN, 15));
		tname.setSize(300, 30);
		tname.setLocation(200, 80);
		c.add(tname);
		
		dob = new JLabel("DOB     :");
		dob.setFont(new Font("Arial", Font.PLAIN, 20));
		dob.setSize(100, 20);
		dob.setLocation(70, 130);
		c.add(dob);

		date = new JComboBox(dates);
		date.setFont(new Font("Arial", Font.PLAIN, 15));
		date.setSize(70, 25);
		date.setLocation(200, 130);
		c.add(date);

		month = new JComboBox(months);
		month.setFont(new Font("Arial", Font.PLAIN, 15));
		month.setSize(70, 25);
		month.setLocation(280, 130);
		c.add(month);

		year = new JComboBox(years);
		year.setFont(new Font("Arial", Font.PLAIN, 15));
		year.setSize(90, 25);
		year.setLocation(370, 130);
		c.add(year);
		
		gender = new JLabel("Gender  :");
		gender.setFont(new Font("Arial", Font.PLAIN, 20));
		gender.setSize(100, 20);
		gender.setLocation(70, 180);
		c.add(gender);

		male = new JRadioButton("Male");
		male.setFont(new Font("Arial", Font.PLAIN, 15));
		male.setSelected(true);
		male.setSize(100, 30);
		male.setLocation(200, 180);
		c.add(male);

		female = new JRadioButton("Female");
		female.setFont(new Font("Arial", Font.PLAIN, 15));
		female.setSelected(false);
		female.setSize(100, 30);
		female.setLocation(275,180);
		c.add(female);

		gengp = new ButtonGroup();
		gengp.add(male);
		gengp.add(female);
		
		mailIdLabel = new JLabel("E Mail    :");
		mailIdLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		mailIdLabel.setSize(100, 20);
		mailIdLabel.setLocation(600, 270);
		c.add(mailIdLabel);
		
		mailIdField = new JTextField();
		mailIdField.setFont(new Font("Arial", Font.PLAIN, 15));
		mailIdField.setSize(300, 30);
		mailIdField.setLocation(720, 270);
		c.add(mailIdField);

		mno = new JLabel("Mobile    :");
		mno.setFont(new Font("Arial", Font.PLAIN, 20));
		mno.setSize(100, 20);
		mno.setLocation(600, 220);
		c.add(mno);

		tmno = new JTextField();
		tmno.setFont(new Font("Arial", Font.PLAIN, 15));
		tmno.setSize(300, 30);
		tmno.setLocation(720, 220);
		c.add(tmno);
		
		add = new JLabel("Address   :");
		add.setFont(new Font("Arial", Font.PLAIN, 20));
		add.setSize(100, 20);
		add.setLocation(600, 80);
		c.add(add);

		tadd = new JTextArea();
		tadd.setFont(new Font("Arial", Font.PLAIN, 15));
		tadd.setSize(300, 100);
		tadd.setLocation(720, 80);
		tadd.setLineWrap(true);
		c.add(tadd);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordLabel.setSize(100, 20);
		passwordLabel.setLocation(70, 230);
		c.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordField.setSize(300, 30);
		passwordField.setLocation(200, 230);
		c.add(passwordField);

		deg = new JLabel("Degree :");
		deg.setFont(new Font("Arial", Font.PLAIN, 20));
		deg.setSize(100,20);
		deg.setLocation(70, 320);
		c.add(deg);

		degs = new JComboBox(degrees);
		degs.setFont(new Font("Arial", Font.PLAIN, 15));
		degs.setSize(250, 30);
		degs.setLocation(200, 320);
		c.add(degs);

		uni = new JLabel("University:");
		uni.setFont(new Font("Arial", Font.PLAIN, 20));
		uni.setSize(100,20);
		uni.setLocation(600, 320);
		c.add(uni);

		cmp = new JComboBox(universities);
		cmp.setFont(new Font("Arial", Font.PLAIN, 15));
		cmp.setSize(250,30);
		cmp.setLocation(720,320);
		c.add(cmp);

		term = new JCheckBox("Accept Terms And Conditions.");
		term.setFont(new Font("Arial", Font.PLAIN, 20));
		term.setSize(400, 80);
		term.setLocation(400, 380);
		c.add(term);

		reg = new JButton("REGISTER");
		reg.setFont(new Font("Arial", Font.PLAIN, 15));
		reg.setSize(120, 30);
		reg.setLocation(300, 520);
		reg.addActionListener(this);
		c.add(reg);

		reset = new JButton("RESET");
		reset.setFont(new Font("Arial", Font.PLAIN, 15));
		reset.setSize(120, 30);
		reset.setLocation(640, 520);
		reset.addActionListener(this);
		c.add(reset);

		tout = new JTextArea();
		tout.setFont(new Font("Arial", Font.PLAIN, 15));
		tout.setSize(650, 180);
		tout.setLocation(220, 570);
		tout.setLineWrap(true);
		tout.setEditable(false);
		c.add(tout);

		res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setSize(500, 25);
		res.setLocation(355, 460);
		c.add(res);

		resadd = new JTextArea();
		resadd.setFont(new Font("Arial", Font.PLAIN, 15));
		resadd.setSize(650,180);
		resadd.setLocation(220, 570);
		resadd.setLineWrap(true);
		c.add(resadd);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == reg) {
			if (term.isSelected()) {
				try{
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					Connection conn = DriverManager.getConnection("jdbc:ucanaccess://UGC.accdb");
					String data2;
					String data
						= "Name : "
						+ tname.getText() + "\n";
					String data1
					= "DOB : "
					+ (String)date.getSelectedItem()
					+ "/" + (String)month.getSelectedItem()
					+ "/" + (String)year.getSelectedItem()
					+ "\n";
					if (male.isSelected())
						data2 = "Gender : Male"
								+ "\n";
					else
						data2 = "Gender : Female"
								+ "\n";
					String data3 = "E Mail : " + mailIdField.getText()+ "\n";
					String data4 = "Mobile No : " + tmno.getText()+ "\n";
					String data5 = "Address : " + tadd.getText()+ "\n";
					String data6 = "Degree : " + (String)degs.getSelectedItem()+ "\n";
					String data7 = "University of : " + (String)cmp.getSelectedItem();
					tout.setText(data + data1 + data2 + data3 + data4 + data5 + data6 + data7 );
					tout.setEditable(false);			
					
					String dateOfBirth = (String)date.getSelectedItem() + (String)month.getSelectedItem() + (String)year.getSelectedItem();
					String sql = "INSERT INTO Registration (Name,DOB,Gender,Email,Mobile_No,Address,Degree,University_of) VALUES ('"+tname.getText()+"','"+dateOfBirth+"','"+data2+"','"+mailIdField.getText()+"','"+tmno.getText()+"','"+tadd.getText()+"','"+(String)degs.getSelectedItem()+"','"+(String)cmp.getSelectedItem()+"')";

					Statement stmt = conn.createStatement();
					stmt.execute(sql);

					res.setText("Registration Successfully.....");
				}catch(Exception err){
					System.out.println(err.getMessage());
				}
			}
			else {
				tout.setText("");
				resadd.setText("");
				res.setText("Please accept the"
							+ " terms & conditions.....");
			}
		}

		else if (e.getSource() == reset) {
			String def = "";
			tname.setText(def);
			tadd.setText(def);
			tmno.setText(def);
			res.setText(def);
			tout.setText(def);
			term.setSelected(false);
			date.setSelectedIndex(0);
			month.setSelectedIndex(0);
			year.setSelectedIndex(0);
			passwordField.setText(def);
			rePasswordField.setText(def);
			mailIdField.setText(def);
			degs.setSelectedIndex(0);
			cmp.setSelectedIndex(0);
			resadd.setText(def);
		}
	}
}

class Student {

	public static void main(String[] args) throws Exception
	{
		MyStudent f = new MyStudent();
	}
}