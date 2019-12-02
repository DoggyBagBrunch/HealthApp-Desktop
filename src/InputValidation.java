import java.util.regex.Pattern;
public class InputValidation {
	
	
	public boolean isValidUN( String input)
	{
		if (!Pattern.matches("[a-zA-Z0-9]{8,20}", input)) 
		{
			 System.out.println("Invalid UserName");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean isValidPW( String input)
	{
		if (!Pattern.matches("[a-zA-Z0-9]{8,}", input)) 
		{
			 System.out.println("Invalid Password");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean isValidName(String input)
	{
		if (!Pattern.matches("[a-zA-Z]{2,20}", input)) 
		{
			 System.out.println("Invalid Name");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean isValidEmail(String input)
	{
		if (!Pattern.matches("^(.+)@(.+)$", input))
		{
			 System.out.println("Invalid Email");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean isValidYear(int input)
	{
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
		if (! ( Pattern.matches("[0-9]{4}", Integer.toString(input)) && input <= 2020 ) )
		{
            System.out.println("Invalid Year");
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean isValidMonth(int input)
	{
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
		if (!(input > 0 && input < 13) )
		{
            System.out.println("Invalid Month");
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean isValidDay(int input)
	{
		if (!(input > 0 && input < 32))
		{
            System.out.println("Invalid Day");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean isValidSex(String input)
	{
		if (!Pattern.matches("[a-zA-Z]{0,10}", input))
		{
            System.out.println("Invalid Sex");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean isValidRace(String input)
	{
		if (!Pattern.matches("[a-zA-Z]{0,10}", input))
		{
            System.out.println("Invalid Race");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
}