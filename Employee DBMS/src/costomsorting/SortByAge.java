package costomsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortByAge implements Comparator<Employee>
{

	@Override
	public int compare(Employee o1, Employee o2)
	{

		return o1.getAge()-o2.getAge();
	}
	

	

}
