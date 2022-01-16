package com.KyoskTest.Kyosk.entity;

import lombok.*;

import java.io.Serializable;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationDTO implements Serializable {
    private static final long serialVersionUID = -671426517322812L;
    public Long Id;
    public String name;
    public String monitoringEnabled;
    public String cpuEnabled;
    public String cpuValue;

}

