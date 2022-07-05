package com.tomoponi.ponyapp.services;

import com.tomoponi.ponyapp.model.*;
import com.tomoponi.ponyapp.repository.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // get all items in the database
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    // get an item by name
    @Transactional(rollbackOn = {NoSuchElementException.class})
    public Item findByItemName(String name) throws NoSuchElementException {
        return itemRepository.findByNameIgnoreCase(name).orElseThrow();
    }

    @Transactional(rollbackOn = {NoSuchElementException.class})
    public Item findById(int id) throws NoSuchElementException {
        return itemRepository.findById(id).orElseThrow();
    }

    // method for creating or updating items
    public void saveOrUpdateItem(Item i) {
        itemRepository.save(i);
        log.info(i.toString());
    }

    // method for deleting items
    public void deleteItem(Item i) {
        itemRepository.delete(i);
    }
}
