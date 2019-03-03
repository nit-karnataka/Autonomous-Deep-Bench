import java.io.*;
import java.util.*;
import java.util.Date;
//import java.sql.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JScrollPane;
import java.sql.*;
class Hind extends JFrame implements ActionListener
{
 JButton b2,b1;
 JLabel j1;
 Font f,ff;
 Panel p1=new Panel();
 Panel p2=new Panel();
 Hind()
  {
    super("Autonomous Deep Bench");
    setVisible(true);
    setSize(1500,1500);
    setLayout(new FlowLayout(FlowLayout.CENTER,400,200));
    p1.setLayout(new FlowLayout(FlowLayout.CENTER));
    p2.setLayout(new FlowLayout(FlowLayout.CENTER));
    b1=new JButton("Register");
    b2=new JButton("Login");
    f=new Font("Comic Sans MS",Font.PLAIN,15);
    ff=new Font("Comic Sans MS",Font.BOLD,30);
    j1=new JLabel("Welcome to P.D. HINDUJA HOSPITAL & MEDICAL RESEARCH CENTRE");
    j1.setFont(ff);
    b2.setFont(f);
    b1.setFont(f);
    p1.add(j1); 
    p2.add(b1);
    p2.add(b2);
    add(p1);
    add(p2);
    b1.addActionListener(this);
    b2.addActionListener(this);
  }
  public void actionPerformed(ActionEvent ae)
 {
    if(b1.equals(ae.getSource()))
  {
	new Reg();
	setVisible(false);
    }
    else
    {
		new Login();
		setVisible(false);
 }
}
  
public static void main(String...a)
 {
   new Hind();
}
 }
 
 
  
 class Reg extends JFrame implements ActionListener
 {
  JLabel l1,l2;
  JTextField t1;
  JPasswordField ap2;
  JButton b1;
  Font f;
  Panel p1=new Panel();
  Panel p2=new Panel();
  Panel p3=new Panel();
  Reg()
 {
  setVisible(true);
  setSize(1000,1000);
  setLayout(new FlowLayout(FlowLayout.LEFT,500,50));
  p1.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
  p2.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
  p3.setLayout(new FlowLayout(FlowLayout.LEFT,50,0));
  l1=new JLabel("username");
  l2=new JLabel("password");
  t1=new JTextField(20);
  ap2=new JPasswordField(20);
  b1=new JButton("Register");
  f=new Font("Comic Sans MS",Font.PLAIN,15);
  l1.setFont(f);
  l2.setFont(f);
  t1.setFont(f);
  b1.setFont(f);
  p1.add(l1);
  p1.add(t1);
  add(p1);
  p2.add(l2);
  p2.add(ap2);
  add(p2);
  p3.add(b1);
  add(p3);
  b1.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
	
	if(b1.equals(ae.getSource()))
	{ try{
	  DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
	PreparedStatement p=c.prepareStatement("insert into used values(?,?)");
	p.setString(1,t1.getText());
	p.setString(2,ap2.getText());
	int mn=p.executeUpdate();
	if(mn==1)
	  JOptionPane.showMessageDialog(null,"Registered Successfully");
	c.close();
	p.close();
	
	
  }catch(Exception e){}
    new Hind();
	setVisible(false);
   }
}
}
 
 
 class Login extends JFrame implements ActionListener
 {
  JLabel l1,l2;
  JTextField t1;
  JPasswordField ap2;
  JButton b1,b2;
  Font f;
  Panel p1=new Panel();
  Panel p2=new Panel();
  Panel p3=new Panel();
  Login()
 {
  setVisible(true);
  setSize(1000,1000);
  setLayout(new FlowLayout(FlowLayout.LEFT,500,50));
  p1.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
  p2.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
  p3.setLayout(new FlowLayout(FlowLayout.LEFT,50,0));
  l1=new JLabel("username");
  l2=new JLabel("password");
  t1=new JTextField(20);
  ap2=new JPasswordField(20);
  b1=new JButton("Login");
  b2=new JButton("go to main menu");
  f=new Font("Comic Sans MS",Font.PLAIN,15);
  l1.setFont(f);
  l2.setFont(f);
  t1.setFont(f);
  b2.setFont(f);
  b1.setFont(f);
  p1.add(l1);
  p1.add(t1);
  add(p1);
  p2.add(l2);
  p2.add(ap2);
  add(p2);
  p3.add(b1);
  p3.add(b2);
  add(p3);
  b1.addActionListener(this);
  b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{int u=1;
 if(b1.equals(ae.getSource()))
  {
	if(t1.getText()==""||ap2.getText()=="")
	{
	  JOptionPane.showMessageDialog(null,"fill the fields properly");
	}
	else{
    try{
	  DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	  Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
	Statement s=c.createStatement();
	ResultSet rs=s.executeQuery("select * from used");
	while(rs.next())
	{
		if(rs.getString(1).equals(t1.getText())&&rs.getString(2).equals(ap2.getText()))
		{
			JOptionPane.showMessageDialog(null,"Logged in successfully");
			Date dt=new Date();
			
	
	
			
			
			new Register();
			setVisible(false);
			u=0;
			break;
		}
		
	}
	if(u==1)
		{
			JOptionPane.showMessageDialog(null,"Invalid Credentials");
		}
	
	c.close();
	
	
  }catch(Exception e){}
    }
   }
   else
   {
	   new Hind();
	   setVisible(false);
   }
}
}
 
 
 
 
 
 
 
 
 class Register extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
 JButton b1,b2,b3,b4;
 JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
 JRadioButton r1,r2;
 ButtonGroup bg=new ButtonGroup();
 Font f;
 Panel p2=new Panel();
 Panel p3=new Panel();
 Panel p4=new Panel();
 Panel p5=new Panel();
 Panel p6=new Panel();
 Panel p7=new Panel();
 Panel p8=new Panel();

public Register()
{
 setVisible(true);
 setLayout(new FlowLayout(FlowLayout.CENTER,500,50));
 setSize(1000,1000);
 p5.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
 p2.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
 p3.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
 p4.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
 p6.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
 p7.setLayout(new FlowLayout(FlowLayout.CENTER,20,15));
 p8.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
 
 r1=new JRadioButton("and");
 r2=new JRadioButton("or");
 bg.add(r1);
 bg.add(r2);
 
 l1=new JLabel("Student");
 l2=new JLabel("Mail id");
 l3=new JLabel("Mobile Number");
 
 l4=new JLabel("Research Faculty");
 l5=new JLabel("mail id");
 l6=new JLabel("Mobile Number");
 
 l7=new JLabel("Guide/Doctor");
 l8=new JLabel("Mail id");
 l9=new JLabel("Mobile Number");
 
 l10=new JLabel("enter Search KeyWords");
 
 t1=new JTextField(30);
 t2=new JTextField(30); 
 t3=new JTextField(30); 
 t4=new JTextField(30); 
 t5=new JTextField(30); 
 t6=new JTextField(30); 
 t7=new JTextField(30); 
 t8=new JTextField(30); 
 t9=new JTextField(30); 
 
 t10=new JTextField("Enter keywords seperated with Comma(,)",40);
 
 f=new Font("Comic Sans MS",Font.PLAIN,15);
 
 b1=new JButton("Upload Profile");
 b2=new JButton("Add another Student");
 b3=new JButton("Search");
 b4=new JButton("goto home page");
 
 p2.add(l1);   
 p2.add(t1);   
 p2.add(l2);   
 p2.add(t2);
 p2.add(l3);
 p2.add(t3);
 //member 2
 p3.add(l4);
 p3.add(t4);
 p3.add(l5);
 p3.add(t5);
 p3.add(l6);
 p3.add(t6);
 // member 3
 p4.add(l7);
 p4.add(t7);
 p4.add(l8);
 p4.add(t8);
 p4.add(l9);
 p4.add(t9);
 
 
 
 //search elements text field 
 p6.add(l10);
 p6.add(t10);
 
 //buttons
 
 p7.add(r1);
 p7.add(r2);
 
 p5.add(b1);
 p5.add(b2); 
 p5.add(b3);
 p5.add(b4);
 //panels
 //add(p1);
 
 add(p2);
 add(p3);
 add(p4);
 add(p6);
 add(p7);
 add(p5);
 //font styles for labels
 
 l1.setFont(f);
 l2.setFont(f);
 l3.setFont(f);
 l4.setFont(f);
 l5.setFont(f);
 l6.setFont(f);
 l7.setFont(f);
 l8.setFont(f);
 l9.setFont(f);
 l10.setFont(f);
 
 //font styles for textfields
 
 t1.setFont(f);
 t2.setFont(f);
 t3.setFont(f);
 t4.setFont(f);
 t5.setFont(f);
 t6.setFont(f);
 t7.setFont(f);
 t8.setFont(f);
 t9.setFont(f);
 t10.setFont(f);
 r1.setFont(f);
 r2.setFont(f);
 
 b1.addActionListener(this);
 b2.addActionListener(this);
 b3.addActionListener(this);
 b4.addActionListener(this);
 //hidden text
 t10.addMouseListener(new MouseAdapter(){
public void mouseClicked(MouseEvent e) {
if(t10.getText().equals("Enter keywords seperated with Comma(,)"))
t10.setText("");
  }
});
//names validation
 t1.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {

         if(!(Character.isLetter(evt.getKeyChar()))){
                evt.consume();
            }
        }
    });

