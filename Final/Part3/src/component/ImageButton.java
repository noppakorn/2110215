package component;

import application.ImageButtonType;
import application.Main;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.TodoLogic;

public class ImageButton extends ImageView {
	private static final String addButtonUrl = "/res/plus-icon.png";
	private static final String removeButtonUrl = "/res/minus-icon.png";

	public ImageButton(ImageButtonType imageButtonType) {
		super();
		initImageButton(imageButtonType);
		initEventHandler(imageButtonType);
	}
	private void initImageButton(ImageButtonType imageButtonType) {
		//TODO
		this.setFitWidth(26);
		this.setFitHeight(26);
		switch (imageButtonType) {
			case ADD:
				this.setImage(new Image(addButtonUrl));
				break;
			case REMOVE:
				this.setImage(new Image(removeButtonUrl));
				break;
		}
	}
	private void initEventHandler(ImageButtonType imageButtonType) {
		//TODO
		this.setCursor(Cursor.HAND);
		this.setOnMouseClicked(event -> {
			switch (imageButtonType){
				case ADD:
					TodoLogic.addTodo(Main.getAdderBarCurrentText());
					break;
				case REMOVE:
					TodoLogic.removeTodo(this);
					break;
			}
		});
	}
}
