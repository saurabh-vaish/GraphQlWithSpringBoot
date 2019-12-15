package com.srv.app.annotation.controller;

import com.srv.app.annotation.resolvers.VehicleResolvers;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.DefaultOperationBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author: saurabh vaish
 * @version: 1.0
 * @since : 15-Dec-19
 */

@RestController
public class GraphqlController{

//    @Autowired
//    private VehicleResolvers resolvers;

    private final GraphQL graphQL;

//    @Autowired
    public GraphqlController(VehicleResolvers vehicleResolvers)
    {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withResolverBuilders(new AnnotatedResolverBuilder())
                .withOperationsFromSingleton(vehicleResolvers)
                .withOperationBuilder(new DefaultOperationBuilder(DefaultOperationBuilder.TypeInference.LIMITED))
                .withValueMapperFactory(new JacksonValueMapperFactory())
                .generate();

        graphQL = GraphQL.newGraphQL(schema).build();
    }

    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> indexFromAnnotated(@RequestBody Map<String, String> request, HttpServletRequest raw) {
        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
                .query(request.get("query"))
                .operationName(request.get("operationName"))
                .context(raw)
                .build());
        return executionResult.toSpecification();
    }


//    @Override
//    protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
//        return errors.stream()
//                .filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e))
//                .map(e -> e instanceof ExceptionWhileDataFetching ? new SanitizedError((ExceptionWhileDataFetching) e) : e)
//                .collect(Collectors.toList());
//    }

}
