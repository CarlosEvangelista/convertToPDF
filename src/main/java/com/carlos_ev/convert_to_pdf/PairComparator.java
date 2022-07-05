package com.carlos_ev.convert_to_pdf;

import java.util.Comparator;

import com.itextpdf.text.Image;

public class PairComparator implements Comparator<Pair<String,Image>> {


	@Override
	public int compare(Pair<String, Image> o1, Pair<String, Image> o2) {
		return o1.getLeft().compareTo(o2.getLeft());
				
				
		//o1.getLeft().split("\\p{Punct}")[0])-Integer.parseInt(o2.getLeft().split("\\p{Punct}")[0]);
	}

}
