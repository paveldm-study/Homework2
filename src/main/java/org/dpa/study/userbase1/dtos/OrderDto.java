package org.dpa.study.userbase1.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderDto {
    private int id;
    private int user_id;
    private String item;
}
