package com.partslistM.repository;

import com.partslistM.entity.PartsList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PartRepository extends JpaRepository<PartsList,Integer> {

    List<PartsList> findAllByOrderByNameAsc(Pageable pageable);
    List<PartsList> findAllByOrderByNameDesc(Pageable pageable);
    List<PartsList> findAllByNeedTrueOrderByNeed(Pageable pageable);
    List<PartsList> findAllByNeedFalseOrderByNeed(Pageable pageble);
    List<PartsList> findAllByNameContainsOrderByName(String name, Pageable pageable);  //For "search" field
    List<PartsList> findAllByNeedTrueOrderByQuantityAsc();  //For display number of computers for assembly
//    Page<PartsList> findAll(Pageable pageable);

}
