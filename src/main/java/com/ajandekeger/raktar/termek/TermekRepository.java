package com.ajandekeger.raktar.termek;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermekRepository extends JpaRepository<Termek, Integer> {
}
