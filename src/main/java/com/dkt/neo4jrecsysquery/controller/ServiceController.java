/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dkt.neo4jrecsysquery.controller;

import com.dkt.neo4jrecsysquery.services.AssociationRulesService;
import java.util.List;
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
public class ServiceController {

    final AssociationRulesService associationRulesService;

    @Autowired
    public ServiceController(AssociationRulesService service) {
        this.associationRulesService = service;
    }

    @RequestMapping(value = "/recommendations/association-rules", method = RequestMethod.GET)
    public List<String> getRecommendation(@RequestParam("antencedents") List<String> antencedents) {
        return associationRulesService.getConsequences(antencedents);
    }
}
