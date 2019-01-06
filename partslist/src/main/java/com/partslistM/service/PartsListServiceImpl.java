package com.partslistM.service;

import com.partslistM.entity.PartsList;
import com.partslistM.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PartsListServiceImpl implements PartsListService {

    private PartRepository repository;

    @Autowired
    public void setPartsListDao(PartRepository repository) {
        this.repository = repository;
    }

    @Override
    public void newPart(PartsList partsList) {
        repository.save(partsList);
    }

    @Override
    public void save(PartsList partsList) {
        repository.save(partsList);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void update(int id, String name, boolean need, int quantity) {
        PartsList update = repository.findOne(id);
        update.setName(name);
        update.setNeed(need);
        update.setQuantity(quantity);
        repository.save(update);
    }

    @Override
    public PartsList getPartById(int id) {
        return repository.findOne(id);
    }

//    @Override
//    public void searchByName(String name) {
//        repository.findAllByNameContainsOrderByName(name,);
//    }

    @Override
    public List<PartsList> findAllByOrderByNameAsc(Pageable pageable) {
        return repository.findAllByOrderByNameAsc(pageable);
    }

    @Override
    public List<PartsList> findAllByOrderByNameDesc(Pageable pageable) {
        return repository.findAllByOrderByNameDesc(pageable);
    }

    @Override
    public List<PartsList> findAllByNeedTrueOrderByNeed(Pageable pageable) {
        return repository.findAllByNeedTrueOrderByNeed(pageable);
    }

    @Override
    public List<PartsList> findAllByNeedFalseOrderByNeed(Pageable pageable) {
        return repository.findAllByNeedFalseOrderByNeed(pageable);
    }

    @Override
    public List<PartsList> findAllByNameContainsOrderByName(String name, Pageable pageable) {
        return repository.findAllByNameContainsOrderByName(name,pageable);
    }

    @Override
    public List<PartsList> findAllByNeedTrueOrderByQuantityAsc() {
        return repository.findAllByNeedTrueOrderByQuantityAsc();
    }

//    @Override
//    public Page<PartsList> findAll(Pageable pageable) {
//        return repository.findAll(pageable);
//    }
}
