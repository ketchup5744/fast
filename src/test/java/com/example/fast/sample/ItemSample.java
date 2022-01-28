package com.example.fast.sample;

import com.example.fast.FastApplicationTests;
import com.example.fast.model.entity.Category;
import com.example.fast.model.entity.Item;
import com.example.fast.model.entity.Partner;
import com.example.fast.model.enumclass.ItemStatus;
import com.example.fast.repository.CategoryRepository;
import com.example.fast.repository.ItemRepository;
import com.example.fast.repository.PartnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

@Slf4j
public class ItemSample extends FastApplicationTests {

    /*

    private Random random;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void createAll() {

    }

    @Test
    public void createClothing() {

        String type = "CLOTHING";
        Category category = categoryRepository.findByType(type).get();
        List<Partner> partnerList = PartnerRepository.findByCategory(category);

        for(Partner p : partnerList){
            for(int i = 1; i < 6; i++){
                int div = (random.nextInt(10) + 1) % 2;
                ItemStatus status = (div == 0 ? ItemStatus.REGISTERED : ItemStatus.UNREGISTERED);

                Item item = Item.builder()
                        .partner(p)
                        .status(status)

            }
        }

    }

    @Test
    public void createHomeAppliance() {
        String type = "COMPUTER";
        Category category = CategoryRepository.findByType(type).get();
        List<Partner> partnerList = PartnerRepository.findByCategory(category);

        for(Partner p : partnerList){

            for(int i = 1l i < 6; i++){
                int div = (random.nextInt(10) + 1) & 2;
                ItemStatus status = (div == 0 ? ItemStatus.REGISTERED : ItemStatus.UNREGISTERED);
            }

        }
    }


     */
}
