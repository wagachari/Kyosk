package com.KyoskTest.Kyosk.service;

import com.KyoskTest.Kyosk.entity.Configuration;
import com.KyoskTest.Kyosk.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;

    public List<Configuration> getConfigs() {
        return (List<Configuration>) configurationRepository.findAll();
    }

    public Configuration createConfiguration(Configuration configuration) {
        return configurationRepository.save(configuration);
    }

    public List<Configuration> getConfigurationByMonitoringEnabled(String name) {
        return configurationRepository.findByMonitoringEnabled(name);
    }

    public List<Configuration> getConfigurationByCpuEnabled(String name) {
        return configurationRepository.findByCpuEnabled(name);
    }

    public List<Configuration> getConfigurationByCpuValue(String name) {
        return configurationRepository.findByCpuValue(name);
    }

    public Configuration getConfigurationByName(String name) {
        return configurationRepository.findByName(name);
    }

    public Configuration updateConfiguration(String name, Configuration config) {
        Configuration configuration = configurationRepository.findByName(name);

        Long idFromDb = configuration.getId();
        if (idFromDb != null) {
            config.setId(idFromDb);
        }
        return configurationRepository.save(config);
    }
}
