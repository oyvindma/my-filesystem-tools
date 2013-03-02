package oma.utils.filrydding.domain;

import static oma.utils.filrydding.ObjectMother.fileName_2010_08_28_18_19_19;
import static oma.utils.filrydding.ObjectMother.fileName_IMG_20100828_181919;
import static oma.utils.filrydding.ObjectMother.file_2010_08_28_18_19_19;
import static oma.utils.filrydding.ObjectMother.file_IMG_20100828_181919;
import static oma.utils.filrydding.ObjectMother.pictureFile_2010_08_22_13_12_13;
import static oma.utils.filrydding.ObjectMother.pictureFile_2010_08_28_18_19_19;
import static oma.utils.filrydding.ObjectMother.pictureFile_IMG_20100828_181919;
import static org.fest.assertions.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
public class FilegroupsTest {
	
	private String keyA = "A";
	private String keyB = "B";
	private Filegroups mapList;
	@Before
	public void initialize(){
		mapList = new Filegroups();
	}
	
	
	@Test
	public void shallNotGroupFilesWithDifferentKeys(){
		mapList.put(keyA, new PictureFile(file_2010_08_28_18_19_19));
		mapList.put(keyB, new PictureFile(file_IMG_20100828_181919));
		
		assertThat(mapList.get(keyA)).hasSize(1);
		assertThat(mapList.get(keyA).get(0).getFileName()).isEqualTo(fileName_2010_08_28_18_19_19);

		assertThat(mapList.get(keyB)).hasSize(1);
		assertThat(mapList.get(keyB).get(0).getFileName()).isEqualTo(fileName_IMG_20100828_181919);
	}
	
	@Test
	public void shallGroupFilesWithSameKey(){
		
		mapList.put(keyA, pictureFile_2010_08_28_18_19_19);
		mapList.put(keyA, pictureFile_IMG_20100828_181919);
		
		assertThat(mapList.get(keyA))
					.hasSize(2)
					.contains(pictureFile_2010_08_28_18_19_19)
					.contains(pictureFile_IMG_20100828_181919);
		
		assertThat(mapList.get(keyB)).hasSize(0);
		
	}
	
	@Test
	public void shallReturnEmptyListWhenRequestingKeyThatDoesNotExists(){
		assertThat(mapList.get(keyA))
					.isNotNull()
					.hasSize(0);
	}
	
	@Test
	public void shallReturnOnlyGroupsWithDuplicateFiles(){
		mapList.put(keyA, pictureFile_2010_08_28_18_19_19);
		mapList.put(keyA, pictureFile_IMG_20100828_181919);
		mapList.put(keyB, pictureFile_2010_08_22_13_12_13);
		
		Map<String, List<PictureFile>> groupsWithDuplicates = mapList.getGroupsWithMoreThanOneFile();
		assertThat(groupsWithDuplicates).hasSize(1);
		assertThat(groupsWithDuplicates.containsKey(keyA)).isTrue();
	}
	
}