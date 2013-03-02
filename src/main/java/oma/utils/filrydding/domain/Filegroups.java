package oma.utils.filrydding.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Filegroups {
	private Map<String, List<PictureFile>> fileGroups = new HashMap<>();

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

	public Map<String, List<PictureFile>> getFileGroups() {
		return fileGroups;
	}

	public Map<String, List<PictureFile>> getGroupsWithMoreThanOneFile() {

		Map<String, List<PictureFile>> groupsWithDuplicates = new HashMap<>();

		Iterator<Entry<String, List<PictureFile>>> iterator = fileGroups.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, List<PictureFile>> entry = iterator.next();
			if (entry.getValue().size() > 1) {
				groupsWithDuplicates.put(entry.getKey(), entry.getValue());
			}
		}

		return groupsWithDuplicates;
	}

}
