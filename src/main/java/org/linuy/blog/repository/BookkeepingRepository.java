package org.linuy.blog.repository;

import org.linuy.blog.entity.bookkeeping.Bookkeeping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookkeepingRepository extends JpaRepository<Bookkeeping, Long> {
}