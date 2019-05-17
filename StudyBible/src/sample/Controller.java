package sample;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Controller {
    private static final String USERNAME = "schalvj";
    private static final String PASSWORD = "Atticus#1";
    private static final String CONN_STRING = "jdbc:mysql://www.db4free.net:3306/study_bible?verifyServerCertificate=false&useSSL=false";

    HashMap<String, String> version1URL;

    public void initialize() throws IOException, SQLException{
        updateBible();
        version1URL = new HashMap<String, String>();
        version1URL.put("King James Version", "de4e12af7f28f599-02");
        version1URL.put("American Standard Version", "06125adad2d5898a-01");
        version1URL.put("World English Bible", "9879dbb7cfe39e4d-01");

        cmbVersion1.getItems().addAll(version1URL.keySet());
    }

    @FXML
    void updateBible() throws SQLException {

    }
    @FXML
    private ComboBox<String> cmbVersion1;

    @FXML
    private ListView<String> list_view_v1;

    @FXML
    private ComboBox<String> cmbBook;

    @FXML
    private ComboBox<String> cmbChapter;

    @FXML
    private ComboBox<String> cmbVerse;

    @FXML
    private ComboBox<String> cmbVersion2;

    @FXML
    private ListView<String> list_view_v2;

    @FXML
    private TextArea txtNotes;

    // Setup button to submit all data to db4free.net
    @FXML
    void btnSave(ActionEvent event) throws SQLException{
        Connection conn = null;
        conn = (Connection) DriverManager.getConnection(CONN_STRING, USERNAME,PASSWORD);
        System.out.println("Connected!");


        //Prepared SQL Statement using parameterized queries
        String sql = "INSERT INTO study_notes(version1, book, chapter, verse, version2, v1_text, v2_text, notes)" +
                "VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, cmbVersion1.toString());
        preparedStatement.setString(2, cmbBook.toString());
        preparedStatement.setString(3, cmbChapter.toString());
        preparedStatement.setString(4, cmbVerse.toString());
        preparedStatement.setString(5, cmbVersion2.toString());
        preparedStatement.setString(6, list_view_v1.toString());
        preparedStatement.setString(7, list_view_v2.toString());
        preparedStatement.setString(8, txtNotes.getText());

        preparedStatement.executeUpdate();
        System.out.println("Notes Submitted!");

    }

    @FXML
    private Label labVerse;

    @FXML
    private GridPane grid_parent;

    @FXML
    private Label labBook;

    @FXML
    private Label labBibleV1;

    @FXML
    private Label labNotes;

    @FXML
    private Label labChapter;
}
