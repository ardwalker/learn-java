package com.learning;

import java.util.Optional;

/**
 * Created by andrew on 4/20/16.
 */
public class Optionals
{
    public static void main(String[] args)
    {
        Optionals optionals = new Optionals();
        optionals.options();
    }

    private void options()
    {
        Optional<String> optString;
        String regularString = new String("whatever");

        optString = Optional.of("whatever");

            // Optional.ofNullable(null);
            // Optional.empty();


        optionalIfPresent();

        System.out.println(optString.orElse("default"));
//        optString.orElseGet()


        // apply transformation, only if not null (bypass NullPointerException)
        // Optional.map() applies given function on a value inside Optional - but only if Optional is present.
        // Otherwise nothing happens and empty() is returned.
        // Transformation is type-safe
        optString.map(String::trim).
                filter(t -> t.length() > 1).
                ifPresent(System.out::println);

        Optional<Integer> len = optString.map(String::length);

        optionalOrElse();

    }

    private void optionalOrElse()
    {
        Optional<String> optString;
        String regularString = new String("whatever");
        optString = Optional.of("whatever");

        optString.filter(s -> !s.isEmpty()).
                map(s -> s.charAt(0)).
                orElseThrow(IllegalArgumentException::new);

        // Default values
        Optional<Integer> optValue = Optional.of(1);

        Integer value = optValue.orElse(0);
        int lenInt    = optString.map(String::length).orElse(-1);
    }


    private void optionalIfPresent()
    {
        Optional<String> optString;
        String regularString = "whatever";
        optString = Optional.of("whatever");


        // 1... traditionally
        if (regularString != null)
            System.out.println(regularString);

        // with optionals
        optString.ifPresent(System.out::println);
        optString.ifPresent(a -> System.out.println(a));


        // 2... traditionally
        if (regularString != null && regularString.contains("what"))
            System.out.println(regularString);

        // optional and filter
        optString.filter(x -> x.contains("what")).ifPresent(System.out::println);

    }
}

