package hh.sof3.animationlist;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.animationlist.domain.Animation;
import hh.sof3.animationlist.domain.AnimationRepository;
import hh.sof3.animationlist.domain.Genre;
import hh.sof3.animationlist.domain.GenreRepository;
import hh.sof3.animationlist.domain.Studio;
import hh.sof3.animationlist.domain.StudioRepository;
import hh.sof3.animationlist.domain.User;
import hh.sof3.animationlist.domain.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AnimationRepositoryTest {

    @Autowired
    private AnimationRepository animationRepository;

    @Autowired
    private StudioRepository studioRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testAnimationRepository() {

        Animation animation = new Animation((long) 3, "Lion King", 1994, "sfjdhdh");
        animationRepository.save(animation);

        Optional<Animation> foundAnimation = animationRepository.findById((long) 3);
        assertThat(foundAnimation).isNotEmpty();

        animationRepository.delete(animation);
        assertThat(animationRepository.findById((long) 3)).isEmpty();
    }

    @Test
    void testStudioRepository() {
        Studio studio = new Studio(((long) 3), "Dreamworks");
        studioRepository.save(studio);

        Optional<Studio> foundStudios = studioRepository.findById((long) 3);
        assertThat(foundStudios).isNotEmpty();

        studioRepository.delete(studio);

        assertThat(studioRepository.findById((long) 3)).isEmpty();
    }

    @Test
    void testGenreRepository() {
        Genre genre = new Genre(((long) 3), "Comedy");
        genreRepository.save(genre);

        Optional<Genre> foundGenre = genreRepository.findById((long) 3);
        assertThat(foundGenre).isNotEmpty();

        genreRepository.delete(genre);

        assertThat(genreRepository.findById((long) 3)).isEmpty();
    }

    @Test
    void testUserRepository() {
        User user = new User("maijap", "$2a$10$EFPDcnDkAlTQdSQbBCwa9uWo3xdRh4SaAeKuY7g9mTPIBhliT7SJ6", "USER");
        userRepository.save(user);

        User foundUser = userRepository.findByUsername("maijap");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isNotEmpty();

        userRepository.delete(user);

        assertThat(userRepository.findByUsername("maijap")).isNull();
    }

}
