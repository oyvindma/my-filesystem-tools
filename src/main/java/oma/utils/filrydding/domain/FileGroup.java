package oma.utils.filrydding.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class FileGroup<T extends File> extends ArrayList<T> {
	private static final long serialVersionUID = 1L;

	public T getLargestFile() {

		T largest = null;
		Iterator<T> iterator = iterator();
		while (iterator.hasNext()) {
			T element = iterator.next();
			if (largest == null) {
				largest = element;
			} else if (largest.length() < element.length()) {
				largest = element;
			}
		}

		return largest;
	}

}