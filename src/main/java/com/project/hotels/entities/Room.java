package com.project.hotels.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room", uniqueConstraints = @UniqueConstraint(name = "uk_room_hotel_roomnumber", columnNames = {"hotel_id", "room_number"}),
        indexes = {
            @Index(name = "idx_room_hotel_type", columnList = "hotel_id, room_type"),
            @Index(name = "idx_room_hotel_status", columnList = "hotel_id, room_status")
        })
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY) //je peux charger l'association hotel à la demande avec getHotel()
    @JoinColumn(name = "hotel_id", nullable = false, foreignKey = @ForeignKey(name = "fk_room_hotel"))
    private Hotel hotel;

    @NotBlank @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Enumerated(EnumType.STRING) @Column(name = "room_type", nullable = false)
    private RoomType roomType;

    @DecimalMin(value = "0.01") @Column(name = "surface_m2", precision = 6, scale = 2) //Vmax = 9999.99
    private BigDecimal surfaceM2;

    @Min(1) @Column(nullable = false)
    private Integer capacity;

    @Enumerated(EnumType.STRING) @Column(name = "room_status", nullable = false)
    private RoomStatus roomStatus = RoomStatus.AVAILABLE;

    @Min(0) @Column(name = "base_price", nullable = false)
    private Integer basePrice;

    @Size(min = 3, max = 3) @Column(length = 3, nullable = false)
    private String currency = "EUR";

    public enum RoomStatus {
        AVAILABLE, MAINTENANCE, OCCUPIED, RESERVED
    }

    public enum RoomType {
        VIP, STANDARD, DORM_BED
    }


}
