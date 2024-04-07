package hh.sof3.animationlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.animationlist.domain.Animation;
import hh.sof3.animationlist.domain.AnimationRepository;
import hh.sof3.animationlist.domain.Genre;
import hh.sof3.animationlist.domain.GenreRepository;
import hh.sof3.animationlist.domain.Studio;
import hh.sof3.animationlist.domain.StudioRepository;

@SpringBootApplication
public class AnimationlistApplication {

	Logger logger = LoggerFactory.getLogger(AnimationlistApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AnimationlistApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AnimationRepository animationRepository, StudioRepository studioRepository,
			GenreRepository genreRepository) {
		return (args) -> {

			Studio studio1 = new Studio(null, "Disney and Pixar");
			studioRepository.save(studio1);

			Studio studio2 = new Studio(null, "Disney");
			studioRepository.save(studio2);

			Genre genre1 = new Genre(null, "Adventure");
			genreRepository.save(genre1);

			Genre genre2 = new Genre(null, "Family");
			genreRepository.save(genre2);

			Animation animation1 = new Animation(null, "Soul", 2020, "Pete Docter");
			animation1.setStudio(studio1);
			animation1.setGenre(genre1);
			animationRepository.save(animation1);

			Animation animation2 = new Animation(null, "Inside Out", 2015, "Pete Docter");
			animation2.setStudio(studio2);
			animation2.setGenre(genre2);
			animationRepository.save(animation2);

			logger.info("Fetch all the animations");
			for (Animation animation : animationRepository.findAll()) {
				logger.info(animation.toString());
			}
			logger.info("Fetch all the studios");
			for (Studio studio : studioRepository.findAll()) {
				logger.info(studio.toString());
			}
			logger.info("Fetch all the genres");
			for (Genre genre : genreRepository.findAll()) {
				logger.info(genre.toString());
			}

		};

	}
}
