package com.srv.app.annotation.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Vehicle{

    @Id
    @GeneratedValue(generator = "veh")
    @GenericGenerator(name = "veh",strategy = "increment")
    @GraphQLQuery(name = "vehicleId",description = "id of the vehicle")
    private int vehicleId;

    @GraphQLQuery(name = "vehicleType",description = "type of the vehicle")
    private String vehicleType;

    @GraphQLQuery(name = "vehicleModeCode",description = "mode of the vehicle")
    private String vehicleModelCode;

    @GraphQLQuery(name = "vehicleBrandName",description = "brand Name of the vehicle")
    private String vehicleBrandName;

    @GraphQLQuery(name = "vehicleLaunchDate",description = "launch date of the vehicle")
    private String vehicleLaunchDate;

    @ManyToOne
    @JoinColumn(name="cid")
    @GraphQLQuery(name = "company",description = "company of the vehicle")
    private Company company;

}