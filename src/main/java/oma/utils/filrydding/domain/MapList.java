package oma.utils.filrydding.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapList {
	private HashMap<String, List<PictureFile>> fileGroups = new HashMap<>();

	public List<PictureFile> get(String key) {
		List<PictureFile> filesFound = new ArrayList<PictureFile>();

		if (fileGroups.containsKey(key)) {
			filesFound = fileGroups.get(key);
		}

		return filesFound;
	}

	public void put(String key, PictureFile file) {
		if (fileGroups.containsKey(key)) {
			get(key).add(file);
		} else {
			List<PictureFile> files = new ArrayList<>();
			files.add(file);
			fileGroups.put(key, files);
		}
	}

}
