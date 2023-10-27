package edu.school.calc;

import static java.lang.Double.parseDouble;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    ComputeCore computeCore;
    public Graph(ComputeCore computeCore_) { computeCore = computeCore_; }

    Boolean IsEqualDouble(double x, double y) { return Math.abs(x - y) <= 1e-7; }
    Boolean LessOrEqualDouble(double x, double y) { return IsEqualDouble(x, y) || (x <= y); }

    public List<List<Double>> getPoints(String exp, double start, double end, double step) {
        List<Double> x_values = new ArrayList<Double>();
        List<Double> y_values  = new ArrayList<Double>();

        for (double i = start; LessOrEqualDouble(i, end); i += step) {
            String resultString = computeCore.computeExpression(exp, Double.toString(i));
            Double resultNumber = parseDouble(resultString);
            
            if (Double.isNaN(resultNumber) || Double.isInfinite(resultNumber) ) y_values.add(null);
            else y_values.add(resultNumber);

            x_values.add(i);
        }

        List<List<Double>> resultArrs = new ArrayList<>();
        resultArrs.add(x_values);
        resultArrs.add(y_values);

        return resultArrs;
    }

}
