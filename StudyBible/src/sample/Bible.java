package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Bible {
    private final SimpleStringProperty Version1;
    private final SimpleStringProperty Book;
    private final SimpleStringProperty Chapter;
    private final SimpleStringProperty Verse;
    private final SimpleStringProperty Version2;
    private final SimpleStringProperty V1_Text;
    private final SimpleStringProperty V2_Text;
    private final SimpleStringProperty Notes;

    //constructor
    public Bible(String version1, String book, String chapter, String verse, String version2,
                 String v1_text, String v2_text, String notes){
        Version1 = new SimpleStringProperty(version1);
        Book = new SimpleStringProperty(book);
        Chapter = new SimpleStringProperty(chapter);
        Verse = new SimpleStringProperty(verse);
        Version2 = new SimpleStringProperty(version2);
        V1_Text = new SimpleStringProperty(v1_text);
        V2_Text = new SimpleStringProperty(v2_text);
        Notes = new SimpleStringProperty(notes);

    }
    public StringProperty getVersion1() {
        return Version1;
    }
    public StringProperty getBook() {
        return Book;
    }
    public StringProperty getChapter(){
        return Chapter;
    }
    public StringProperty getVerse(){
        return Verse;
    }
    public StringProperty getVersion2(){
        return Version2;
    }
    public StringProperty getV1_Text(){
        return V1_Text;
    }
    public StringProperty getV2_Text(){
        return V2_Text;
    }
    public StringProperty getNotes(){
        return Notes;
    }
}
