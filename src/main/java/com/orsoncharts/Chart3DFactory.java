/* ============
 * Orson Charts 
 * ============
 * 
 * (C)opyright 2013, by Object Refinery Limited.
 * 
 */

package com.orsoncharts;

import com.orsoncharts.axis.CategoryAxis3D;
import com.orsoncharts.axis.StandardCategoryAxis3D;
import com.orsoncharts.axis.NumberAxis3D;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.PieDataset3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.plot.PiePlot3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.BarXYZRenderer;
import com.orsoncharts.renderer.xyz.XYZRenderer;
import com.orsoncharts.renderer.category.AreaRenderer3D;
import com.orsoncharts.renderer.category.BarRenderer3D;
import com.orsoncharts.renderer.category.CategoryRenderer3D;
import com.orsoncharts.renderer.category.LineRenderer3D;
import com.orsoncharts.renderer.category.StackedBarRenderer3D;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;

/**
 * Utility methods for constructing common chart types.
 */
public class Chart3DFactory {
    
    /**
     * Private constructor prevents instantiation which is unnecessary.
     */
    private Chart3DFactory() {
        // no need to instantiate this ever
    }
    
    /**
     * Creates a pie chart in 3D.  This chart is constructed using a 
     * {@link PiePlot3D}.
     * 
     * @param title  the chart title (<code>null</code> permitted).
     * @param subtitle  the chart subtitle (<code>null</code> permitted).
     * @param dataset  the dataset (<code>null</code> not permitted).
     * 
     * @return A pie chart. 
     */
    public static Chart3D createPieChart(String title, String subtitle, 
            PieDataset3D dataset) {
        PiePlot3D plot = new PiePlot3D(dataset);
        return new Chart3D(title, subtitle, plot);
    }
    
    /**
     * Creates a bar chart in 3D.  This chart is constructed using a 
     * {@link CategoryPlot3D} with a {@link BarRenderer3D}.
     * 
     * @param title  the chart title (<code>null</code> permitted).
     * @param subtitle  the chart subtitle (<code>null</code> permitted).
     * @param dataset  the dataset (<code>null</code> not permitted).
     * @param rowAxisLabel  the row axis label (<code>null</code> permitted).
     * @param columnAxisLabel  the column axis label (<code>null</code> 
     *     permitted).
     * @param valueAxisLabel  the value axis label (<code>null</code> 
     *     permitted).
     * 
     * @return A bar chart. 
     */
    public static Chart3D createBarChart(String title, String subtitle,
            CategoryDataset3D dataset, String rowAxisLabel, 
            String columnAxisLabel, String valueAxisLabel) {
        CategoryAxis3D rowAxis = new StandardCategoryAxis3D(rowAxisLabel);
        CategoryAxis3D columnAxis = new StandardCategoryAxis3D(columnAxisLabel);
        ValueAxis3D valueAxis = new NumberAxis3D(valueAxisLabel, 
                new Range(0.0, 1.0));
        CategoryRenderer3D renderer = new BarRenderer3D();
        CategoryPlot3D plot = new CategoryPlot3D(dataset, renderer, 
                rowAxis, columnAxis, valueAxis);
        return new Chart3D(title, subtitle, plot);
    }
    
    /**
     * Creates a stacked bar chart in 3D.  This chart is constructed using a 
     * {@link CategoryPlot3D} with a {@link StackedBarRenderer3D}.
     * 
     * @param title  the chart title (<code>null</code> permitted).
     * @param subtitle  the chart subtitle (<code>null</code> permitted).
     * @param dataset  the dataset (<code>null</code> not permitted).
     * @param rowAxisLabel  the row axis label (<code>null</code> permitted).
     * @param columnAxisLabel  the column axis label (<code>null</code> 
     *     permitted).
     * @param valueAxisLabel  the value axis label (<code>null</code> 
     *     permitted).
     * 
     * @return A stacked bar chart. 
     */
    public static Chart3D createStackedBarChart(String title, String subtitle,
            CategoryDataset3D dataset, String rowAxisLabel, 
            String columnAxisLabel, String valueAxisLabel) {
        CategoryAxis3D rowAxis = new StandardCategoryAxis3D(rowAxisLabel);
        CategoryAxis3D columnAxis = new StandardCategoryAxis3D(columnAxisLabel);
        ValueAxis3D valueAxis = new NumberAxis3D(valueAxisLabel, 
                new Range(0.0, 1.0));
        CategoryRenderer3D renderer = new StackedBarRenderer3D();
        CategoryPlot3D plot = new CategoryPlot3D(dataset, renderer, rowAxis, 
                columnAxis, valueAxis);
        return new Chart3D(title, subtitle, plot);
    }
    
