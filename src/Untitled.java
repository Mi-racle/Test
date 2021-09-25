import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Untitled {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.cal(10, 10000);
    }
}

class Calculator {

    double[][] cost = {
            {1.0, 1},       //0->1
            {1.0, 2},       //1->2
            {1.0, 3},       //2->3
            {1.0, 4},       //3->4
            {0.8, 5},       //4->5
            {0.7, 6},       //5->6
            {0.6, 7},       //6->7
            {0.5, 8},       //7->8
            {0.4, 9},       //8->9
            {0.3, 10},      //9->10
            {0.3, 11},      //10->11
            {0.2, 12},      //11->12
    };

    public void cal(int level, int sample) {
        int sum_times = 0;
        double sum_cost = 0.1;
        int min_time = -1;
        int max_time = -1;
        for (int i = 0; i < sample; i++) {
            int cur_level = 0;
            int cur_times = 0;
            while (cur_level < level) {
                sum_times++;
                cur_times++;
                double ran = Math.random();
                if (ran <= cost[cur_level][0]) {
                    sum_cost += cost[cur_level++][1];
                }
                else {
                    if (cur_level < 7) {
                        sum_cost += cost[cur_level--][1];
                    }
                    else {
                        sum_cost += cost[cur_level][1];
                        cur_level -= 3;
                    }
                }
                if (cur_level >= level) {
                    if (min_time == -1) {
                        min_time = cur_times;
                    }
                    else {
                        min_time = (cur_times < min_time ? cur_times : min_time);
                    }
                    if (max_time == -1) {
                        max_time = cur_times;
                    }
                    else {
                        max_time = (cur_times > max_time ? cur_times : max_time);
                    }
                }
            }
        }
        double sum_cost_rmb = sum_cost * 7.5 / 50;
        System.out.println("cost per +" + level + ": " + sum_cost / sample + " ( " + sum_cost_rmb / sample + "rmb )");
        System.out.println("times per +" + level + ": " + sum_times / sample);
        System.out.println("cost per time " + sum_cost / sum_times);
        System.out.println("min time: " + min_time);
        System.out.println("max time: " + max_time);
    }
}