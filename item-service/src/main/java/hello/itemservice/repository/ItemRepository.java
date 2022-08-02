package hello.itemservice.repository;

import hello.itemservice.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepository {

        private static final Map<Long, Item> store = new ConcurrentHashMap<>(); //static 사용 private  멀티쓰레드 환경을 위해 concurrentHashmap 사용
        private  static AtomicLong sequence = new AtomicLong(0);//멀티쓰레드 환경을 위해 AtomicLong 사용

    public Long getSequence() {
        return sequence.get();
    }

    public Item save(Item item) {
            item.setId(sequence.incrementAndGet());
            store.put(item.getId(), item);
            return item;
        }

        public Item findById(Long id) {
            return store.get(id);
        }

        public List<Item> findAll() {
            return new ArrayList<>(store.values());
        }

        public void update(Long itemId, Item updateParam) {
            Item findItem = findById(itemId);
            findItem.setItemName(updateParam.getItemName());
            findItem.setPrice(updateParam.getPrice());
            findItem.setQuantity(updateParam.getQuantity());
        }

        public void clearStore() {
        store.clear();
    }

    }
