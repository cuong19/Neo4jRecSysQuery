/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dkt.neo4jrecsysquery.services;

import com.dkt.neo4jrecsysquery.repositories.ItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KienNT
 */
@Service
public class AssociationRulesService {

    @Autowired
    ItemRepository itemRepository;

    public List<String> getConsequences(List<String> items) {
        return itemRepository.getAssocationRulesConsequences(items);
    }
}
