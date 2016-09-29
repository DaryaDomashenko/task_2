package stax;

/**
 * Created by Dasha on 29.09.2016.
 */
public enum MenuTagName {
    PHOTO, NAME, DESCRIPTION, PORTION, PRICE, FOOD, MENU;

    public static MenuTagName getElementTagName(String element) {
        switch (element) {
            case "food":
                return FOOD;
            case "photo":
                return PHOTO;
            case "description":
                return DESCRIPTION;
            case "portion":
                return PORTION;
            case "price":
                return PRICE;
            case "menu":
                return MENU;
            case "name":
                return NAME;
            default:
                throw new EnumConstantNotPresentException(MenuTagName.class, element);
        }
    }
}

