package com.carlos_ev.convert_to_pdf;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByExtn implements FilenameFilter {

	private String ext;

	public FilterByExtn(String ext) {
		this.ext = ext;
	}
	
	public boolean accept(File loc, String name) {
		if(name.lastIndexOf('.')>0)
        {
           
           int lastIndex = name.lastIndexOf('.');
           
          
           String str = name.substring(lastIndex);
           
          
           if(str.equalsIgnoreCase(ext))
           {
              return true;
           }
        }
        return false;
		
	}
	
	
}