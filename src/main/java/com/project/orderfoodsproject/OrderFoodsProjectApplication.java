package com.project.orderfoodsproject;

import com.project.orderfoodsproject.util.UtilityClass;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class OrderFoodsProjectApplication implements CommandLineRunner {

/*	FOR TESTING PURPOSES ONLY
	Uncomment the code below if testing of database is needed.
*/
//		@Resource
//        UtilityClass util;

    public static void main(String[] args) {
        SpringApplication.run(OrderFoodsProjectApplication.class, args);
    }

    @Override
    public void run(String... args) {
        /* FOR TESTING PURPOSES ONLY
			Uncomment the code below if the tables don't exist
		*/
//        util.createPlacesTable();
//        util.createDishesTable();
//        util.createClientsTable();
//        util.createOrdersTable();

        /* FOR TESTING PURPOSES ONLY
			Uncomment the code below if test data is needed
		*/
//        util.insertIntoPlaces();
//        util.insertIntoDishes();
//        util.insertIntoClients();
//        util.insertIntoOrders();
    }
}
