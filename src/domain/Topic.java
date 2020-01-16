package domain;

import java.time.LocalDate;

public class Topic {
    public static int seuraavaId;
    private final int id;

    private String title;
    private String description;
    private String additionalSource;
    private boolean complete;
    private LocalDate creationDate;
    private LocalDate completionDate;

    public Topic(String title) {
        this.title = title;
        this.id = seuraavaId++;
        this.creationDate = LocalDate.now();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdditionalSource(String additionalSource) {
        this.additionalSource = additionalSource;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAdditionalSource() {
        return additionalSource;
    }

    public boolean isComplete() {
        return complete;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    @Override
    public String toString() {
        return "Id " + id +
                ", Otsikko " + title + " kuvaus: " + description +
                ", mahdollinen lähde: " + additionalSource +
                ", onko aiheen opiskelu kesken: " + complete +
                ", milloin aihe on luotu: " + creationDate +
                ", milloin aihe on opiskeltu: " + completionDate;
    }
}
