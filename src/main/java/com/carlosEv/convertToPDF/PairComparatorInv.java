package text;

import java.util.Comparator;

import com.itextpdf.text.Image;

public class PairComparatorInv implements Comparator<Pair<String,Image>> {


	@Override
	public int compare(Pair<String, Image> o1, Pair<String, Image> o2) {
		return o2.getLeft().compareTo(o1.getLeft());
				
				
		//o1.getLeft().split("\\p{Punct}")[0])-Integer.parseInt(o2.getLeft().split("\\p{Punct}")[0]);
	}

}
