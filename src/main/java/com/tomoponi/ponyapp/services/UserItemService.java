package com.tomoponi.ponyapp.services;

import com.tomoponi.ponyapp.model.UserItems;
import com.tomoponi.ponyapp.repository.UserItemRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserItemService {
    final UserItemRepository userItemRepository;

    @Autowired
    public UserItemService(UserItemRepository userItemRepository) {
        this.userItemRepository = userItemRepository;
    }

    @Transactional(rollbackOn = {NoSuchElementException.class})
    public List<UserItems> findUserItemsByUserId(int userId) throws NoSuchElementException {
        return userItemRepository.findUserItemsByUserId(userId);
    }
}
