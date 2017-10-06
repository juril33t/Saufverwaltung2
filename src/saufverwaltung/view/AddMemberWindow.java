package saufverwaltung.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import saufverwaltung.control.Controller;
import saufverwaltung.control.Main;
import saufverwaltung.util.DbConnection;
import saufverwaltung.util.RefreshingTable;

/**
 * Dialog zum Hinzufügen eines Mitgliedes in die Db.
 * 
 * @author Juri Dispan
 *
 */
public class AddMemberWindow extends Stage {

	Controller ctl;

	public AddMemberWindow(DbConnection dbcon, RefreshingTable tab, Controller ctl) {
		this.ctl = ctl;
		GridPane mainBox = new GridPane();
		Scene sc = new Scene(mainBox, 350, 200);
		sc.getStylesheets().add((getClass().getResource("application.css").toString()));

		mainBox.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, null, null)));
		mainBox.setPadding(new Insets(25, 25, 25, 25));
		mainBox.setAlignment(Pos.CENTER);
		mainBox.setHgap(10);
		mainBox.setVgap(10);
		mainBox.setMaxWidth(100);
		Text title = new Text(Main.msg.getString("addmember"));
		title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		mainBox.add(title, 0, 0, 2, 1);

		HBox h1 = new HBox();

		Label nameLabel = new Label(Main.msg.getString("name") + ":");
		TextField nameFeld = new TextField("");
		Label startGLabel = new Label(Main.msg.getString("startbal") + ":");
		TextField startGFeld = new TextField("0");

		mainBox.add(nameLabel, 0, 1);
		mainBox.add(nameFeld, 1, 1);
		mainBox.add(startGLabel, 0, 2);
		mainBox.add(startGFeld, 1, 2);

		Button fertig = new Button(Main.msg.getString("ok"));
		fertig.setPrefSize(110, 20);
		fertig.setOnAction(e -> ctl.handleAddMember(this, startGFeld, nameFeld, tab));
		fertig.setDefaultButton(true);
		Button cancel = new Button(Main.msg.getString("cancel"));
		cancel.setPrefSize(110, 20);
		cancel.setOnAction(e -> close());

		fertig.getStyleClass().add("addButton");
		h1.setAlignment(Pos.BOTTOM_CENTER);
		h1.getChildren().addAll(fertig, cancel);
		h1.setSpacing(10);
		mainBox.add(h1, 0, 3);

		this.setTitle(Main.msg.getString("addmember"));
		this.setScene(sc);
		this.getIcons().add(new Image(getClass().getResourceAsStream("res/icon.png")));
		this.show();

	}

}
