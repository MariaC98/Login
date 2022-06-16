import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
  
class Login extends JFrame implements ActionListener
 {
  JButton ingresar,registrar;
  JPanel panel;
  JLabel label1,label2;
  final JTextField  text1,text2;
   Login(){ //constructor
   label1 = new JLabel();
   label1.setText("Username:");
   text1 = new JTextField(15);
 
   label2 = new JLabel();
   label2.setText("Password:");
   text2 = new JPasswordField(15);
  
   ingresar=new JButton("Ingresar");
   registrar=new JButton("Registrar");
   
   panel=new JPanel(new GridLayout(3,1));
   panel.add(label1);
   panel.add(text1);
   panel.add(label2);
   panel.add(text2);
   panel.add(ingresar);

   add(panel,BorderLayout.CENTER);
   ingresar.addActionListener(this);
   registrar.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			System.out.print(" ... ");
		
	}
	   
   });
   panel.add(registrar);
   setTitle("LOGIN");
   }
  public void actionPerformed(ActionEvent ae)
   {
	  Conexion conn=new Conexion();
	  String value1=text1.getText();
	  String value2=text2.getText();
	  String sql="SELECT * FROM usuario where correo="+"'"+value1+"'"+" and "+ "contrasenia="+"'"+value2+"'";
	  try {
		ResultSet rs=conn.devolverConsulta(sql);
	
		if(rs.next()) {
				
			
			String Name =rs.getNString("nombre");
			String apellido =rs.getString("apellido");
			 NextPage page=new NextPage();
			   page.setVisible(true);
			   JLabel label = new JLabel("Welcome:"+Name+" " + apellido);
			   page.getContentPane().add(label);
			
		}else{
			   System.out.println("enter the valid username and password");
			   JOptionPane.showMessageDialog(this,"Incorrect login or password",
			   "Error",JOptionPane.ERROR_MESSAGE);
			   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

   
 }
 }
