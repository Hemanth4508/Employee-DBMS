package costomexception;

public class EmptyDataBase extends RuntimeException
{
	private String message;
	public EmptyDataBase(String message)
	{
		this.message= message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}
	
	

}
