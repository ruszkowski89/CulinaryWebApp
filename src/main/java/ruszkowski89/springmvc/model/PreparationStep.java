package ruszkowski89.springmvc.model;

import javax.persistence.*;

@Embeddable
public class PreparationStep {

    @Lob
    @Column(name = "PREPARATION_STEP_DESCRIPTION")
    private String description;

    public PreparationStep() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
