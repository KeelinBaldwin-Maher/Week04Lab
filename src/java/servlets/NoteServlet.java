package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Note;

/**
 *
 * @author Keelin
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check for edit parameter
        String edit = request.getParameter("edit");
        
        // Find note.txt file path then pass that into Note()
        String filePath = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        // Display edit page if the edit parameter is not null
        // If the edit parameter is null display the view page
        if (edit != null) {
            Note editNote = new Note(filePath);
            
            // Replace any html line breaks with regular line breaks
            String formattedContents = editNote.getNoteContents().replaceAll("<br>", "\r\n");
            editNote.setNoteContents(formattedContents);
            
            request.setAttribute("note", editNote);
            
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").
                    forward(request, response);
        } else {
            Note viewNote = new Note(filePath);
            
            request.setAttribute("note", viewNote);
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").
                forward(request, response);
        }
   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Find note.txt file path then pass that into Note()
        String filePath = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        // Retrieve the note title
        String noteTitle = request.getParameter("noteTitle");
        // Retrieve the notes contents, replace all line breaks to html line breaks
        String noteContents = request.getParameter("noteContents");
        noteContents = noteContents.replaceAll("\r\n", "<br>");
           
        // Open note
        Note editNote = new Note(filePath);
        
        // Change note.txt title
        editNote.setNoteTitle(noteTitle);
        // Change note.txt contents
        editNote.setNoteContents(noteContents);
        
        // Send editied note back to view note
        request.setAttribute("note", editNote);
        
        // Save changes
        editNote.saveNote(filePath);
        
        // Return to view note
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").
                forward(request, response);
        
    }

 
}
