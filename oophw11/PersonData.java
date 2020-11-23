package oophw11;
import java.awt.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PersonData implements java.io.Serializable {
	private String Name;
	private String PhoneNumber;
	private String DateBirth;
	private String Email;
	
	PersonData (String N,String PN,String DB,String E)
	{
		Name=N;
		PhoneNumber=PN;
		DateBirth=DB;
		Email=E;
	}
	PersonData()
	{
		
	}
	public void WriteData(java.util.List<PersonData> PL)
	{
		try {
		      FileOutputStream FOS = new FileOutputStream("PersonData.txt");
		      ObjectOutputStream output = new ObjectOutputStream(FOS);
		      
		      for(int a=0; a<PL.size();a++)
		    	  output.writeObject(PL.get(a));
		      output.close();
		      FOS.close();
		    } catch (IOException z) {
		      z.printStackTrace();
		    }
	}
	public ArrayList<PersonData> ReadData()
	{
		ArrayList<PersonData>PersonList  =new ArrayList<PersonData>();
		try
		{
			
		FileInputStream inputstream = new FileInputStream("PersonData.txt");
		ObjectInputStream objinput = new ObjectInputStream(inputstream);

		PersonData object1=(PersonData) objinput.readObject();
		while(object1!=null)
		{
			PersonList.add(object1);

			 object1=(PersonData) objinput.readObject();
	
		}
		 inputstream.close();
			objinput.close();
		}
		catch (Exception e)
			{
					System.out.println("All data was read");
			}
		return PersonList;
		
	}
	String GetName()
	{
		return Name;
	}
	public String  GetNumber()
	{
		return PhoneNumber;
	}
	public String DOB()
	{
		return DateBirth;
	}
	
	public String EmailAddress()
	{
		return Email;
	}
	
	
	public void SetName(String NN)
	{
		Name=NN;
	}
	public void SetNumber(String pn)
	
	{
		PhoneNumber=pn;
	}
	
	public void SetDOB(String d)
	{
		DateBirth=d;		
	}
	public void SetEmail(String E)
	{
		Email=E;
	}

}
