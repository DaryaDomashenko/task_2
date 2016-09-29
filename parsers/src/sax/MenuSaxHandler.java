package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MenuSaxHandler extends DefaultHandler {
    private List<Food> foodList = new ArrayList<Food>();
    private Food food;
    private StringBuilder text;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void startDocument() throws SAXException {
        System.out.println("Parsing started.");
    }

    public void endDocument() throws SAXException {
        System.out.println("Parsing ended.");
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        if (qName.equals("food")) {
            food = new Food();
            food.setId((Integer.parseInt(attributes.getValue("id"))));
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        MenuTagName tagName = MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));

        switch (tagName) {
            case PHOTO:
                food.setPhoto(text.toString());
                break;
            case NAME:
                food.setName(text.toString());
                break;
            case DESCRIPTION:
                food.setDescription(text.toString());
                break;
            case PORTION:
                food.setPortion(text.toString());
                break;
            case PRICE:
                food.setPrice(Integer.parseInt((text.toString())));
                break;
            case FOOD:
                foodList.add(food);
                food = null;
                break;
            case MENU:
                break;
        }
    }

}