t4.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {

         if(!(Character.isLetter(evt.getKeyChar()))){
                evt.consume();
            }
        }
    });

t7.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {

         if(!(Character.isLetter(evt.getKeyChar()))){
                evt.consume();
            }
        }
    });
//mobiles numbers validation
t3.addKeyListener(new KeyAdapter(){
 public void keyTyped(KeyEvent e)
 {
   char input=e.getKeyChar();
   if((input<'0'||input>'9')&&input!='\b')
   {
     e.consume();
   }
  }}); 
   t6.addKeyListener(new KeyAdapter(){
 public void keyTyped(KeyEvent e)
 {
   char input=e.getKeyChar();
   if((input<'0'||input>'9')&&input!='\b')
   {
     e.consume();
   }
  }}); 
   t9.addKeyListener(new KeyAdapter(){
 public void keyTyped(KeyEvent e)
 {
   char input=e.getKeyChar();
   if((input<'0'||input>'9')&&input!='\b')
   {
     e.consume();
   }
  }}); 
  
}
public void actionPerformed(ActionEvent ae)
{

try
{

if(b1.equals(ae.getSource()))//uplooad
  {  
if((t1.getText().equals(""))||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||t6.getText().equals("")||t7.getText().equals("")||t8.getText().equals("")||t9.getText().equals("")||t10.getText().equals("Enter keywords seperated with Comma(,)"))
{ 
JOptionPane.showMessageDialog(null,"please fill all details properly");
}
else
{
DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
PreparedStatement p=c.prepareStatement("insert into reg values(?,?,?,?,?,?,?,?,?,?)");

p.setString(1,t1.getText());//  name
p.setString(2,t2.getText());// mail id
p.setString(3,t3.getText());//  mobile no
p.setString(4,t4.getText());// name
p.setString(5,t5.getText());// mail id
p.setString(6,t6.getText());// mobile no
p.setString(7,t7.getText());//name
p.setString(8,t8.getText());//mail id
p.setString(9,t9.getText());//mobile no
//p.setString(10,t10.getText());// key word
int tt=p.executeUpdate();
if(tt==1)
JOptionPane.showMessageDialog(null,"Registered Successfully");
c.close();
p.close();
}
}//b1 end if

else if(b2.equals(ae.getSource()))
{
  new Adduser(t4.getText(),t5.getText(),t6.getText(),t7.getText(),t8.getText(),t9.getText());
setVisible(false);

}
else if(b3.equals(ae.getSource()))
{
	if(t10.getText().equals("")||t10.getText().equals("Enter keywords seperated with Comma(,)"))
	{
		JOptionPane.showMessageDialog(null,"enter keyword");
	}
	else{
		if((r1.isSelected())||r2.isSelected()){
  try{
  if(r1.isSelected()){	  
String ser="";int c=0;
Date d=new Date();
String datar[]= t10.getText().split(",");
File file = new File("D:\\folder\\pdf");
    if(file!=null && file.exists())
	{
        File[] listOfFiles = file.listFiles();

        if(listOfFiles!=null)
		{
            for (int i=0;i<listOfFiles.length;i++)
			{
                if (listOfFiles[i].isFile())
				{
					FileInputStream fis = new FileInputStream(listOfFiles[i]);
					byte[] data = new byte[(int) file.length()];
					fis.read(data);
					fis.close();
					String str = new String(data, "UTF-8");c=0;
					for(int ii=0;ii<datar.length;ii++)
					{
						if((str.contains(datar[ii])))
						{	c++;
						}
					}
					 String sl=listOfFiles[i].toString();
				    int l=sl.length()-3;
					if(c==datar.length)
					{
						ser=ser+sl.substring(14,l)+"pdf"+"\n";
					}
  
                       
				}
			}
		}
	}
	if(ser.equals(""))
		ser="given keywords doesn't exist in any file";  

new Ans(ser);
setVisible(false);
  }
  else
  {
	  String ser="";int c=0;
Date d=new Date();
String datar[]= t10.getText().split(",");
File file = new File("D:\\folder\\pdf");
    if(file!=null && file.exists())
	{
        File[] listOfFiles = file.listFiles();

        if(listOfFiles!=null)
		{
            for (int i=0;i<listOfFiles.length;i++)
			{
                if (listOfFiles[i].isFile())
				{
					FileInputStream fis = new FileInputStream(listOfFiles[i]);
					byte[] data = new byte[(int) file.length()];
					fis.read(data);
					fis.close();
					String str = new String(data, "UTF-8");c=0;
					for(int ii=0;ii<datar.length;ii++)
					{
						if((str.contains(datar[ii])))
						{	c++;break;
						}
	
					}
				    String sl=listOfFiles[i].toString();
				    int l=sl.length()-3;
					if(c!=0)
					{
						ser=ser+sl.substring(14,l)+"pdf"+"\n";
					}
                       
				}
			}
		}
	}
	if(ser.equals(""))
		ser="given keywords doesn't exist in any file";  
new Ans(ser);
setVisible(false);
}
}
catch(Exception e)
{
System.out.println(e);
}
}else{JOptionPane.showMessageDialog(null,"please select an option");}
}}
else
{
  new Hind();
  setVisible(false);
}
}catch(Exception e){System.out.println(e);}

}
}


