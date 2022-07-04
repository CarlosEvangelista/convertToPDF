package text;

import java.util.PriorityQueue;

import com.itextpdf.text.Image;

public class Main {
	public static void showHelp() {
		System.out.println("------------------------------------------------\nUsage: convertToPDF (Folder_with_source_images||Folder_with_source_images_odds Folder_with_source_images_pair) OutputFilePath Extension\n------------------------------------------------");
	}
	public static void main(String[] args) {
		if(args.length==3||args.length==4) {
			String root = args[0];
			
			PriorityQueue<Pair<String,Image>> allFilesSorted =  BuscarArchivos.listFiles(root,new FilterByExtn(args[args.length-1]),new PairComparator());
			boolean res = false;
			if(args.length==3) {				
				res = DocumentCreator.generateDocument(args[1], allFilesSorted);			
			}else {				
				String rootO = args[1];
				PriorityQueue<Pair<String,Image>> allFilesSortedO = BuscarArchivos.listFiles(rootO,new FilterByExtn(args[args.length-1]),new PairComparatorInv());
				res = DocumentCreator.generateDocument(args[2], allFilesSorted,allFilesSortedO);			
			}									
			if(!res) {
				System.err.println("------------------------------------------------\nError al crear el documento.\n------------------------------------------------");
			}else {
				System.out.println("------------------------------------------------\n…xito al crear el documento.\n------------------------------------------------");
			}
		}else {
			showHelp();
		}

	}
}

