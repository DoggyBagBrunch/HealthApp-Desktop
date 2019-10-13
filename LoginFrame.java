import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class LoginFrame extends JFrame implements ActionListener{
   private static final long serialVersionUID = 1L;
   private JTextField username, password;
   private JButton login;
   private JLabel label1;
   private JLabel label2;
   
   public static void main(String[] args) {
	      new LoginFrame();
   }
   
   LoginFrame() {
	  label1 = new JLabel("Username: ");
	  label2 = new JLabel("Password: ");
      username = new JTextField("", 20);
      password = new JTextField("", 20);
      login = new JButton("Login");
      login.addActionListener(this);
      username.addActionListener(this);
      password.addActionListener(this);
      
      this.setTitle("Please enter your login info");
      this.setLayout(new FlowLayout());
      this.setLocation(300, 300);
  	  setSize(350,300);
  	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	  setResizable(false);
  	  
  	  add(label1);
  	  add(username);
  	  add(label2);
  	  add(password);
  	  add(login);
  	  setVisible(true);
   }
   public void actionPerformed(ActionEvent e) {
	   if(e.getSource()==login){
		   String u = username.getText();
		   String p = password.getText();
		   
		   if(u.equals("a") && p.equals("b")) {
			   System.out.println("You logged in");
			   this.dispose();
			   new MainFrame();
		   }else{
			   System.out.println("Incorrect");
		   }
		   /*
		   byte [] res = new byte[20];
		   try {
			   res = hashPassWord(p);
			   for(byte b : res) {
				   System.out.print(b);
			   }
			   System.out.println();
		   } catch (NoSuchAlgorithmException e1) {}
		   */
	   }
   }
   public byte[] hashPassWord(String w) throws NoSuchAlgorithmException {
	   MessageDigest digest = MessageDigest.getInstance("SHA-256");
	   byte[] encodedHash = digest.digest(w.getBytes(StandardCharsets.UTF_8));
	   return encodedHash;
   }
}
