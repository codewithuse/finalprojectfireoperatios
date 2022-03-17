package finalProject;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe 
{
	
	static final String projectFilesPath = "D:\\Notes";	
	
	/**
	 *  This Method will display the menu for end users
	 */
	static void displayMenu()
	{
		System.out.println("****************************");
		System.out.println("\tWelcome to LockedMe.com Secure App");
		System.out.println("\tDeveloped by:Vaibhav");
		System.out.println("****************");
		System.out.println("\t1. Display All The Files");
		System.out.println("\t2. Add A New File");
		System.out.println("\t3. Delete A File");
		System.out.println("\t4. Search A File");
		System.out.println("\t5. Exit");
		System.out.println("****************************");

	}
	/**
	 *  This Method will show all the files
	 */
	public static void getAllFiles()
	{
		File file =  new File(projectFilesPath);
		File[] listOfFiles =  file.listFiles();
		if(listOfFiles.length>0)
		{	
			
			System.out.println("Files List is below:\n");
		for(var l:listOfFiles)
		{
			System.out.println(l.getName()); // give the files name
		}
		}
		else
		{
			System.out.println("The folder is empty");
		}
	}
	/**
	 *  This Method will create the new file
	 */
	public static void createFiles()
	{
		try
		{
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter the file name:");
		fileName =  obj.nextLine();
		
		int linesCount;
		System.out.println("Enter How many lines in a file");
		linesCount = Integer.parseInt(obj.nextLine());
		
		FileWriter fw  =  new FileWriter(projectFilesPath+"\\"+fileName);
		
		// Read line by line from User
		
		for(int i=1;i<=linesCount;i++)
		{
			System.out.println("Enter file line:");
			fw.write(obj.nextLine()+"\n");
		}
		System.out.println("File Created Succesfully");
		fw.close();
		}
		catch(Exception Ex)
		{
			
		}
	}
	public static boolean checkFileExists(String fileName)
	{
		ArrayList<String> allFilesName  = new ArrayList<String>();
		File file =  new File(projectFilesPath);
		File[] listOfFiles =  file.listFiles();
		if(listOfFiles.length>0)
		{	
			
			System.out.println("Files List is below:\n");
		for(var l:listOfFiles)
		{
			allFilesName.add(l.getName()); // give the files name
			
		}
		}
		return allFilesName.contains(fileName);
		
	}
	/**
	 *  This Method will delete the file as per user request
	 */
	public static void deleteFiles()
	{
		try
		{
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter the file name to be deleted:");
		fileName =  obj.nextLine();
		File f  = new File(projectFilesPath+"\\"+fileName);
		
		if(checkFileExists(fileName))
		{
			
			f.delete();
			System.out.println("File Deleted Successfully");
		}
		else
		{
			System.out.println("File does not exist");
		}
		}
		catch(Exception ex)
		{
			System.out.println("Unable to delete file -Plesae contact Admin");
		}
		
	}
	
	
	public static void searchFiles()
	{
		try
		{
		Scanner obj = new Scanner(System.in);
		String fileName;
		System.out.println("Enter the file name to be searched:");
		fileName =  obj.nextLine();
		
		
				if(checkFileExists(fileName))
				{
					System.out.println("File is available");
				}
				else
				{
					System.out.println("File is not available");
				}
		}
		catch(Exception Ex)
		{	
			
		}
		
		}
}

