package ro.sda.java64.finalprojectdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.java64.finalprojectdemo.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
