package minirestwebservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlSeeAlso;

import de.player.xml.Player;
import de.quiz.xml.GamescoreTyp;
import de.quiz.xml.Quizgame;
import de.quiz.xml.Quizgame.Quizfrage;
import de.quiz.xml.Quizgame.Quizfrage.Antwort;
import de.quiz.xml.Quizgame.Quizfrage.Bild;

@SuppressWarnings("unused")
@Path( "/quiz" )
public class mvqService {
	private static final String QUIZ_XML= "./././RessourceFiles/Quiz.xml";
	private static final String LINK="http://localhost:4434/bild/nr";
	
		//Funktioniert noch nicht oder ich stell mich wieder blöd an :\
		//DAten Ändern mittels Query Parameter in URI: http://localhost:4434/quiz/player/1?name=Bernd&wins=100&loss=200
		//Vielleicht wäre hier ein anderer Anwendungsfall sinnvoller, anstatt den Player zu ändern.
		@GET 
		@Consumes(MediaType.APPLICATION_XML)
		@Produces( "application/xml" )
		@Path("player/{id}")
		
		public void newPlayer(
				@PathParam("id") int id,
				@QueryParam("name") String name,
				@QueryParam("wins") int wins,
				@QueryParam("loss") int loss
				) throws JAXBException, IOException {
			
			
			xmlWriter creator = new xmlWriter();
			ArrayList<Quizgame.Quizfrage> fragen = new ArrayList<Quizgame.Quizfrage>();
			
			Quizgame quiz = new Quizgame();
			
			//Spieler benennen und Spielstand für aktuelles Spiel
			Player player = creator.createPlayer(name,wins,loss,id); // hier sind die Parameter


		
		}

		
		@POST 
		@Consumes(MediaType.APPLICATION_XML)
		@Produces( "application/xml" )
		@Path("player/{id}")		
		public void updatePlayer(
				@PathParam("id") int id
				) throws JAXBException, IOException {
			
			
			xmlWriter creator = new xmlWriter();
			ArrayList<Quizgame.Quizfrage> fragen = new ArrayList<Quizgame.Quizfrage>();
			
			Quizgame quiz = new Quizgame();
			
			//Spieler benennen und Spielstand für aktuelles Spiel
			Player player = creator.updatePlayer(id); // hier sind die Parameter
			

			
		
		
		}
		//loescht alle Spielerdaten zur angegebenen ID
		@DELETE
		@Consumes(MediaType.APPLICATION_XML)
		@Produces( "application/xml" )
		@Path("player/{id}")
		public void deletePlayer(
				@PathParam("id") int id
				) throws JAXBException, IOException {
			
			
			xmlWriter creator = new xmlWriter();
			ArrayList<Quizgame.Quizfrage> fragen = new ArrayList<Quizgame.Quizfrage>();
			
			Quizgame quiz = new Quizgame();
			
			//Spieler benennen und Spielstand für aktuelles Spiel
			Player player = creator.deletePlayer(id); // hier sind die Parameter
			
		}
		
		
		
		//Auch unvollstädig, bitte zum laufen kriegen
		@Path("/player")
		@GET @Produces( "application/xml" )
		public Player getPlayer() throws JAXBException, FileNotFoundException
		{
			de.quiz.xml.ObjectFactory obj = new de.quiz.xml.ObjectFactory();
			Quizgame quiz = new Quizgame();
			JAXBContext context = JAXBContext.newInstance(Quizgame.class,Player.class);
			Unmarshaller um = context.createUnmarshaller();
			try {
				quiz = (Quizgame) um.unmarshal(new FileReader(QUIZ_XML));
			}
			catch (FileNotFoundException e) {
				System.err.println("File not Found");
			}
			catch (Exception e) {
				System.out.println("Fehler");
				e.printStackTrace();
				System.out.println(context.toString());
				
			}
			return null;
		}

		
		@GET @Produces( "application/xml" )
		public Quizgame getAll() throws JAXBException, FileNotFoundException
		{
			de.quiz.xml.ObjectFactory obj = new de.quiz.xml.ObjectFactory();
			
			Quizgame quiz = new Quizgame();
			JAXBContext context = JAXBContext.newInstance(Quizgame.class);
			Unmarshaller um = context.createUnmarshaller();
			um.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
			
			try {
				quiz = (Quizgame) um.unmarshal(new FileReader(QUIZ_XML));
			}
			catch (FileNotFoundException e) {
				System.err.println("File not Found");
			}
			catch (Exception e) {
				System.out.println("Fehler");
				e.printStackTrace();
				System.out.println(context.toString());
				
			}
			
			return quiz;
		}
		
		@Path("/frage")
		@GET @Produces( "application/xml" )
		public Quizgame getFrage(@QueryParam("nr") int i) throws JAXBException, FileNotFoundException
		{
			de.quiz.xml.ObjectFactory obj = new de.quiz.xml.ObjectFactory();
			Quizgame quiz = new Quizgame();
			JAXBContext context = JAXBContext.newInstance(Quizgame.class);
			Unmarshaller um = context.createUnmarshaller();
			try {
				quiz = (Quizgame) um.unmarshal(new FileReader(QUIZ_XML));
			}
			catch (FileNotFoundException e) {
				System.err.println("File not Found");
			}
			catch (Exception e) {
				System.out.println("Fehler");
				e.printStackTrace();
				System.out.println(context.toString());
				
			}
			
			Quizgame frage = obj.createQuizgame();
			frage.getQuizfrage().add(quiz.getQuizfrage().get(i-1));
			return frage;
		}


}
