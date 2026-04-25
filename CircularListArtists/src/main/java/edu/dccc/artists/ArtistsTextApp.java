package edu.dccc.artists;

import java.util.ListIterator;
import java.util.Scanner;

public class ArtistsTextApp {
    private CircularLinkedList<Artist> artistList = new CircularLinkedList<>();
    private ListIterator<Artist> iterator;

    public void loadData() {
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
        iterator = artistList.iterator();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!choice.equals("q")) {
            // Added an empty line below the header
            System.out.println("\n--- Top 10 Best-Selling Bands ---\n");
            System.out.print("Next <n>, Previous <p>, Jump to Index <i>, Print All <a>, Quit <q>: ");
            choice = scanner.nextLine().toLowerCase();

            // Added an empty line before displaying the result
            System.out.println();

            switch (choice) {
                case "n":
                    if (iterator.hasNext()) System.out.println("Now Playing: " + iterator.next());
                    break;
                case "p":
                    if (iterator.hasPrevious()) System.out.println("Now Playing: " + ((CircularIterator<Artist>) iterator).previous());
                    break;
                case "i":
                    System.out.print("Enter index (can be negative or beyond size): ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine());
                        System.out.println("Band at index " + index + ":\n" + artistList.get(index));
                        resetIteratorToIndex(index);
                    } catch (Exception e) {
                        System.out.println("Invalid number.");
                    }
                    break;
                case "a":
                    for (int i = 0; i < artistList.size(); i++) {
                        System.out.println("[" + i + "] " + artistList.get(i).getName());
                    }
                    break;
            }
        }
        System.out.println("Exiting playlist...");
    }

    private void resetIteratorToIndex(int index) {
        int size = artistList.size();
        int normalizedIndex = (index % size + size) % size;
        iterator = artistList.iterator();
        for (int i = 0; i <= normalizedIndex; i++) {
            iterator.next();
        }
    }

    public static void main(String[] args) {
        ArtistsTextApp app = new ArtistsTextApp();
        app.loadData();
        app.run();
    }
}