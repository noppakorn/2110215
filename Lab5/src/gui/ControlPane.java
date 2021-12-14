package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

//You might need to do something to the following line
public class ControlPane extends VBox {

    private ItemPane itemPane;
    private Button harvestButton;
    private Label moneyLabel;

    public ControlPane() {
        // TODO complete the ControlPane's constructor
        this.setAlignment(Pos.CENTER);
        this.setPrefWidth(300);
        this.setSpacing(15);
        this.setFillWidth(true);

        this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Label selectionLabel = new Label("Please select a seed or removal too");
        selectionLabel.setFont(new Font(14));
        moneyLabel = new Label();
        setMoneyLabelText();
        moneyLabel.setFont(new Font(20));
        itemPane = new ItemPane();
        harvestButton = new Button("Harvest");
        harvestButton.setPrefWidth(150);
        harvestButton.setOnAction(event -> SimulationManager.harvestHandler());
        this.getChildren().add(moneyLabel);
        this.getChildren().add(selectionLabel);
        this.getChildren().add(itemPane);
        this.getChildren().add(harvestButton);
    }

    public void setMoneyLabelText() {
        moneyLabel.textProperty().setValue("Money: " + SimulationManager.getMoney());
    }


    public ItemPane getItemPane() {
        return itemPane;
    }

    public Button getHarvestButton() {
        return harvestButton;
    }

    public Label getMoneyLabel() {
        return moneyLabel;
    }
}
