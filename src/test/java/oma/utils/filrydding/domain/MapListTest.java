package oma.utils.filrydding.domain;

import static oma.utils.filrydding.ObjectMother.fileName_2010_08_28_18_19_19;
import static oma.utils.filrydding.ObjectMother.fileName_IMG_20100828_181919;
import static oma.utils.filrydding.ObjectMother.file_2010_08_28_18_19_19;
import static oma.utils.filrydding.ObjectMother.file_IMG_20100828_181919;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
public class MapListTest {
	
	private String keyA = "A";
	private String keyB = "B";
	private MapList mapList;
	@Before
	public void initialize(){
		mapList = new MapList();
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
		PictureFile pictureFile_2010_08_28_18_19_19 = new PictureFile(file_2010_08_28_18_19_19);
		PictureFile pictureFile_IMG_20100828_181919 = new PictureFile(file_IMG_20100828_181919);

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
	
}