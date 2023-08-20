package com.shyren.unittesting.unittesting.business;

import com.shyren.unittesting.unittesting.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {
    public Item retrieveHardCodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
}
