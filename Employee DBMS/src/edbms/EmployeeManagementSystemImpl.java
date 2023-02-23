package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import costomexception.EmployeeNotFound;
import costomexception.EmptyDataBase;
import costomexception.InvalidChoice;
import costomsorting.SortByAge;
import costomsorting.SortById;
import costomsorting.SortByName;
import costomsorting.SortBySalary;

class EmployeeManagementSystemImpl implements EmployeeManagementSystem
{
	Scanner S=new Scanner(System.in);
	LinkedHashMap<String,Employee>DB=new LinkedHashMap<String,Employee>();


	@Override
	public void addEmployee() 
	{
		System.out.println("Enter the age");
		int age=S.nextInt();
		System.out.println("Enter the name");
		String name =S.next();
		System.out.println("Enter the sal");
		double sal=S.nextDouble();
		Employee E=new Employee(name,age,sal);
		DB.put(E.getId(),E);
		System.out.println("Employee Inserted Sucessfully with id "+E.getId());



	}

	@Override
	public void displayEmployee() 
	{
		System.out.println("Enter the id to Display");
		String Sid=(S.next()).toUpperCase();
		if(DB.containsKey(Sid))
		{
			System.out.println(DB.get(Sid));
		}
		else
		{
			try
			{
				throw new EmployeeNotFound("Employee id No found");
			}
			catch(EmployeeNotFound E)
			{
				System.out.println(E.getMessage());
			}
		}

	}

	@Override
	public void dispalyAll() 
	{
		Set<String> sk= DB.keySet();
		for(String S:sk)
		{
			System.out.println(DB.get(S));
		}	
	}

	@Override
	public void removeEmployee()
	{
		System.out.println("Enter the id to Remove");
		String Sid=(S.next()).toUpperCase();
		if(DB.containsKey(Sid))
		{
			DB.remove(Sid);
			System.out.println("The Employee with id "+Sid+" removed sucessfully.");
		}
		else
		{
			try
			{
				throw new EmployeeNotFound("Employee id No found");
			}
			catch(EmployeeNotFound E)
			{
				System.out.println(E.getMessage());
			}
		}		
	}
	@Override
	public void removeAll() 
	{
		if(DB.size()<=0)
		{
			try
			{
				throw new EmptyDataBase("There is no employees to remove");
			}
			catch(EmptyDataBase edb)
			{
				System.out.println(edb.getMessage());
			}

		}
		else
		{
			DB.clear();
			System.out.println("All the employees removed Sucessfully");

		}

	}

	@Override
	public void countEmployees() 
	{
		if(DB.size()<=0)
		{
			try
			{
				throw new EmptyDataBase("There is no employees to count");
			}
			catch(EmptyDataBase edb)
			{
				System.out.println(edb.getMessage());
			}
		}
		else
		{
			System.out.println("there are "+DB.size()+" number of employee  present in the DataBase");

		}


	}

	@Override
	public void sortEmployee() 
	{
		System.out.println("Enter 1.To sort employees by Id 2. To sort Employees by age 3.To sort Employees by name 4.To sort employess by salaray");
		int opt=S.nextInt();
		Set<String> Sk=DB.keySet();
		List<Employee> al=new ArrayList<Employee>();
		for(String S :Sk)
		{
			al.add(DB.get(S));
		}
		
		switch(opt)
		{
		case 1:
			Collections.sort(al,new SortById());
			display(al);
			break;
		case 2:
			Collections.sort(al,new SortByAge());
			display(al);
			break;
		case 3:
			Collections.sort(al,new SortByName());
			display(al);
			break;
		case 4:
			Collections.sort(al,new SortBySalary());
			display(al);
			break;
		default:
			try 
			{
				throw new InvalidChoice("Invalid choice !");
			}
			catch(InvalidChoice I)
			{
				System.out.println(I.getMessage());
			}
		}
		



	}
	public void display(List<Employee> al)
	{
		for(Employee E :al)
		{
			System.out.println(E);
		}
	}

	@Override
	public void updateEmployee() 
	{
		System.out.println("Enter the id to Update");
		String Sid=(S.next()).toUpperCase();
		if(!DB.containsKey(Sid))
		{
			try
			{
				throw new EmployeeNotFound("Employee id No found");
			}
			catch(EmployeeNotFound E)
			{
				System.out.println(E.getMessage());
			}
		}
		else
		{
			Employee E=DB.get(Sid);
			System.out.println("Details : "+E);
			System.out.println("To Update 1. Age 2.Name 3. Sal ");
			int opt=S.nextInt();
			switch(opt)
			{
			case 1:
				System.out.println("Enter the age to update");
				int age=S.nextInt();
				E.setAge(age);
				DB.put(Sid, E);
				System.out.println("Age updated sucessfully");
				break;
				
			case 2:
				System.out.println("Enter the Name to update");
				String name=S.next();
				E.setName(name);
				DB.put(Sid, E);
				System.out.println("Name updated Sucessfully");
				break;
			case 3:
				System.out.println("Enter the Salary to update");
				String name1=S.next();
				E.setName(name1);
				DB.put(Sid, E);
				System.out.println("Salary updated Sucessfully");
				break;
				default:
					try 
					{
						throw new InvalidChoice("Invalid choice! Enter the choice correctly");
					}
					catch(InvalidChoice I)
					{
						System.out.println(I.getMessage());
					}
					
			}
			
			




		}


	}

	@Override
	public void getEmployeeeWithHighestSal() 
	{
		
		Set<String> Sk=DB.keySet();
		List<Employee> al=new ArrayList<Employee>();
		for(String S :Sk)
		{
			al.add(DB.get(S));
		}
		Collections.sort(al,new SortBySalary());
		System.out.println("Employee with Highest Salary");
		System.out.println(al.get(0));
		System.out.println(al.get(al.size()-1));

	}

	@Override
	public void getEmployeeeWithLowestSal()
	{
		Set<String> Sk=DB.keySet();
		List<Employee> al=new ArrayList<Employee>();
		for(String S :Sk)
		{
			al.add(DB.get(S));
		}
		Collections.sort(al,new SortBySalary());
		System.out.println("Employee with Lowest Salary");
		System.out.println(al.get(0));


	}


}
