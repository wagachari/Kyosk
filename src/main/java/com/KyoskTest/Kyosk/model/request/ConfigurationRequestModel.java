package com.KyoskTest.Kyosk.model.request;

import com.KyoskTest.Kyosk.model.shared.Metadata;
import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationRequestModel {
    private String name;
    private Metadata metadata;
}


