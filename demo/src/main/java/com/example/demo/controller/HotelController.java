package com.example.demo.controller;

import com.example.demo.entity.Hotel;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    HotelService hotelService;

    @RequestMapping(value = "/hotel/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Hotel hotel = (Hotel) this.hotelService.findById(id);

        if (hotel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotel/findHotelByName",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hotel> getHotelByName(@RequestParam(value = "name") String name) {
        if (name == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Hotel hotel = this.hotelService.findByName(name);

        if (hotel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        HttpHeaders headers = new HttpHeaders();
        if (hotel == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.hotelService.save(hotel);
        return new ResponseEntity<>(hotel, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/hotel/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hotel> deleteHotel(@PathVariable("id") Long id) {
        Hotel hotel = (Hotel) this.hotelService.findById(id);

        if (hotel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.hotelService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/hotels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = this.hotelService.findAll();

        if (hotels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
}
