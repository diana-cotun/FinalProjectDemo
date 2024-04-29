package ro.sda.java64.finalprojectdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.java64.finalprojectdemo.entities.Item;
import ro.sda.java64.finalprojectdemo.services.ItemService;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> save(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.save(item), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> get(@PathVariable Long id) {
        Item foundItem = itemService.get(id);
        if (foundItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundItem, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item item) {
        Item uptatedItem = itemService.update(id, item);
        if (uptatedItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(uptatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> delete(@PathVariable Long id) {
        Item deletedItem = itemService.delete(id);
        if (deletedItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedItem, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        return new ResponseEntity<>(itemService.getAll(), HttpStatus.OK);
    }


}
