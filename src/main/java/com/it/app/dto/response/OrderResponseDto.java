package com.it.app.dto.response;

public class OrderResponseDto {

    private Long id;

    private Integer volume;

    private String description;

    private MedicamentResponseDto medicament;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MedicamentResponseDto getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentResponseDto medicament) {
        this.medicament = medicament;
    }
}
