package costomsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortBySalary implements Comparator<Employee>
{


	@Override
	public int compare(Employee o1, Employee o2) 
	{
		
		
		return o1.getSal().compareTo(o2.getSal());
	}
	
 
	

}
