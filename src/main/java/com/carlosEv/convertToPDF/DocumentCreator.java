package text;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.PriorityQueue;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;

import com.itextpdf.text.pdf.PdfWriter;


public class DocumentCreator {

	 private DocumentCreator() {
		    throw new IllegalStateException("DocumentCreator is not meant to be instantiated.");
	 }
	
	public static boolean generateDocument(String destPath,PriorityQueue<Pair<String,Image>> allFilesSorted) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(new File(destPath)));
		} catch (FileNotFoundException e1) {
			return false;
		} catch (DocumentException e1) {
			return false;
		}
		document.open();
		System.out.println("Leyendo imágenes...");
		if(allFilesSorted.isEmpty()) {
			System.err.println("AVISO: No se han encontrado ficheros con la extensión proporcionada");
		}
		while(!allFilesSorted.isEmpty()) {
			Pair<String,Image> file = allFilesSorted.poll();
			document.newPage();
			
			System.out.println(file.getLeft());
			try {
				document.add(file.getRight());
			} catch (DocumentException e) {
				return false;
			}
		}
		document.close();
		return true;
	}
	
	public static boolean generateDocument(String destPath,PriorityQueue<Pair<String,Image>> oddsSorted,PriorityQueue<Pair<String,Image>> pairsSorted) {
		Document document = new Document(); 
		try {
			PdfWriter.getInstance(document, new FileOutputStream(new File(destPath)));
		} catch (FileNotFoundException e1) {
			return false;
		} catch (DocumentException e1) {
			return false;
		}
		document.open();		

		System.out.println("Leyendo imágenes...");
		int imp = oddsSorted.size();
		int par = pairsSorted.size();
		while(!oddsSorted.isEmpty()) {						
			try {
				Pair<String,Image> file = oddsSorted.poll();
				document.newPage();				
				System.out.println(file.getLeft());
				document.add(file.getRight());
				if(!pairsSorted.isEmpty()) {
					Pair<String,Image> file2 = pairsSorted.poll();
					document.newPage();				
					System.out.println("\t\t"+file2.getLeft());
					document.add(file2.getRight());
				}
			} catch (DocumentException e) {
				return false;
			}
		}
		System.out.println("\n"+imp +" páginas impares generadas");
		System.out.println(par +" páginas pares generadas");
		document.close();
		return true;
	}
}
		