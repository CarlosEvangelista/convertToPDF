package text;
import java.io.*;
public class BuscarArchivo {
	
		private static String fileLocation = "";
		
		//Extension .png, .jpeg, .xml etc
		private static final String searchThisExtn = ".jpg";

		public static void main(String args[]) {
			BuscarArchivo obj = new BuscarArchivo();
			obj.listFiles(fileLocation, searchThisExtn,0);
		}

		public String listFiles(String loc, String extn, int pos) {

			SearchFiles files = new SearchFiles(extn);

			File folder = new File(loc);

			if(folder.isDirectory()==false){
				System.out.println("La carpeta no existe: " + fileLocation);
				return "";
			}

			String[] list = folder.list(files);

			if (list.length == 0) {
				System.out.println("No hay archivos con la extension " + extn);
				return "";
			}
			
				String temp = list[pos];
				return temp;
		}
		
		
		

		public class SearchFiles implements FilenameFilter {

			private String ext;

			public SearchFiles(String ext) {
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
}
