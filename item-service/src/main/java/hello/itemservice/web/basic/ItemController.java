package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.net.http.HttpClient;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@Slf4j
@RequiredArgsConstructor
public class ItemController {

    private  final  ItemRepository itemRepository;

    @GetMapping
    public String Items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "basic/items";
    }

    @GetMapping("/add")
    public  String addItemForm(){
        return "basic/addForm";
    }

    @PostMapping("/add") // redirectAttribute 사용
    public String addItem(@ModelAttribute Item item,RedirectAttributes redirectAttributes){
        itemRepository.save(item);
        redirectAttributes.addAttribute("itemId",item.getId());
        redirectAttributes.addAttribute("status",true);

        return  "redirect:/basic/items/{itemId}"; // PRG 적용
    }


    @GetMapping("/{itemId}")
    public String productSpecify(@PathVariable Long itemId,Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/item";
    }


    @GetMapping("/{itemId}/edit")
    public  String editForm(Model model,@PathVariable Long itemId){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public  String update(@ModelAttribute Item item,@PathVariable Long itemId,RedirectAttributes redirectAttributes){
        itemRepository.update(itemId, item);
        redirectAttributes.addAttribute("edit",true);
        return "redirect:/basic/items";
    }








}
