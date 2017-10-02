/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dkt.neo4jrecsysquery.controller;

import com.dkt.neo4jrecsysquery.services.ItemService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KienNT
 */
@RestController("/")
public class ItemController {

    final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(name = "/recommend/association-rule", method = RequestMethod.POST)
    public List<String> getRecommendation(@RequestParam("items") List<String> items) {
//        Logger.getLogger(getClass().getName()).log(Level.INFO, "Number items: {0}", items.size());
        return itemService.recommend(items);
    }
}