    /**
     * Creates an area chart in 3D. This chart is constructed using a 
     * {@link CategoryPlot3D} with an {@link AreaRenderer3D}.
     * 
     * @param title  the chart title (<code>null</code> permitted).
     * @param subtitle  the chart subtitle (<code>null</code> permitted).
     * @param dataset  the dataset (<code>null</code> not permitted).
     * @param rowAxisLabel  the row axis label (<code>null</code> permitted).
     * @param columnAxisLabel  the column axis label (<code>null</code> 
     *     permitted).
     * @param valueAxisLabel  the value axis label (<code>null</code> 
     *     permitted).
     * 
     * @return An area chart. 
     */
    public static Chart3D createAreaChart(String title, String subtitle,
            CategoryDataset3D dataset, String rowAxisLabel, 
            String columnAxisLabel, String valueAxisLabel) {
        
        CategoryAxis3D rowAxis = new StandardCategoryAxis3D(rowAxisLabel);
        StandardCategoryAxis3D columnAxis 
                = new StandardCategoryAxis3D(columnAxisLabel);
        columnAxis.setFirstCategoryHalfWidth(true);
        columnAxis.setLastCategoryHalfWidth(true);
        ValueAxis3D valueAxis = new NumberAxis3D(valueAxisLabel, 
                new Range(0.0, 1.0));
        CategoryRenderer3D renderer = new AreaRenderer3D();
        CategoryPlot3D plot = new CategoryPlot3D(dataset, renderer, rowAxis, 
                columnAxis, valueAxis);
        return new Chart3D(title, subtitle, plot);
    }
    
    /**
     * Creates a line chart in 3D for the supplied dataset.  This chart is
     * constructed using a {@link CategoryPlot3D} with a 
     * {@link LineRenderer3D}.
     * 
     * @param title  the chart title (<code>null</code> permitted).
     * @param subtitle  the chart subtitle (<code>null</code> permitted).
     * @param dataset  the dataset (<code>null</code> not permitted).
     * @param rowAxisLabel  the row axis label (<code>null</code> permitted).
     * @param columnAxisLabel  the column axis label (<code>null</code> 
     *     permitted).
     * @param valueAxisLabel  the value axis label (<code>null</code> 
     *     permitted).
     * 
     * @return A line chart. 
     */
    public static Chart3D createLineChart(String title, String subtitle,
            CategoryDataset3D dataset, String rowAxisLabel, 
            String columnAxisLabel, String valueAxisLabel) {
        CategoryAxis3D rowAxis = new StandardCategoryAxis3D(rowAxisLabel);
        StandardCategoryAxis3D columnAxis 
                = new StandardCategoryAxis3D(columnAxisLabel);
        columnAxis.setFirstCategoryHalfWidth(true);
        columnAxis.setLastCategoryHalfWidth(true);
        ValueAxis3D valueAxis = new NumberAxis3D(valueAxisLabel, 
                new Range(0.0, 1.0));
        CategoryRenderer3D renderer = new LineRenderer3D();
        CategoryPlot3D plot = new CategoryPlot3D(dataset, renderer, rowAxis, 
                columnAxis, valueAxis);
        return new Chart3D(title, subtitle, plot);
    }
    
    /**
     * Creates a scatter plot of <code>(x, y, z)</code> values.  This chart is
     * constructed using a {@link XYZPlot} with a {@link ScatterXYZRenderer}.
     * 
     * @param title  the chart title (<code>null</code> permitted).
     * @param subtitle  the chart subtitle (<code>null</code> permitted).
     * @param dataset  the dataset (<code>null</code> not permitted).
     * @param xAxisLabel  the x-axis label (<code>null</code> permitted).
     * @param yAxisLabel  the y-axis label (<code>null</code> permitted).
     * @param zAxisLabel  the z-axis label (<code>null</code> permitted).
     * 
     * @return The chart. 
     */
    public static Chart3D createScatterPlot(String title, String subtitle, 
            XYZDataset dataset, String xAxisLabel, String yAxisLabel, 
            String zAxisLabel) {
        ValueAxis3D xAxis = new NumberAxis3D(xAxisLabel);
        ValueAxis3D yAxis = new NumberAxis3D(yAxisLabel);
        ValueAxis3D zAxis = new NumberAxis3D(zAxisLabel);
        XYZRenderer renderer = new ScatterXYZRenderer();
        XYZPlot plot = new XYZPlot(dataset, renderer, xAxis, yAxis, zAxis);
        return new Chart3D(title, subtitle, plot);
    }
    
    /**
     * Creates a bar chart based on <code>(x, y, z)</code> values.  You should
     * only use this for special cases, it is usually easier to create 3D
     * bar charts using the {@link #createBarChart(String, String, CategoryDataset3D, String, String, String) }
     * method.
     * 
     * @param title  the chart title (<code>null</code> permitted).
     * @param subtitle  the chart subtitle (<code>null</code> permitted).
     * @param dataset  the dataset (<code>null</code> not permitted).
     * @param xAxisLabel  the x-axis label (<code>null</code> permitted).
     * @param yAxisLabel  the y-axis label (<code>null</code> permitted).
     * @param zAxisLabel  the z-axis label (<code>null</code> permitted).
     * 
     * @return The chart. 
     */
    public static Chart3D createXYZBarChart(String title, String subtitle, 
            XYZDataset dataset, String xAxisLabel, String yAxisLabel, 
            String zAxisLabel) {
        ValueAxis3D xAxis = new NumberAxis3D(xAxisLabel);
        ValueAxis3D yAxis = new NumberAxis3D(yAxisLabel);
        ValueAxis3D zAxis = new NumberAxis3D(zAxisLabel);
        XYZRenderer renderer = new BarXYZRenderer();
        XYZPlot plot = new XYZPlot(dataset, renderer, xAxis, yAxis, zAxis);
        return new Chart3D(title, subtitle, plot);
    }

}
