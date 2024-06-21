public class Literature {
    private String title;

    public Literature(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void getInfo() {
        System.out.println("Book Title: " + this.title);
    }
}