package guestbook;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class SignGuestbookServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final Logger log = Logger.getLogger(SignGuestbookServlet.class.getName());

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {
    	
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {
    	
    	
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

        String content = req.getParameter("content");
        Date date = new Date();
        
        Greeting greeting = new Greeting(user, content, date);
      
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(greeting);
        } finally {
            pm.close();
        }
      
     //PersistenceManager pm = PMF.get().getPersistenceManager();
    	//Query query = pm.newQuery(Greeting.class);
    //	query.declareImports("import java.util.Date");
    //	query.setOrdering("date asc");
    //	List<Greeting> greetings = (List<Greeting>)query.execute();
        
       // List<Greeting> greats = null;
    //	String s = null;
	//	req.setAttribute(s,greetings);
        
	//	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/guestbook.jsp");
	//	try {
	//		dispatcher.forward(req, resp);
	//	} catch (ServletException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
        
        
        
        
        
        
      resp.sendRedirect("/guestbook.jsp");
    }
}
