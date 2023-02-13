package com.paul.todo.Service;

import com.paul.todo.Model.Item;
import com.paul.todo.Repository.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppService {
    private final AppRepo repo;

    public AppService(AppRepo repo) {
        this.repo = repo;
    }

    public Object getItems() {
         return  repo.findAll();
    }

    public void saveItem(Item item) {
        repo.save(item);
    }

    public void removeItemById(Long id) {
        repo.deleteById(id);
    }

    public Optional<Item> findItemById(Long id) {
        return repo.findById(id);
    }
}
