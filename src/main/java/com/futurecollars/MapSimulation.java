package com.futurecollars;

import org.apache.commons.lang3.RandomStringUtils;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

public class MapSimulation {
    public static final String Title = "Simulation";

    public void start() {
//        int[] sizes = new int[]{100000, 150000, 200000, 250000, 300000, 350000,
//                400000, 450000, 500000, 550000, 600000, 650000, 700000, 750000,
//                800000, 850000, 900000, 950000, 1000000, 3000000, 5000000};
        int[] sizes = new int[]{1000, 1500, 2000, 2500, 3000, 3500,
                4000, 4500, 5000, 5500, 6000, 6500, 7000, 7500,
                8000, 8500, 9000, 9500, 10000};
        List<Integer> times = new LinkedList<>();
        int numberOfGetters = 15000;
        Random rand = new Random();


        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            Map<Person, Person> people = new HashMap<>();
            List<Person> cache = new ArrayList<>(size);

            for (int j = 0; j < size; j++) {
                String generatedString = RandomStringUtils.random(20, true, true);
                Person person = new Person(generatedString);
                people.put(person, person);
                cache.add(person);
            }

            long start = System.nanoTime();

            for (int j = 0; j < numberOfGetters; j++) {
                int randomIndex = rand.nextInt((size));
                people.get(cache.get(randomIndex));
            }

            long elapsedTime = System.nanoTime() - start;
            times.add(Math.toIntExact(elapsedTime / 1000));

            System.out.println("Did the calculations for the size: " + size);
        }


        display(sizes, times);
    }


    private void display(int[] sizes, List<Integer> times) {
        XYSeries series = new XYSeries("Time");
        String[] labels = new String[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            series.add(i, times.get(i));
            String value = String.valueOf(sizes[i]);
            labels[i] = value;
        }

        XYDataset dataset = new XYSeriesCollection(series);

        NumberAxis domain = new SymbolAxis("Size", labels);
        NumberAxis range = new NumberAxis("Time");
        XYSplineRenderer r = new XYSplineRenderer(800);
        XYPlot xyplot = new XYPlot(dataset, domain, range, r);
        JFreeChart chart = new JFreeChart(xyplot);
        ChartPanel chartPanel = new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }
        };
        JFrame frame = new JFrame(Title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
