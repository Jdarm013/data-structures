package edu.dccc.artists;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ListIterator;

public class ArtistsFXApp extends Application {
    private final CircularLinkedList<Artist> artistList = new CircularLinkedList<>();
    private ListIterator<Artist> iterator;

    private final Label titleLabel = new Label("Legendary Bands Showcase");
    private final TextArea detailsArea = new TextArea();
    private final ImageView artistImageView = new ImageView();
    private final TextField indexInput = new TextField();

    @Override
    public void start(Stage stage) {
        loadData();
        iterator = artistList.iterator();

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));

        // Header
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 24));
        HBox topBar = new HBox(titleLabel);
        topBar.setAlignment(Pos.CENTER);
        topBar.setPadding(new Insets(0, 0, 15, 0));
        root.setTop(topBar);

        // Center Content (Image & Details)
        artistImageView.setFitWidth(300);
        artistImageView.setFitHeight(300);
        artistImageView.setPreserveRatio(true);

        detailsArea.setEditable(false);
        detailsArea.setWrapText(true);
        detailsArea.setPrefHeight(150);
        detailsArea.setStyle("-fx-font-size: 14px;");

        VBox centerContent = new VBox(15, artistImageView, detailsArea);
        centerContent.setAlignment(Pos.CENTER);
        root.setCenter(centerContent);

        // Bottom Controls
        Button btnPrev = new Button("<< Previous");
        Button btnNext = new Button("Next >>");
        Button btnGo = new Button("Go to Index");
        indexInput.setPrefWidth(50);
        indexInput.setPromptText("Idx");

        btnNext.setOnAction(e -> {
            if (iterator.hasNext()) updateUI(iterator.next());
        });

        btnPrev.setOnAction(e -> {
            if (iterator.hasPrevious()) {
                updateUI(((CircularIterator<Artist>) iterator).previous());
            }
        });

        btnGo.setOnAction(e -> {
            try {
                int idx = Integer.parseInt(indexInput.getText());
                updateUI(artistList.get(idx));
                resetIteratorToIndex(idx);
            } catch (NumberFormatException ex) {
                detailsArea.setText("Please enter a valid number.");
            }
        });

        HBox bottomControls = new HBox(15, btnPrev, new Label("Index:"), indexInput, btnGo, btnNext);
        bottomControls.setAlignment(Pos.CENTER);
        bottomControls.setPadding(new Insets(15, 0, 0, 0));
        root.setBottom(bottomControls);

        if (iterator.hasNext()) updateUI(iterator.next());

        Scene scene = new Scene(root, 550, 650);
        stage.setTitle("Circular Linked List - Top Bands");
        stage.setScene(scene);
        stage.show();
    }

    private void updateUI(Artist artist) {
        titleLabel.setText(artist.getName());
        detailsArea.setText(
                "Formed: " + artist.getFormed() + "\n\n" +
                        "Most Iconic Album: " + artist.getIconicAlbum() + "\n\n" +
                        "#1 Hits Include: \n- " + artist.getNumberOneHits().replace(", ", "\n- ")
        );

        try {
            Image img = new Image("file:" + artist.getImgSrc(), true);
            artistImageView.setImage(img);
        } catch (Exception e) {
            System.err.println("Could not load image: " + artist.getImgSrc());
        }


        try {
            Image img = new Image("file:" + artist.getImgSrc(), true);
            artistImageView.setImage(img);
        } catch (Exception e) {
            System.err.println("Could not load image: " + artist.getImgSrc());
        }
    }

    private void resetIteratorToIndex(int index) {
        int size = artistList.size();
        int normalizedIndex = (index % size + size) % size;
        iterator = artistList.iterator();
        for (int i = 0; i <= normalizedIndex; i++) {
            iterator.next();
        }
    }

    private void loadData() {
        artistList.add(new Artist("The Beatles", "1960", "Abbey Road", "Hey Jude, Let It Be, Come Together, Help!, Yesterday, Penny Lane", "images/beatles.jpg"));
        artistList.add(new Artist("Led Zeppelin", "1968", "Led Zeppelin IV", "Whole Lotta Love, Black Dog, Stairway to Heaven, Kashmir", "images/zeppelin.jpg"));
        artistList.add(new Artist("Pink Floyd", "1965", "The Dark Side of the Moon", "Another Brick in the Wall (Part 2), Money, Comfortably Numb", "images/pinkfloyd.jpg"));
        artistList.add(new Artist("Eagles", "1971", "Hotel California", "Hotel California, One of These Nights, Heartache Tonight", "images/eagles.jpg"));
        artistList.add(new Artist("Queen", "1970", "A Night at the Opera", "Bohemian Rhapsody, Another One Bites the Dust, Crazy Little Thing Called Love", "images/queen.jpg"));
        artistList.add(new Artist("AC/DC", "1973", "Back in Black", "Highway to Hell, Back in Black, You Shook Me All Night Long", "images/acdc.jpg"));
        artistList.add(new Artist("The Rolling Stones", "1962", "Sticky Fingers", "(I Can't Get No) Satisfaction, Paint It Black, Angie", "images/stones.jpg"));
        artistList.add(new Artist("U2", "1976", "The Joshua Tree", "With or Without You, I Still Haven't Found What I'm Looking For, Desire", "images/u2.jpg"));
        artistList.add(new Artist("Aerosmith", "1970", "Toys in the Attic", "I Don't Want to Miss a Thing, Dream On, Walk This Way", "images/aerosmith.jpg"));
        artistList.add(new Artist("Fleetwood Mac", "1967", "Rumours", "Dreams, Go Your Own Way, Don't Stop", "images/fleetwood.jpg"));
    }

    public static void main(String[] args) {
        launch();
    }
}