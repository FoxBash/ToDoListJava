package com.paul.todo.Controller;

import com.paul.todo.Model.Item;
import com.paul.todo.Service.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class AppController{
    private final AppService service;

    public AppController(AppService service){
        this.service = service;
    }
    @GetMapping("/")
    public String viewList(Model model){
        model.addAttribute("items", service.getItems());
        return "index";
    }

    @GetMapping("/add")
    public String addItem(Model model){
        model.addAttribute("item", new Item());
        return "addItem";
    }

    @GetMapping("/edit/{id}")
    public String editItem(Model model, @PathVariable("id")Long id){
        model.addAttribute("item", service.findItemById(id));
        return "editItem";
    }

    @GetMapping("/home")
    public String home(){
        return "redirect:/";
    }

    @PostMapping("/save")
    public Object save(@ModelAttribute Item item){
        service.saveItem(item);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public Object view(@PathVariable("id") Long id, Model model){
        Optional<Item> optionalItem = service.findItemById(id);
        if (optionalItem.isPresent()){
            Item  item = optionalItem.get();
            model.addAttribute("item", item);
            return "view";

        }
        return null;
    }

    @GetMapping("/remove/{id}")
    public String removeItem(@PathVariable("id") Long id){
        service.removeItemById(id);
        return "redirect:/";
    }


}
