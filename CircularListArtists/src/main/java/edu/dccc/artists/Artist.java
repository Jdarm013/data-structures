package edu.dccc.artists;

public class Artist {
    private String name;
    private String formed;
    private String iconicAlbum;
    private String numberOneHits;
    private String imgSrc;

    public Artist(String name, String formed, String iconicAlbum, String numberOneHits, String imgSrc) {
        this.name = name;
        this.formed = formed;
        this.iconicAlbum = iconicAlbum;
        this.numberOneHits = numberOneHits;
        this.imgSrc = imgSrc;
    }

    public String getName() { return name; }
    public String getFormed() { return formed; }
    public String getIconicAlbum() { return iconicAlbum; }
    public String getNumberOneHits() { return numberOneHits; }
    public String getImgSrc() { return imgSrc; }

    @Override
    public String toString() {
        // This splits the comma-separated hits into a bulleted list with dashes
        String formattedHits = "- " + numberOneHits.replace(", ", "\n- ");

        // Swapped the hyphen for a newline character after the formed year
        return name + " (Formed " + formed + ")\nMost Iconic Album: " + iconicAlbum +
                "\n#1 Hits Include:\n" + formattedHits;
    }
}