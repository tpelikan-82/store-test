package com.tpelikan.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


@Entity
public record Employee(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) int employeeId,
                       String firstName,
                       String lastNam,
                       String imageName,
                       String imageType,
                       @Lob byte[] imageDate)  {

}
