package com.example.miniprojecttwo;

/**
 * Abstract class representing a literature, which has a title and can provide
 * information about itself.
 */
abstract class Literature implements InfoInterface {
    private final String title;

    public Literature(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Retrieves information about the literature.
     * This method is part of the {@link InfoInterface} interface.
     * It prints the title of the literature.
     */
    @Override
    public void getInfo() {
        System.out.println("Book Title: " + this.title);
    }
}
