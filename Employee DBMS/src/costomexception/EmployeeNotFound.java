package costomexception;

public class EmployeeNotFound extends Exception
{
	private String message;
	public EmployeeNotFound(String message)
	{
		this.message=message;
	}
	@Override
	public String getMessage()
	{
		return this.message;
	}

	

}
