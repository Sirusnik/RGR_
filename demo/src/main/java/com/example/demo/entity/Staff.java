package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "position", nullable = true, length = 45)
    private String position;
    @Column(name = "tel", nullable = true, length = 45)
    private String tel;

    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "id")
    private Hotel hotelByIdHotel;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Hotel getHotelByIdHotel() {
        return hotelByIdHotel;
    }

    public void setHotelByIdHotel(Hotel hotelByIdHotel) {
        this.hotelByIdHotel = hotelByIdHotel;
    }
}
