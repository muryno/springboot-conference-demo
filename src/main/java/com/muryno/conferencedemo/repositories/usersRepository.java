package com.muryno.conferencedemo.repositories;

import com.muryno.conferencedemo.models.speaker;
import com.muryno.conferencedemo.models.users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usersRepository extends JpaRepository<users,Integer> {
}
