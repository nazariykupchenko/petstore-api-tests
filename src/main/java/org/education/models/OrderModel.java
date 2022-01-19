package org.education.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class OrderModel {
    private int Id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;
}
