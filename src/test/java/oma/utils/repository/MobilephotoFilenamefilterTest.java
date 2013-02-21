package oma.utils.repository;

import static oma.utils.filrydding.ObjectMother.dummyFolder;
import static oma.utils.filrydding.ObjectMother.fileName_2010_08_28_18_19_19;
import static oma.utils.filrydding.ObjectMother.fileName_2010_08_28_18_19_19_1;
import static oma.utils.filrydding.ObjectMother.fileName_IMG_20100828_181919;
import static org.fest.assertions.Assertions.assertThat;
import oma.utils.repository.MobilephotoFilenamefilter;

import org.junit.Test;

public class MobilephotoFilenamefilterTest {
	private MobilephotoFilenamefilter filter = new MobilephotoFilenamefilter();
	
	@Test
	public void shallAcceptFileNameFollowingPatternYYYY_mm_DD_HH_MM_SS_jpg(){
		boolean filterResult = filter.accept(dummyFolder, fileName_2010_08_28_18_19_19);
		assertThat(filterResult).isTrue();
    }
	
	@Test
	public void shallAcceptFileNameFollowingPatternYYYY_mm_DD_HH_MM_SS_n_jpg(){
		boolean filterResult = filter.accept(dummyFolder, fileName_2010_08_28_18_19_19_1);
		assertThat(filterResult).isTrue();
    }
	
	@Test
	public void shallAcceptFileNameFollowingPattern_IMG_YYYYmmDD_HHMMSS_jpg(){
		boolean filterResult = filter.accept(dummyFolder, fileName_IMG_20100828_181919);
		assertThat(filterResult).isTrue();
    }
	
	@Test
	public void shallDenyOtherFileNames(){
		boolean filterResult = filter.accept(dummyFolder, "random_filename.jpg");
		assertThat(filterResult).isFalse();
    }
	
}

