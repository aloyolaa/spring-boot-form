package com.aloyolaa.springbootform.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Country {

    private Integer id;
    private String code;
    private String name;

}
