package sax;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

import static sax.Validation.validateXMLSchema;


public class SaxParser {
    public static void main(String[] args) throws SAXException, IOException{

        System.out.println("Соответствует ли схема XML-документу? "+ validateXMLSchema("menu.xsd", "menu.xml"));

        XMLReader reader = XMLReaderFactory.createXMLReader();//SAX parser
        MenuSaxHandler handler = new MenuSaxHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource("menu.xml"));
        List<Food> menu = handler.getFoodList();

        for(Food food : menu){
            System.out.println("====================");
            System.out.println(food.getId() + ")." + " " + food.getName() + " [" + food.getPhoto() + "]");
            System.out.println("Description:  " + food.getDescription());
            System.out.println("Portion:  " + food.getPortion() + " Price: " + food.getPrice());
        }
    }
}