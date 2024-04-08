package hh.sof3.animationlist.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AnimationRepository extends CrudRepository<Animation, Long> {

    @Query("UPDATE Animation a SET a.votes = a.votes + 1 WHERE a.id = :animation_id")
    void voteAnimation(@Param("animation_id") Long animation_id);

    @Query("SELECT a.votes FROM Animation a WHERE a.id = :animation_id")
    int findVotesById(@Param("animation_id") Long animatio_id);

}
