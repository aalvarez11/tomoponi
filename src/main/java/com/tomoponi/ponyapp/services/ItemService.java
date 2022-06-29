package com.tomoponi.ponyapp.services;

import com.tomoponi.ponyapp.model.*;
import com.tomoponi.ponyapp.repository.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional(rollbackOn = {DataAccessException.class})
public class ItemService {
    final ItemRepository itemRepository;
    final EggRepository eggRepository;
    final FoodRepository foodRepository;
    final MedicineRepository medicineRepository;
    final ToyRepository toyRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository, EggRepository eggRepository, FoodRepository foodRepository, MedicineRepository medicineRepository, ToyRepository toyRepository) {
        this.itemRepository = itemRepository;
        this.eggRepository = eggRepository;
        this.foodRepository = foodRepository;
        this.medicineRepository = medicineRepository;
        this.toyRepository = toyRepository;
    }

    // get all items in the database
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Transactional(rollbackOn = {NoSuchElementException.class})
    public Item findByItemName(String name) throws NoSuchElementException {
        return itemRepository.findByNameIgnoreCase(name).orElseThrow();
    }

    // methods for saving or updating items
    public void saveOrUpdateEgg(Egg e) {
        eggRepository.save(e);
        log.info(e.toString());
    }

    public void saveOrUpdateFood(Food f) {
        foodRepository.save(f);
        log.info(f.toString());
    }

    public void saveOrUpdateMedicine(Medicine m) {
        medicineRepository.save(m);
        log.info(m.toString());
    }

    public void saveOrUpdateToy(Toy t) {
        toyRepository.save(t);
        log.info(t.toString());
    }
}
