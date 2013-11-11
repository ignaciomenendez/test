package org.restlet2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Resource which has only one representation.
 * 
 */
public class AdressBookAccess  {

   
    public List<User> getData() {
    	    	
    	
    	//The adressbook files must be in a folder with the name test
    	//final File folder = new File("c://AddressBook.txt");
	   // final List<File> fileList = Arrays.asList(folder.listFiles());
	    
	    
	  //  final Iterator<File> it = fileList.iterator();
	    File file = new File("c://test//AddressBook.txt");
	
	 

	FileInputStream fstream = null;
	try {
		fstream = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	DataInputStream in = new DataInputStream(fstream);
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	String strLine;
	String[] ar = null;
	List <User> users=new ArrayList<User>();
	User user=null;
	
	
	try {
		while ((strLine = br.readLine()) != null)   {
			
			ar=strLine.split(",");
			
			user=new User();
			user.setName(ar[0]);
			user.setGender(ar[1]);
			try {
				user.setBirthday(getBirthday(ar[2]));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           users.add(user);
		
		   
		}
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		in.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    	
  
    
    return users;


    
    }

	private Date getBirthday(String ar) throws ParseException {
		// TODO Auto-generated method stub
		Date date=null;
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yy");
		
		date=sdf.parse(ar);
		return date;
	}
}