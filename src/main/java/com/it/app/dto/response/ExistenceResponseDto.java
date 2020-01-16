package com.it.app.dto.response;

public class ExistenceResponseDto {

    private Long id;

    private MedicamentResponseDto medicament;

    private PharmacyResponseDto pharmacy;

    private Integer volume;

    private Double price;

    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicamentResponseDto getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentResponseDto medicament) {
        this.medicament = medicament;
    }

    public PharmacyResponseDto getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(PharmacyResponseDto pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
