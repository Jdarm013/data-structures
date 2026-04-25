module edu.dccc.artists {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.dccc.artists to javafx.fxml;
    exports edu.dccc.artists;
}