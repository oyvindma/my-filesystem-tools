package oma.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import com.google.common.io.Files;

import oma.utils.filrydding.FileService;
import oma.utils.filrydding.FilenameTransformer;
import oma.utils.filrydding.domain.FileGroup;
import oma.utils.filrydding.domain.FileGroups;
import oma.utils.filrydding.domain.PictureFile;
import oma.utils.repository.FileRepositoryImpl;
import oma.utils.repository.MobilephotoFilenamefilter;

public class MyApp {
	public static void main(String[] args) throws IOException {
		FileService fileFinderService = new FileService(new FileRepositoryImpl());
		File parentDirectory = new File("/home/oyvindma/Pictures/mobilbilder");
		FilenameFilter filenameFilter = new MobilephotoFilenamefilter();
		FilenameTransformer transformer = new FilenameTransformer();

		FileGroups filesGroupedByTransformedFilename = fileFinderService.getFilesGroupedByTransformedFilename(parentDirectory,
		        filenameFilter, transformer);

		FileGroups groupsWithMoreThanOneFile = filesGroupedByTransformedFilename.getGroupsWithMoreThanOneFile();

		Iterator<Entry<String, FileGroup<PictureFile>>> iterator = filesGroupedByTransformedFilename.entrySet().iterator();
		StringBuilder filesToKeep = new StringBuilder();
		File target = new File("mob/files-to-keep/");
			while (iterator.hasNext()) {
				Entry<String, FileGroup<PictureFile>> entry = iterator.next();
				File largestFile = entry.getValue().getLargestFile();
//				Files.move(largestFile, new File(target.getAbsolutePath(), largestFile.getName()));
			}
		System.out.println("Files with duplicates:" + groupsWithMoreThanOneFile.size());
		System.out.println("Files to keep:" + filesGroupedByTransformedFilename.size());
	}

}
