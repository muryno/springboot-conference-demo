package com.muryno.conferencedemo.repositories;

import com.muryno.conferencedemo.models.session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface sessionRepository extends JpaRepository<session,Long> {
}
