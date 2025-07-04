package com.vho.activ.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COMMITTEES")
public class Committee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commId;

    private String name;
    private String description;



    @OneToOne
    @JoinColumn(name = "headId")
    private Volunteer head;

    @OneToOne
    @JoinColumn(name = "viceId")
    private Volunteer vice;
}
