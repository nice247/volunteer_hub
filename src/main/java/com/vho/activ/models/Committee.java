package com.vho.activ.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Committee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "president")
    Volunteer president;

    @ManyToOne
    @JoinColumn(name = "vice_president")
    Volunteer vice_president;

    @OneToMany(mappedBy = "committee", cascade = CascadeType.ALL)
    private List<Volunteer> volunteers;

    @OneToMany(mappedBy = "committee", cascade = CascadeType.ALL)
    private List<Event> events;

    @OneToMany(mappedBy = "committee", cascade = CascadeType.ALL)
    private List<Meeting> meetings;

}
