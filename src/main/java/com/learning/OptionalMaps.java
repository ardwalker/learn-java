package com.learning;

import java.util.Optional;

/**
 * Created by andrew on 4/21/16.
 */
public class OptionalMaps
{
    public static void main(String[] args)
    {
        OptionalMaps om = new OptionalMaps();
        om.maps();
    }

    private void maps()
    {
        //Optional<String> input = Optional.ofNullable(null);
        Optional<String> input = Optional.of("whatever");

        System.out.println("map    : " + input.map(OptionalMaps::getOutput));
        System.out.println("flatmap: " + input.flatMap(OptionalMaps::getOutputOpt));
    }

    static Optional<String> getOutputOpt(String input) {
        return input == null ? Optional.empty() : Optional.of("output for " + input);
    }

    static String getOutput(String input) {
        return input == null ? null : "output for " + input;
    }
}