class Adduser extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4;
JTextField t1,t2,t3,t4;
JButton b1;
Font f;
Panel p1=new Panel();
Panel p2=new Panel();
Panel p3=new Panel();
Panel p4=new Panel();
String mname,mmailid,mmobile,rgname,rgmailid,rgmobile;
public Adduser(String s1,String s2,String s3,String s4,String s5,String s6)
{
mname=s1;
mmailid=s2;
mmobile=s3;
rgname=s4;
rgmailid=s5;
rgmobile=s6;
setVisible(true);
setLayout(new FlowLayout(FlowLayout.CENTER,500,100));
setSize(1000,1000);
p1.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
p2.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
p3.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
p4.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
l1=new JLabel("student name");
l2=new JLabel("mail id");
l3=new JLabel("mobile no");
l4=new JLabel("enter Search keywords");
t1=new JTextField(30);
t2=new JTextField(30);
t3=new JTextField(30);
t4=new JTextField("Enter atleast 5 words seperated with Comma(,)",40);
b1=new JButton("Add Student");
f=new Font("Comic Sans MS",Font.PLAIN,15);
l1.setFont(f);
l2.setFont(f);
l3.setFont(f);
t1.setFont(f);
t2.setFont(f);
t3.setFont(f);
b1.setFont(f);
p1.add(l1);
p1.add(t1);
p1.add(l2);
p1.add(t2);
p1.add(l3);
p1.add(t3);
p2.add(l1);
p2.add(t1);
p2.add(l2);
p2.add(t2);
p2.add(l3);
p2.add(t3);
p3.add(l4);
p3.add(t4);
p4.add(b1);
add(p1);
add(p2);
add(p3);
add(p4);
t1.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {

         if(!(Character.isLetter(evt.getKeyChar()))){
                evt.consume();
            }
        }
    });
