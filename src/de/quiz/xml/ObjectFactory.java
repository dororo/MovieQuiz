//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.27 at 05:42:12 PM MESZ 
//


package de.quiz.xml;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.quiz.xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.quiz.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GamescoreTyp }
     * 
     */
    public GamescoreTyp createGamescoreTyp() {
        return new GamescoreTyp();
    }

    /**
     * Create an instance of {@link Quizgame }
     * 
     */
    public Quizgame createQuizgame() {
        return new Quizgame();
    }

    /**
     * Create an instance of {@link Quizgame.Quizfrage.Bild }
     * 
     */
    public Quizgame.Quizfrage.Bild createQuizgameQuizfrageBild() {
        return new Quizgame.Quizfrage.Bild();
    }

    /**
     * Create an instance of {@link Quizgame.Quizfrage }
     * 
     */
    public Quizgame.Quizfrage createQuizgameQuizfrage() {
        return new Quizgame.Quizfrage();
    }

    /**
     * Create an instance of {@link Quizgame.Quizfrage.Antwort }
     * 
     */
    public Quizgame.Quizfrage.Antwort createQuizgameQuizfrageAntwort() {
        return new Quizgame.Quizfrage.Antwort();
    }

}
