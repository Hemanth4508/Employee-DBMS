package costomexception;

public class InvalidChoice extends RuntimeException
{
	private String message;
	public InvalidChoice(String message)
	{
		
		this.message=message;
	}
	@Override
	public String getMessage()
	{
		return this.message;
	}
	
	

}
