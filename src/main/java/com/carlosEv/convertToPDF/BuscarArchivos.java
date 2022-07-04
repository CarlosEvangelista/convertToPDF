package text;
import java.io.*;

import java.net.MalformedURLException;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;


public class BuscarArchivos {
			
		public static PriorityQueue<Pair<String,Image>> listFiles(String loc,FilenameFilter f,Comparator<Pair<String,Image>> comp) {
			
			PriorityQueue<Pair<String,Image>> res = new PriorityQueue<>(comp);			
			File folder = new File(loc);
			
			if(!folder.isDirectory()){
				System.err.println("La carpeta no existe: " + loc);
				return res;
			}
			StringBuilder path = new StringBuilder();
			path.append(loc);
			path.append(System.getProperty("file.separator"));
			
			Pair<String,Image> t = null;
			for(String filename : (f!=null ? folder.list(f) : folder.list())) {
				try {
					
					String globalFilePath = path.toString()+filename;
					Image image = Image.getInstance(globalFilePath);
					image.setAbsolutePosition(0, 0);
					image.setBorderWidth(0);
					image.scaleAbsolute(PageSize.A4);
					t = new Pair<>(filename,image);
					res.add(t);
				} catch (BadElementException e) {
					e.printStackTrace();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}				
			return res;
		}
					

		
}