//mobiles numbers validation
t3.addKeyListener(new KeyAdapter(){
 public void keyTyped(KeyEvent e)
 {
   char input=e.getKeyChar();
   if((input<'0'||input>'9')&&input!='\b')
   {
     e.consume();
   }
  }});
  t4.addMouseListener(new MouseAdapter(){
public void mouseClicked(MouseEvent e) {
if(t4.getText().equals("Enter atleast 5 words seperated with Comma(,)"))
t4.setText("");
  }
});
b1.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
try
{
if(b1.equals(ae.getSource()))
  {
DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
PreparedStatement p=c.prepareStatement("insert into reg values(?,?,?,?,?,?,?,?,?,?)");

p.setString(1,t1.getText());
p.setString(2,t2.getText());
p.setString(3,t3.getText());
p.setString(4,mname);
p.setString(5,mmailid);
p.setString(6,mmobile);
p.setString(7,rgname);
p.setString(8,rgmailid);
p.setString(9,rgmobile);
p.setString(10,t4.getText());
int tt=p.executeUpdate();
if(tt==1)
JOptionPane.showMessageDialog(null,"Registered Successfully");
c.close();
p.close(); 
new Hind();
setVisible(false);
}
}
catch(Exception e)
{
System.out.println(e);
}
}
}






					
 

class Ans extends JFrame 
{
TextArea a;
JButton b1,b2;
JCheckBox c1,c2;
Font f;
JScrollPane scroll;
Panel p1=new Panel();
Panel p2=new Panel();
Panel p3=new Panel();
String mnop;
public Ans(String rev)
{
mnop=rev;
setVisible(true);
setLayout(new FlowLayout(FlowLayout.LEFT));
setSize(1000,1000);
p1.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
p2.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
p3.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
a=new TextArea(50,100);
JScrollPane scrollableTextArea = new JScrollPane(a);
b1=new JButton("send E-mail");
b2=new JButton("Log Report");
c1=new JCheckBox("subscribe for mail");
c2=new JCheckBox("unsubscribe for mail");
scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
a.setText(mnop);
a.setEditable(true);
p1.add(scrollableTextArea); 
p2.add(b1);
p2.add(b2);
p3.add(c1);
p3.add(c2);
add(p1);
add(p2);
add(p3);
add(scroll);
}
}


