package hh.sof3.animationlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.animationlist.web.AnimationRestController;
import hh.sof3.animationlist.web.animationController;
import hh.sof3.animationlist.web.genreController;
import hh.sof3.animationlist.web.studioController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AnimationlistApplicationTests {

	@Autowired
	private animationController AnimationController;

	@Autowired
	private studioController studioController;

	@Autowired
	private genreController genreController;

	@Autowired
	private AnimationRestController animationRestController;

	@Test
	void contextLoads() {

		assertThat(AnimationController).isNotNull();
		assertThat(studioController).isNotNull();
		assertThat(genreController).isNotNull();
		assertThat(animationRestController).isNotNull();
	}

}
