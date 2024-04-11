package hh.sof3.animationlist.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long genre_id;

    @NotBlank(message = "Genre name is required")
    @Size(min = 2, max = 30, message = "Genre name must be between 2 and 30 characters")
    private String genreName;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("genre")
    private List<Animation> animations;

    public Genre(Long genre_id, String genreName) {
        this.genre_id = genre_id;
        this.genreName = genreName;
    }

    public Genre() {
        this.genre_id = null;
        this.genreName = null;

    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<Animation> getAnimations() {
        return animations;
    }

    public void setAnimations(List<Animation> animations) {
        this.animations = animations;
    }

    @Override
    public String toString() {
        return "Genre [genre_id=" + genre_id + ", genreName=" + genreName + "]";
    }

}
