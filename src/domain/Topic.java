package domain;

import java.time.LocalDate;
import java.util.UUID;

public class Topic {
    private UUID id;
    private String title;
    private String description;
    private String additionalSource;
    private boolean complete;
    private LocalDate creationDate;
    private LocalDate completionDate;

    public Topic(String title) {
        this.title = title;
        this.id = UUID.randomUUID();
        this.creationDate = LocalDate.now();
    }

    public Topic(String title, UUID id, String description, String additionalSource, boolean complete, LocalDate creationDate, LocalDate completionDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.complete = complete;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public UUID getId() {
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
        return "Id: " + id +
                "\nOtsikko: " + this.title +
                "\nKuvaus: " + this.description +
                "\nMahdollinen lähde: " + this.additionalSource +
                "\nOnko aiheen opiskelu kesken: " + this.complete +
                "\nMilloin aihe on luotu: " + this.creationDate +
                "\nMilloin aihe on opiskeltu: " + this.completionDate +"\n\n";
    }
}
