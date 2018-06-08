package edu.waketech.ccave.provided;

import org.jboss.serial.io.*;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import edu.waketech.ccave.item.CCaveItem;

public class SaveLoad {

   
	public static void save(Spelunker p){
	    try {
	
	        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("game.sav"));

	    	out.writeObject(p);;
	    	
	        out.close();
	
	    } catch (Exception e) {
	
	        System.out.print("Save failed");
	
	        e.printStackTrace();
	
	    }
	
	}
	
	 
	
	public static Spelunker load()
	
	{
	
	    try
	
	    {
	
	        ObjectInputStream in = new ObjectInputStream(new FileInputStream("game.sav"));
	
	        Object object = in.readObject();
	
	
	            object = (Spelunker) object;
	        
	         
	        in.close();
	        return (Spelunker) object;
	
	    } catch(Exception e) {
	
	        e.printStackTrace();
	        
	    }
		return null;

}


}
