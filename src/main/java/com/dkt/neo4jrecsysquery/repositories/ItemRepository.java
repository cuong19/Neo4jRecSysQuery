/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dkt.neo4jrecsysquery.repositories;

import com.dkt.neo4j.entity.Item;
import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author KienNT
 */
@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepository extends GraphRepository<Item> {

//    @Query("CREATE (i:Item {name:{name}})")
//    void addItem(@Param("name") String name);
    @Query("MATCH (ia:Item)-[ra:OCCURS_IN]->(s:ItemSet)-[rc:OCCURS_WITH]->(ic:Item) WHERE ia.name IN {items} WITH s, count(*) as count_ia, rc.lift as lift, rc.support as support, rc.confidence as confidence, ic.name as consequent ORDER BY count_ia DESC, lift DESC, support DESC, confidence DESC RETURN DISTINCT consequent")
    List<String> recommend(@Param("items")List<String> items);
}
