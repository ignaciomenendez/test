package org.restlet2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Resource which has only one representation.
 * 
 */
public class UsersDates extends ServerResource {
	
	private String finalName;

    @Get
    public String getDates() {
        
    	
    	AdressBookAccess adressBook = new AdressBookAccess();
    	List <User> users=adressBook.getData();
    	int counter = 0;
    	Date date1;
    	Date date2 = null;
    	Date finalDate;
    	String name1="";
    	String name2="";
    	
    	SortedSet <User> dates = null;
    	User user;
    	User user2;
    	
     	Iterator<User> iterator = users.iterator();
     	
     	
    	while (iterator.hasNext()) {

        user= iterator.next();
             
    		name1=user.getName();
    		 date1=user.getBirthday();
    		 finalName=user.getName();
    	
    		if(iterator.hasNext())
    		{
    			user2=iterator.next();
    			date2=user2.getBirthday();
    		    			
    			if(date1.compareTo(date2)<0){
            		finalName=user.getName();
            	}
    			else
    				finalName=user2.getName();
   	            
    	}
    
    	
  
    	

    	}
    	  return "The older person is: "+finalName;
    }
}