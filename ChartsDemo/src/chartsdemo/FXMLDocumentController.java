/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartsdemo;

import com.sun.javafx.charts.Legend;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author blair
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private PieChart myPieChart;

    @FXML
    private LineChart myLineChart;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");

        // populate pie chart
        // adapted from: https://docs.oracle.com/javafx/2/charts/pie-chart.htm
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30)
        );
        myPieChart.setData(pieChartData);

        // customise pie colours
        // adapted from: https://stackoverflow.com/questions/15219334/javafx-change-piechart-color
        // and from: https://stackoverflow.com/questions/44956955/javafx-use-chart-legend-to-toggle-show-hide-series-possible
        String[] pieColors = {"#edadaa", "#ffa500", "#8e4585", "#d1e231", "#ff0800"};
        int i = 0;
        for (PieChart.Data data : pieChartData) {
            data.getNode().setStyle(
                    "-fx-pie-color: " + pieColors[i % pieColors.length] + ";"
            );
            i++;
        }
        i = 0;
        for (Node n : myPieChart.getChildrenUnmodifiable()) {
            if (n instanceof Legend) {
                Legend l = (Legend) n;
                for (Legend.LegendItem li : l.getItems()) {
                    Node thisNode = li.getSymbol();
                    thisNode.setStyle(
                            "-fx-pie-color: " + pieColors[i % pieColors.length] + ";"
                    );
                    i++;
                }
            }
        }

        // populate line chart
        // adapted from: https://docs.oracle.com/javafx/2/charts/line-chart.htm
        myLineChart.setTitle("Stock Monitoring, 2010");

        CategoryAxis xAxis = (CategoryAxis) myLineChart.getXAxis();
        ObservableList<String> categories = FXCollections.observableArrayList(
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        );
        xAxis.setCategories(categories);

        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        series.getData().add(new XYChart.Data("Jan", 23));
        series.getData().add(new XYChart.Data("Feb", 14));
        series.getData().add(new XYChart.Data("Mar", 15));
        series.getData().add(new XYChart.Data("Apr", 24));
        series.getData().add(new XYChart.Data("May", 34));
        series.getData().add(new XYChart.Data("Jun", 36));
        series.getData().add(new XYChart.Data("Jul", 22));
        series.getData().add(new XYChart.Data("Aug", 45));
        series.getData().add(new XYChart.Data("Sep", 43));
        series.getData().add(new XYChart.Data("Oct", 17));
        series.getData().add(new XYChart.Data("Nov", 29));
        series.getData().add(new XYChart.Data("Dec", 25));
        myLineChart.getData().add(series);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
