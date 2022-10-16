package com.reto3.reto3.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMessage;
    private String messageText;
    @ManyToOne
    @JoinColumn(name = "message_id_room")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Room room;
    @ManyToOne
    @JoinColumn(name = "message_id_client")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
}
