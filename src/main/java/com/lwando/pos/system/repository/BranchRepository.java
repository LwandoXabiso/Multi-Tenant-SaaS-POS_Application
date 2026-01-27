package com.lwando.pos.system.repository;

import com.lwando.pos.system.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    List<Branch> findAByStoreId(Long storeId);

    Branch findBranchByEmail(String email);

}
