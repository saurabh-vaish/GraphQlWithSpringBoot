package com.srv.app.annotation.resolvers;

import com.srv.app.annotation.model.Vehicle;
import com.srv.app.annotation.service.VehicleService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 15-Dec-19
 */

@Component
@GraphQLApi
public class VehicleResolvers {

    @Autowired
    private VehicleService service;

    /// for query

    @GraphQLQuery(name = "Vehicles")
    public List<Vehicle> getAllVehicles()
    {
        return service.getAllvehicles();
    }

    @GraphQLQuery(name="Vehicle")
    public Vehicle getVehicleById(@GraphQLArgument(name="id") Integer id)
    {
        return service.getOneVehicle(id);
    }


//    @GraphQLQuery(name="customer")
//    public  Vehicle getCustomer(@GraphQLContext Vehicle vehicle)
//    {
//        return new Vehicle().set;
//    }

//    @GraphQLQuery(name="")

//     Mutation

    @GraphQLMutation(name="saveVehicle")
    public Vehicle saveVehicle(@GraphQLArgument(name="vehicle") Vehicle vehicle)
    {
        return service.saveVehicle(vehicle);
    }

    @GraphQLMutation(name="updateVehicle")
    public Integer updateVehicle(@GraphQLArgument(name="vehicle") Vehicle vehicle)
    {
        return service.updateVehicle(vehicle);
    }

    @GraphQLMutation(name="deleteVehicle")
    public Integer deleteVehicle(@GraphQLArgument(name="id") Integer id)
    {
        return service.deletevehicle(id);
    }


}
