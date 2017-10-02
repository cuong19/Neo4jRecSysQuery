/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dkt.neo4jrecsysquery.entity;

import java.util.ArrayList;
import java.util.List;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 *
 * @author KienNT
 */
@NodeEntity
public class Item {

    @GraphId
    Long id;
    String name;

    @Relationship(type = "OCCURS_IN", direction = Relationship.OUTGOING)
    List<ItemSet> itemSets = new ArrayList<>();

}
