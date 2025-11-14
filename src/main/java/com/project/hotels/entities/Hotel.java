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
//pour configurer la table SQL associée à l'entité Hotel
//@Index permet de créer des index en bdd sur les colonnes city et country pour optimiser les recherches
//sans index, les recherches sur ces colonnes seraient plus lentes, surtout avec un grand volume de données
//avec index, les performances des requêtes de recherche sont améliorées
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

    @Column(columnDefinition = "TEXT")
    private String description;
    
    //un hotel peut avoir plusieurs chambres, chaque chambre appartient à un seul hotel
    //la colonne hotel_id dans la table room fait référence à l'id de l'hotel, mappedBy indique que l'association est gérée par l'entité Room et évite une table de jointure supplémentaire
    //cascade ALL pour propager les opérations de persistance de l'hôtel aux chambres associées (ex: si un hôtel est supprimé, ses chambres le sont aussi)
    //orphanRemoval true pour supprimer automatiquement les chambres orphelines (chambres dissociées d'un hôtel)
    //initialisation de la liste pour éviter les NullPointerException lors de l'ajout de chambres
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "hotel_service", 
        joinColumns = @jakarta.persistence.JoinColumn(name = "hotel_id"), 
        inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "service_id"))
    private List<Service> services = new ArrayList<>();

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImageHotel> images = new ArrayList<>();
}
