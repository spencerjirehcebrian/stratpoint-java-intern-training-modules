public class Book extends Literature {
    private String author;
    private String ISBN;

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public Book(String title, String author, String ISBN) {
        super(title);
        this.author = author;
        this.ISBN = ISBN;
    }

    @Override
    public void getInfo(){
        System.out.println("Book Title: " + getTitle());
        System.out.println("Book Author: " + this.author);
        System.out.println("Book ISBN: " + this.ISBN);
        System.out.println("-------------------\n");
    }

}