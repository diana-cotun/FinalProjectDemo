package ro.sda.java64.finalprojectdemo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sda.java64.finalprojectdemo.entities.Item;
import ro.sda.java64.finalprojectdemo.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item get(Long id) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isEmpty()) {
            return null;
        }
        return existingItem.get();
    }

    public Item update(Long id, Item item) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isEmpty()) {
            return null;
        }
        Item uptatedItem = existingItem.get();
        uptatedItem.setName(item.getName());
        uptatedItem.setPrice(item.getPrice());
        uptatedItem.setQuantity(item.getQuantity());
        uptatedItem.setDescription(item.getDescription());
        uptatedItem.setUrl(item.getUrl());
        return itemRepository.save(uptatedItem);
    }

    public Item delete(Long id) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isEmpty()) {
            return null;
        }
        itemRepository.deleteById(id);
        return existingItem.get();
    }

    public List<Item> getAll() {
        return itemRepository.findAll();
    }


}
