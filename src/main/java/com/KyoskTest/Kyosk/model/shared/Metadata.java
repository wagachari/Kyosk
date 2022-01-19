package com.KyoskTest.Kyosk.model.shared;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Metadata {
    private Monitoring monitoring;
    private Limits limits;
}
