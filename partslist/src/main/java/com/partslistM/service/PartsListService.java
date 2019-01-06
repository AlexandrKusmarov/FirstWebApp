package com.partslistM.service;

import com.partslistM.entity.PartsList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface PartsListService {
     void save(PartsList partsList);
     void delete(int id);
     void update(int id,String name,boolean need, int quantity);
     void newPart(PartsList partsList);
     PartsList getPartById(int id);
//     void searchByName(String name);
     List<PartsList> findAllByOrderByNameAsc(Pageable pageable);
     List<PartsList> findAllByOrderByNameDesc(Pageable pageable);
     List<PartsList> findAllByNeedTrueOrderByNeed(Pageable pageable);
     List<PartsList> findAllByNeedFalseOrderByNeed(Pageable pageable);
     List<PartsList> findAllByNameContainsOrderByName(String name, Pageable pageable);
     List<PartsList> findAllByNeedTrueOrderByQuantityAsc();
//     Page<PartsList> findAll(Pageable pageable);

}
