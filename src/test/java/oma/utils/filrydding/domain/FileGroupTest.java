package oma.utils.filrydding.domain;

import static oma.utils.filrydding.ObjectMother.pictureFile_2010_08_22_13_12_13;
import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class FileGroupTest {

	@Rule
	public TemporaryFolder tmpFolder = new TemporaryFolder();

	@Test
	public void shallBeAbleToHoldPictureFiles() {
		FileGroup<PictureFile> fileGroup = new FileGroup<PictureFile>();
		fileGroup.add(pictureFile_2010_08_22_13_12_13);
		assertThat(fileGroup).hasSize(1);
	}

	@Test
	public void shallReturnThePictureFileWithTheLargestSize() throws IOException {
		PictureFile smallestPictureFile = new PictureFile(tmpFolder.getRoot(), "123-smallestFile.txt");
		PictureFile mediumPictureFile =new PictureFile(tmpFolder.getRoot(),"123-mediumFile.txt");
		PictureFile largestPictureFile = new PictureFile(tmpFolder.getRoot(),"123-largestFile.txt");
		
		writeTextToFile(smallestPictureFile, "foo");
		writeTextToFile(mediumPictureFile, "foofoo");
		writeTextToFile(largestPictureFile, "foofoofoo");

		FileGroup<PictureFile> fileGroups = new FileGroup<>();
		fileGroups.add(smallestPictureFile);
		fileGroups.add(mediumPictureFile);
		fileGroups.add(largestPictureFile);
		
		assertThat(fileGroups.getLargestFile()).isEqualTo(largestPictureFile);
		
	}
	
	@Test
	public void shallReturnTheOnlyfileInTheList() throws IOException {
		PictureFile smallestPictureFile = new PictureFile(tmpFolder.getRoot(), "123-smallestFile.txt");
		
		writeTextToFile(smallestPictureFile, "foo");

		FileGroup<PictureFile> fileGroups = new FileGroup<>();
		fileGroups.add(smallestPictureFile);
		
		assertThat(fileGroups.getLargestFile()).isEqualTo(smallestPictureFile);
		
	}

	private void writeTextToFile(File smallestFile, String text) throws IOException {
		FileWriter fileWriter = new FileWriter(smallestFile);
		fileWriter.write(text);
		fileWriter.close();
	}
}
