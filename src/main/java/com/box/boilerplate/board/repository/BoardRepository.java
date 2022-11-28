package com.box.boilerplate.board.repository;

import com.box.boilerplate.board.model.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

    List<BoardEntity> findByUsedYn(String userYn);
}
