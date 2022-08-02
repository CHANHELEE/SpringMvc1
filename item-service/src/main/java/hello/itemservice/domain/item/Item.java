package hello.itemservice.domain.item;


import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data // @Data를 막 쓰면 위험함.
public class Item {
    private Long id;
    private  String itemName;
    private  Integer price;
    private Integer quantity;

    public  Item(){}

    public Item( String itemName, Integer price, Integer quantity) {

        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
