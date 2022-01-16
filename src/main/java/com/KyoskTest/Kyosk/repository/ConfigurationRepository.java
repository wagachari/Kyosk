package com.KyoskTest.Kyosk.repository;

import com.KyoskTest.Kyosk.entity.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigurationRepository extends CrudRepository<Configuration, Long> {

    Configuration findByName(String name);
    List<Configuration> findByMonitoringEnabled(String key);
    List<Configuration>  findByCpuEnabled(String key);
    List<Configuration>  findByCpuValue(String key);
    Long deleteByName(String name);
    Configuration  saveOrUpdate(Configuration configuration);


}
