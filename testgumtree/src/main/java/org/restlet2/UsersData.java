package org.restlet2;

import java.util.Iterator;
import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Resource which has only one representation.
 * 
 */
public class UsersData extends ServerResource {

    @Get
    public String getMales() {
        
    	
    	AdressBookAccess adressBook = new AdressBookAccess();
    	List <User> users=adressBook.getData();
    	int counter = 0;
    
    	
    	
    	
    	
    	Iterator<User> iterator = users.iterator();
    	while (iterator.hasNext()) {

        User user= iterator.next();
        
        System.out.println(user.getGender().equals(" Male"));
    	if(user.getGender().equals(" Male"))
    		counter++;
        
    	}
    
    	
    return "The number of males is: "+String.valueOf(counter);
    	
}
}