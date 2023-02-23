package costomsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortById implements Comparator<Employee>
{

	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.getId().compareTo(o1.getId());
	}
	

	

}
