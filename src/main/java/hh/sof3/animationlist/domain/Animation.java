package hh.sof3.animationlist.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "animation")
public class Animation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "animation_id")
    private Long animation_id;
    private String title;
    private Integer releaseYear;
    private String director;
    private int votes;

    @ManyToOne
    @JsonIgnoreProperties("animations")
    @JoinColumn(name = "studio_id")
    private Studio studio;

    @ManyToOne
    @JsonIgnoreProperties("animations")
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Animation(Long animation_id, String title, Integer releaseYear, String director) {
        this.animation_id = animation_id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;

    }

    public Animation() {
        this.animation_id = null;
        this.title = null;
        this.releaseYear = (Integer) null;
        this.director = null;
    }

    public Long getAnimation_id() {
        return animation_id;
    }

    public void setAnimation_id(Long animation_id) {
        this.animation_id = animation_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Animation{" +
                "animation_id=" + animation_id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", director='" + director + '\'' +
                ", votes=" + votes +
                ", studio=" + (studio != null ? getStudio() : "null") +
                ", genre=" + (genre != null ? getGenre() : "null") +
                '}';
    }
}
