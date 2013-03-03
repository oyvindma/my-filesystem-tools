package oma.utils.filrydding.domain;

import static oma.utils.filrydding.ObjectMother.fileName_2010_08_28_18_19_19;
import static oma.utils.filrydding.ObjectMother.fileName_IMG_20100828_181919;
import static oma.utils.filrydding.ObjectMother.pictureFile_2010_08_22_13_12_13;
import static oma.utils.filrydding.ObjectMother.pictureFile_2010_08_28_18_19_19;
import static oma.utils.filrydding.ObjectMother.pictureFile_IMG_20100828_181919;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
public class FileGroupsTest {
	
	private String keyA = "A";
	private String keyB = "B";
	private FileGroups fileGroups;
	@Before
	public void initialize(){
		fileGroups = new FileGroups();
	}
	
	
	@Test
	public void shallNotGroupFilesWithDifferentKeys(){
		fileGroups.addFileToGroup(keyA, new PictureFile(fileName_2010_08_28_18_19_19));
		fileGroups.addFileToGroup(keyB, new PictureFile(fileName_IMG_20100828_181919));
		
		assertThat(fileGroups.getFileGroup(keyA)).hasSize(1);
		assertThat(fileGroups.getFileGroup(keyA).get(0).getName()).isEqualTo(fileName_2010_08_28_18_19_19);

		assertThat(fileGroups.getFileGroup(keyB)).hasSize(1);
		assertThat(fileGroups.getFileGroup(keyB).get(0).getName()).isEqualTo(fileName_IMG_20100828_181919);
	}
	
	@Test
	public void shallGroupFilesWithSameKey(){
		
		fileGroups.addFileToGroup(keyA, pictureFile_2010_08_28_18_19_19);
		fileGroups.addFileToGroup(keyA, pictureFile_IMG_20100828_181919);
		
		assertThat(fileGroups.getFileGroup(keyA))
					.hasSize(2)
					.contains(pictureFile_2010_08_28_18_19_19)
					.contains(pictureFile_IMG_20100828_181919);
		
		assertThat(fileGroups.getFileGroup(keyB)).hasSize(0);
		
	}
	
	@Test
	public void shallReturnEmptyListWhenRequestingKeyThatDoesNotExists(){
		assertThat(fileGroups.getFileGroup(keyA))
					.isNotNull()
					.hasSize(0);
	}
	
	@Test
	public void shallReturnOnlyGroupsWithDuplicateFiles(){
		fileGroups.addFileToGroup(keyA, pictureFile_2010_08_28_18_19_19);
		fileGroups.addFileToGroup(keyA, pictureFile_IMG_20100828_181919);
		fileGroups.addFileToGroup(keyB, pictureFile_2010_08_22_13_12_13);
		
		FileGroups groupsWithDuplicates = fileGroups.getGroupsWithMoreThanOneFile();
		assertThat(groupsWithDuplicates).hasSize(1);
		assertThat(groupsWithDuplicates.containsKey(keyA)).isTrue();
	}
	
}