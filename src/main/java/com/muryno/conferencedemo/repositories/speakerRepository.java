package com.muryno.conferencedemo.repositories;

import com.muryno.conferencedemo.models.speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface speakerRepository extends JpaRepository<speaker,Long> {
}
