package com.it.app.dto.response;

import com.it.app.model.Doctor;

import java.util.List;

public class InstitutionResponseDto {

    private Long id;

    private String name;

    private String type;

    private String address;

/*    private List<DoctorResponseDto> doctors;

    public List<DoctorResponseDto> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorResponseDto> doctors) {
        this.doctors = doctors;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
