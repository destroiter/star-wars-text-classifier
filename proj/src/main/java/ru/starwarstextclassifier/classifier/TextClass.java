package ru.starwarstextclassifier.classifier;

public enum TextClass {
    BOARDGAMES("boardgames", "Настольные игры"),
    BOOKS("books", "Книги и комиксы"),
    CHARACTERS("characters", "Персонажи"),
    CREATURES("creatures", "Существа"),
    DATES("dates", "Даты"),
    DROIDS("droids", "Дроиды"),
    EVENTS("events", "События"),
    FILMS("films", "Фильмография"),
    ORGANIZATIONS("organizations", "Объединения и организации"),
    OTHER("other", "Вне вымышленной вселенной"),
    PLACES("places", "Места"),
    PLANETS("planets", "Планеты"),
    PLANTS("plants", "Растения"),
    RACE("race", "Расы"),
    SPACESHIPS("spaceships", "Звёздные корабли"),
    TERMS("terms", "Термины и понятия"),
    TRANSPORT("transport", "Наземная техника"),
    VIDEOGAMES("videogames", "Видеоигры"),
    WEAPONS("weapons", "Оружие");
    
    private String name;
    private String localName;
    
    TextClass(String name, String localName) {
        this.name = name;
        this.localName = localName;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getLocalName() {
        return this.localName;
    }
    
    public static TextClass getTextClassByName(String textClassName) {
        for (int i = 0; i < TextClass.values().length; ++i) {
            if (TextClass.values()[i].getName().equals(textClassName)) {
                return TextClass.values()[i];
            }
        }
        return null;
    }
}
