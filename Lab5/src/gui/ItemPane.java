package gui;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

//You might need to do something to the following line
public class ItemPane extends GridPane {

    private ObservableList<ItemButton> itemButtonList = FXCollections.observableArrayList();

    public ItemPane() {
        // TODO implements the ItemPane's constructor
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);
        this.setHgap(10);
        String[] buttonNames = {"Corn", "Coffee", "Blueberry", "Strawberry", "Pineapple", "DestroyTool"};
        for (var buttonName : buttonNames) {
            ItemButton tmpButton = new ItemButton(buttonName);
            tmpButton.setOnAction(event -> {
                if (SimulationManager.getMoney() >= tmpButton.getItem().getPrice()) {
                    setSelectedButton(tmpButton);
                }
            });
            itemButtonList.add(tmpButton);
        }
        int pos = 0;
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.add(itemButtonList.get(pos++), j, i);
            }
        }
    }

    public void setSelectedButton(ItemButton selecteditemButton) {
        SimulationManager.setSelectedItemButton(selecteditemButton);
        resetButtonsBackGroundColor();
        selecteditemButton.highlight();
    }

    public void resetButtonsBackGroundColor() {
        for (ItemButton itemButton : itemButtonList) {
            itemButton.unhighlight();
        }
    }

}
