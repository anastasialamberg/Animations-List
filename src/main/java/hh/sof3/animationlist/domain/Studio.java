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

@Entity
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studio_id")
    private Long studio_id;
    private String studioName;

    @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("studio")
    private List<Animation> animations;

    public Studio(Long studio_id, String studioName) {
        this.studio_id = studio_id;
        this.studioName = studioName;
    }

    public Studio() {
        this.studio_id = null;
        this.studioName = null;
    }

    public Long getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(Long studio_id) {
        this.studio_id = studio_id;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public List<Animation> getAnimations() {
        return animations;
    }

    public void setAnimations(List<Animation> animations) {
        this.animations = animations;
    }

    @Override
    public String toString() {
        return "Studio [studio_id=" + studio_id + ", studioName=" + studioName + "]";
    }

}
