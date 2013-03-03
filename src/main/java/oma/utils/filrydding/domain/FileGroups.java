package oma.utils.filrydding.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FileGroups extends HashMap<String, FileGroup<PictureFile>> {

    private static final long serialVersionUID = 1L;

	public FileGroup<PictureFile> getFileGroup(String key) {
		FileGroup<PictureFile> filesFound = new FileGroup<>();

		if (containsKey(key)) {
			filesFound = get(key);
		}

		return filesFound;
	}

	public void addFileToGroup(String key, PictureFile file) {
		if (super.containsKey(key)) {
			super.get(key).add(file);
		} else {
			FileGroup<PictureFile> files = new FileGroup<PictureFile>();
			files.add(file);
			super.put(key, files);
		}
	}

	public FileGroups getGroupsWithMoreThanOneFile() {

		FileGroups groupsWithDuplicates = new FileGroups();

		Iterator<Entry<String, FileGroup<PictureFile>>> iterator = super.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, FileGroup<PictureFile>> entry = iterator.next();
			if (entry.getValue().size() > 1) {
				groupsWithDuplicates.put(entry.getKey(), entry.getValue());
			}
		}

		return groupsWithDuplicates;
	}

}
