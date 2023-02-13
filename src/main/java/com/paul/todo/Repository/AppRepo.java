package com.paul.todo.Repository;

import com.paul.todo.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepo extends JpaRepository<Item,Long> {
    void deleteItemById(Long id);
}
