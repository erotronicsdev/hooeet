package com.erotronics.hps.persistence;

import com.erotronics.hps.domain.LiveEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiveEventRedisRepository extends CrudRepository<LiveEvent, Object> {
}
