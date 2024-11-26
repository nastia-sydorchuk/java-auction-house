public class Book extends Collectible {
    //instance variables
    private String title;
    private String edition;
    private String genre;
    private String authorsName;

    //constructor
    public Book(String title, String edition, String genre, String authorsName, EstimatedYear yearOfOrigin, String owner, ConditionType condition, float startingPrice, int id) {
        super(yearOfOrigin, owner, condition, startingPrice, id);
        this.title = title;
        this.edition = edition;
        this.genre = genre;
        this.authorsName = authorsName;
    }

    //Return title
    public String getTitle() {
        return title;
    }

    //Return edition
    public String getEdition() {
        return edition;
    }

    //Return genre
    public String getGenre() {
        return genre;
    }

    //Return authorsName
    public String getAuthorsName() {
        return authorsName;
    }

    //Return the String representation of the book
    @Override
    public String toString(){ return "Book " + super.toString() + ": " + title; }

    //Return the detailed description of the book
    @Override
    public String getDetails() {
        return String.format(
                "%s%nTitle: %s%nEdition: %s%nGenre: %s%nAuthor's name: %s",
                super.getDetails(),
                title,
                edition,
                genre,
                authorsName
        );
    }

    //Return book specific CSV properties
    @Override
    public String toCSVAttributes() {
        return String.format(
                "%s,%s,%s,%s,%s,%s",
                "book",
                title,
                edition,
                genre,
                authorsName,
                super.toCSVAttributes()
        );
    }
}
