package schedule;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import schedule.utils.Resources;

import java.io.IOException;

/**
 * @author hwd
 * @date 2021-01-07 4:46 PM
 **/
public class MainApp extends Application {

    private Stage stage;
    private BorderPane entryLayout;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.stage.setTitle("Powerful Schedule");
        this.initEntryLayout();
        this.initScheduleGrid();
        this.initButtonGrid();
        this.initScheduleList();
        this.initDescription();

        Scene scene = new Scene(entryLayout);
        this.stage.setScene(scene);
        this.stage.show();
    }

    private void initEntryLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Resources.getURL("views/Root.fxml"));
            this.entryLayout = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initScheduleGrid() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Resources.getURL("views/Schedule.fxml"));
            AnchorPane scheduleGrid = loader.load();
            this.entryLayout.setCenter(scheduleGrid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initButtonGrid() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Resources.getURL("views/ButtonList.fxml"));
            ToolBar scheduleGrid = loader.load();
            this.entryLayout.setBottom(scheduleGrid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initScheduleList() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Resources.getURL("views/ScheduleList.fxml"));
            AnchorPane scheduleGrid = loader.load();
            this.entryLayout.setLeft(scheduleGrid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initDescription() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Resources.getURL("views/Description.fxml"));
            AnchorPane scheduleGrid = loader.load();
            this.entryLayout.setRight(scheduleGrid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
