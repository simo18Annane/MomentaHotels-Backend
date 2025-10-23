package com.project.hotels.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotel", indexes = {
    @Index(name = "idx_hotel_city", columnList = "city"),
    @Index(name = "idx_hotel_country", columnList = "country")
})
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(nullable = false)
    private String name;

    @NotBlank @Column(nullable = false)
    private String address;

    @NotBlank @Column(nullable = false)
    private String city;

    @NotBlank @Column(nullable = false)
    private String country;

    @Min(0) @Max(5) @Column(nullable = false)
    private Integer stars;

    @Lob
    private String description;
    
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "hotel_service", 
        joinColumns = @jakarta.persistence.JoinColumn(name = "hotel_id"), 
        inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "service_id"))
    private List<Service> services = new ArrayList<>();
}
