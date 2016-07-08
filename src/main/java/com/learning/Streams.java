package com.learning;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;

public class Streams
{
    public static void main(String[] args)
    {
        Streams s = new Streams();
    }

    public Streams() {
        List<Shape> shapes = new ArrayList<>();

        // forEach
        shapes.forEach(s -> s.setColor(RED));

        shapes.stream()
                .filter(s -> s.getColor() == BLUE)
                .forEach(s -> s.setColor(RED));

        // Collect
        List<Shape> blue = shapes.stream()
                .filter(s -> s.getColor() == BLUE)
                .collect(Collectors.toList());

        // MapToInt
        int sum = shapes.stream()
                .filter(s -> s.getColor() == BLUE)
                .mapToInt(Shape::getWeight)
                .sum();

        // findFirst
        Optional<Shape> firstBlue = shapes.stream()
                .filter(s -> s.getColor() == BLUE)
                .findFirst();

        firstBlue.ifPresent(x ->  System.out.println(x.getColor()));


//        Map<Artist, Map<Integer, List<Track>>> byArtistAndRating =
//                tracks.stream()
//                      .collect(groupingBy(t -> t.artist, groupingBy(t -> t.rating)));

        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);  // a1

        // For loop :)
        IntStream.range(1, 4).forEach(System.out::println);
        

        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);  // 3
    }

}
