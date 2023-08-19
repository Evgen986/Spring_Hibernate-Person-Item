package ru.evgen.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evgen.spring.models.Item;
import ru.evgen.spring.models.Person;
import ru.evgen.spring.repositories.ItemsRepository;

import java.util.List;

@Service
@Transactional
public class ItemsService {
    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }
    public List<Item> findByItemName(String name){
        return itemsRepository.findByItemName(name);
    }
    public List<Item> findByOwner(Person owner){
        return itemsRepository.findByOwner(owner);
    }
}
