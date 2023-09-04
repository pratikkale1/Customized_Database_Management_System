import java.lang.*;
import java.util.*;

// create table student(RID int,Name varchar(255), Salary int)
//Database table /schema
class Student
{
	public int RID;
	public String Name;
	public int Salary;
	
	private static int Generator;
	
	static
	{
		Generator =0;
	}
	
	public Student(String str,int value)
	{
		this.RID = ++Generator;
		this.Name =str;
		this.Salary = value;
	}
	
	public void DisplayData()
	{
		
		System.out.println("|\t"+this.RID+"\t\t"+"|\t"+this.Name+"\t\t"+"|\t"+this.Salary+"\t\t"+"|");
		System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
	}
}

class MyDBMS
{
	public	LinkedList<Student> lobj;
	
	public MyDBMS()
	{
		lobj = new LinkedList<>();
	}

	public void StartDBMS()
	{
		Scanner Scanobj =  new Scanner(System.in);
		String Query ="";
		String str ="";
		
		System.out.println("Custamised DBMS Started successfully...");
		
		while(true)
		{
			System.out.print("DBMS Console >");
			Query = Scanobj.nextLine();
			str = Query.toLowerCase();
			
			
			String tokens[] = str.split(" ");
			int QuerySize = tokens.length;
			
			if(QuerySize == 1)
			{
				if("help".equals(tokens[0]))
				{
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("This Application use to demonstrates the Custamised DBMS System");
					System.out.println("Exit : Terminate DBMS");
					System.out.println("Display all Data : select * from student");
					System.out.println("insert Data: Insert into Student Name Salary");
					System.out.println("Display Specific Data by RID : Select * from student where RID = Student_RID");
					System.out.println("Display Specific Data by Name : Select * from student where Name = Student_Name");
					System.out.println("Delete Specific Data by Name : Delete from student where name = Student_Name");
					System.out.println("Delete Specific Data by RID : Delete from student where RID = RID_Number");
					System.out.println("Display Maximum : Select Max salary from student");
					System.out.println("Display Minimum : Select Min salary from student");
					System.out.println("Display Summation : Select Summation salary from student");
					System.out.println("Display Average : Select Average salary from student");
					System.out.println("Display Count : Select student count from student");
					System.out.println("-------------------------------------------------------------------------------");
				}
				else if("exit".equals(tokens[0]))
				{
					System.out.println("Thank you for using Custamised DBMS");
					return;
				}
			}
			else if(QuerySize == 5)
			{
				if("insert".equals(tokens[0]))
				{
					InsertData(tokens[3],Integer.parseInt(tokens[4]));
					System.out.println("1 Record Successfully Added...");
				}
				else if("max".equals(tokens[1])) // Select Max salary from student
				{
					AggregateMax();
				}
				else if("min".equals(tokens[1]))// Select Min salary from student
				{
					AggregateMin();
				}
				else if("summation".equals(tokens[1])) //Select Summation salary from student
				{
					AggregateSum();
				}
				else if("average".equals(tokens[1])) //Select Average salary from student
				{
					AggregateAvg();
				}
				else if("count".equals(tokens[2])) //Select student count from student
				{
					AggregateCount();
				}					
			}
			else if(QuerySize == 4)
			{
				if("select".equals(tokens[0]))
				{
					if("*".equals(tokens[1]))
					{
						System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
						System.out.println("|\t"+"RID Numbers"+"\t"+"|\t"+"Student Name"+"\t"+"|\t"+"Student Salary"+"\t"+"|\t");
						System.out.println(" __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __");
						DisplayAll();
						
					}
				}
			}
			else if(QuerySize == 8) // Select * from student where Name = Student_Name
			{
				System.out.println("entered");
				if("select".equals(tokens[0]))
				{
					if("name".equals(tokens[5]))
					{
						DisplaySpecific(tokens[7]);
					}
					else if("rid".equals(tokens[5]))
					{
						DisplaySpecific(Integer.parseInt(tokens[7]));
					}
				}
			}
			else if(QuerySize == 7) // Delete from student where RID = RID_NUMBER
			{
				if("delete".equals(tokens[0]))
				{
					if("rid".equals(tokens[4]))
					{
						DeleteSpecific(Integer.parseInt(tokens[6]));
						System.out.println("1 Record Successfully Removed...");
						
					}
					else if("name".equals(tokens[4]))
					{
						DeleteSpecific(tokens[6]);
						System.out.println("1 Record Successfully Removed...");
					}
				}
			}		

		}
	}
	
	public void InsertData(String str, int value)
	{
		Student sobj = new Student(str,value);
		lobj.add(sobj);
	}
	
	//Display ALL withour Condition.
	public void DisplayAll()
	{
		for(Student sref : lobj)
		{
			sref.DisplayData();
		}
	}
	//Display by RID
	public void DisplaySpecific(int rid)
	{
		for(Student sref : lobj)
		{
			if(sref.RID ==rid)
			{
				sref.DisplayData();
				break;
			}
		}		
	}
	
	//Display by Name
	public void DisplaySpecific(String str)
	{
		for(Student sref : lobj)
		{
			if(str.equals(sref.Name))
			{
				sref.DisplayData();	
			}
		}		
	}
	
	public void DeleteSpecific(int rid)  
	{
		int index =0;
		
		for(Student sref : lobj)
		{
				if(sref.RID == rid)
				{
					lobj.remove(index);
					break;
				}
				index++;
		}
	}
	
	//Delete by Name
	public void DeleteSpecific(String str)
	{
		int index =0;
		
		for(Student sref : lobj)
		{
			if(str.equals(sref.Name))
			{
				lobj.remove(index);
				break;
			}
			index++;
		}		
	}
	
	public void  AggregateMax()
	{
		int iMax =0;
		Student temp =null;
		
		for(Student sref : lobj)
		{
			if(sref.Salary>iMax)
			{
				iMax = sref.Salary;
				temp = sref;
			}
		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Information of Student having Maximum Salary : ");
		temp.DisplayData();
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	public void  AggregateMin()
	{
		int iMin =(lobj.getFirst()).Salary;
		Student temp =lobj.getFirst();
		
		for(Student sref : lobj)
		{
			if(sref.Salary < iMin)
			{
				iMin = sref.Salary;
				temp = sref;
			}
		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Information of Student having Minimum Salary : ");
		temp.DisplayData();
		System.out.println("-------------------------------------------------------------------------------");
	}

	public void  AggregateSum()
	{
		long iSum = 0;
		
		for(Student sref : lobj)
		{
			iSum = iSum+ sref.Salary;
		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Summation of Salaries is : "+iSum);
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	public void  AggregateAvg()
	{
		long iSum = 0;
		
		for(Student sref : lobj)
		{
			iSum = iSum+ sref.Salary;
		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Average Salary : "+iSum/(lobj.size()));
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	public void AggregateCount()
	{
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Count is : "+lobj.size());
		System.out.println("-------------------------------------------------------------------------------");
	}
}

class DBMS
{
	public static void main(String arg[])
	{
		MyDBMS dobj = new MyDBMS();
		dobj.StartDBMS();

	}
}