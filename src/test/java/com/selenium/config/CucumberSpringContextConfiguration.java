package com.selenium.config;

import com.selenium.stepdefinitions.DriverConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@CucumberContextConfiguration
@ContextConfiguration(classes = {DriverConfig.class, StartApplication.class}, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {
}
