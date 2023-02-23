package edbms;
import java.util.Scanner;

import costomexception.InvalidChoice;

class Solution 
{
	public static void main(String[] args) 
	{
		Scanner S=new Scanner(System.in);
		EmployeeManagementSystem EMS=new EmployeeManagementSystemImpl();
		while(true)
		{
			System.out.println("Enter\n 1:To add Employee\n 2:To display Employee \n 3:To display all the Employees \n 4:To remove Employee \n 5:To remove All the Employees \n 6:To count the Employees \n 7: To sort the Employees \n 8:To update Employee \n 9: To get Employee with highest Salary \n 10: To get Employee with lowest Salary\n 11: To exit ");
			int option=S.nextInt();
			switch(option)
			{
			case 1:EMS.addEmployee();break;
			case 2:EMS.displayEmployee();break;
			case 3:EMS.dispalyAll();break;
			case 4:EMS.removeEmployee();break;
			case 5:EMS.removeAll();break;
			case 6:EMS.countEmployees();break;
			case 7:EMS.sortEmployee();break;
			case 8:EMS.updateEmployee();break;
			case 9:EMS.getEmployeeeWithHighestSal();break;
			case 10:EMS.getEmployeeeWithLowestSal();break;
			case 11:System.exit(0);
			default :
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

	

}
