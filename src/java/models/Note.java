package models;

import java.io.*;


/**
 *
 * @author Keelin
 */
public class Note implements Serializable {
    private String noteTitle;
    private String noteContents;

    
    public Note(String filePath) {
        try {
            // Initalize the FileReader and BufferedReader using the not file path passed from NoteServlet
            FileReader noteFile = new FileReader(new File(filePath));
            BufferedReader noteReader = new BufferedReader(noteFile);
            
            // Read title and contents from the note.txt file
            noteTitle = noteReader.readLine();
            noteContents = noteReader.readLine();
    
            noteReader.close();
            
        } catch (FileNotFoundException noFile) {
            noFile.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
           
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {       
        this.noteTitle = noteTitle;
    }

    public String getNoteContents() {
        return noteContents;
    }

    public void setNoteContents(String noteContents) {
        this.noteContents = noteContents;
    }
    
    public void saveNote(String filePath) {
        try {
            // Initalize PrintWriter using the note file path passed from NoteServlet
            PrintWriter noteWriter = new PrintWriter(new File(filePath));
            
            // Write title and contents to note.txt
            noteWriter.println(this.noteTitle);        
            noteWriter.print(this.noteContents);
            
            // Save changes and close noteWriter
            noteWriter.close();
            
        } catch (FileNotFoundException noFile) {
            noFile.printStackTrace();
        }
    }
       
    
}
