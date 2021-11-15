package com.pizzashop;

import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.assertTrue;



public class DeluxeTest {

    // String format has been specified and used to avoid floating point rounding errors while comparing prices.
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static final String DEFAULT_SMALL_DELUXE_PRICE = "12.99";
    private static final String NO_TOPPING_SMALL_DELUXE_PRICE = "12.99";
    private static final String MAX_TOPPING_SMALL_DELUXE_PRICE = "15.97";

    private static final String DEFAULT_MEDIUM_DELUXE_PRICE = "14.99";
    private static final String NO_TOPPING_MEDIUM_DELUXE_PRICE = "14.99";
    private static final String MAX_TOPPING_MEDIUM_DELUXE_PRICE = "17.97";

    private static final String DEFAULT_LARGE_DELUXE_PRICE = "16.99";
    private static final String NO_TOPPING_LARGE_DELUXE_PRICE = "16.99";
    private static final String MAX_TOPPING_LARGE_DELUXE_PRICE = "19.97";

    private static final String ERROR_PRICE = "-1.00";

    @Test
    public void testPrice() {

        // Default Small Deluxe Pizza
        // VALID
        Pizza p1 = PizzaMaker.createPizza("Deluxe");
        assertTrue(df.format(p1.price()).equals(DEFAULT_SMALL_DELUXE_PRICE));

        // Small Deluxe Pizza No Toppings
        // VALID
        Pizza p2 = PizzaMaker.createPizza("Deluxe");
        p2.toppings.removeAll(p2.toppings);
        assertTrue(df.format(p2.price()).equals(NO_TOPPING_SMALL_DELUXE_PRICE));

        // Small Deluxe Pizza MAX_TOPPINGS (7 toppings)
        // VALID
        Pizza p3 = PizzaMaker.createPizza("Deluxe");
        p3.toppings.add(Topping.PINEAPPLE);
        p3.toppings.add(Topping.EXTRA_CHEESE);
        assertTrue(df.format(p3.price()).equals(MAX_TOPPING_SMALL_DELUXE_PRICE));

        // Default Medium Deluxe Pizza
        // VALID
        Pizza p4 = PizzaMaker.createPizza("Deluxe");
        p4.setSize(Size.MEDIUM);
        assertTrue(df.format(p4.price()).equals(DEFAULT_MEDIUM_DELUXE_PRICE));

        // Medium Deluxe Pizza No Toppings
        // VALID
        Pizza p5 = PizzaMaker.createPizza("Deluxe");
        p5.setSize(Size.MEDIUM);
        p5.toppings.removeAll(p5.toppings);
        assertTrue(df.format(p5.price()).equals(NO_TOPPING_MEDIUM_DELUXE_PRICE));

        // Medium Deluxe Pizza MAX_TOPPINGS (7 toppings)
        // VALID
        Pizza p6 = PizzaMaker.createPizza("Deluxe");
        p6.setSize(Size.MEDIUM);
        p6.toppings.add(Topping.PINEAPPLE);
        p6.toppings.add(Topping.EXTRA_CHEESE);
        assertTrue(df.format(p6.price()).equals(MAX_TOPPING_MEDIUM_DELUXE_PRICE));

        // Default Large Deluxe Pizza
        // VALID
        Pizza p7 = PizzaMaker.createPizza("Deluxe");
        p7.setSize(Size.LARGE);
        assertTrue(df.format(p7.price()).equals(DEFAULT_LARGE_DELUXE_PRICE));

        // Large Deluxe Pizza No Toppings
        // VALID
        Pizza p8 = PizzaMaker.createPizza("Deluxe");
        p8.setSize(Size.LARGE);
        p8.toppings.removeAll(p8.toppings);
        assertTrue(df.format(p8.price()).equals(NO_TOPPING_LARGE_DELUXE_PRICE));

        // Large Deluxe Pizza MAX_TOPPINGS (7 toppings)
        // VALID
        Pizza p9 = PizzaMaker.createPizza("Deluxe");
        p9.setSize(Size.LARGE);
        p9.toppings.add(Topping.PINEAPPLE);
        p9.toppings.add(Topping.EXTRA_CHEESE);
        assertTrue(df.format(p9.price()).equals(MAX_TOPPING_LARGE_DELUXE_PRICE));

        // Large Deluxe Pizza with more that MAX_TOPPINGS (>7 toppings)
        // INVALID
        Pizza p10 = PizzaMaker.createPizza("Deluxe");
        p10.setSize(Size.LARGE);
        p10.toppings.add(Topping.PINEAPPLE);
        p10.toppings.add(Topping.EXTRA_CHEESE);
        p10.toppings.add(Topping.BEEF);
        assertTrue(df.format(p10.price()).equals(ERROR_PRICE));

    }


}
