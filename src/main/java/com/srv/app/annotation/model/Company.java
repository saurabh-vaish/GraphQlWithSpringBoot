package com.srv.app.annotation.model;

import graphql.schema.GraphQLObjectType;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 15-Dec-19
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Company {

    @Id
    @GeneratedValue(generator = "com")
    @GenericGenerator(name = "com",strategy = "increment")
    @GraphQLQuery(name = "companyId",description = "id of the company")
    private int manufacturerId;

    @GraphQLQuery(name = "companyName",description = "name of the company")
    private String manufacturerName;

    @GraphQLQuery(name = "companyLocation",description = "location of the company")
    private String location;

    @GraphQLQuery(name="vehicles",description = "id of vehicles company made")
    @OneToMany(mappedBy = "company", cascade = {CascadeType.REMOVE}, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Vehicle> vehicle;
}