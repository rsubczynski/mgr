package com.ad.mgr;

import com.ad.mgr.data.cards.service.CardService;
import com.ad.mgr.data.employee.service.EmployeeService;
import com.ad.mgr.data.generator.service.EmployeeGeneratorService;
import com.ad.mgr.view.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

@SpringBootApplication
public class MgrApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CardService cardService;

    @Autowired
    private EmployeeGeneratorService employeeGeneratorService;

    @Value("${spring.application.name}")
    private String appName;

    public static void main(String[] args) {
        new SpringApplicationBuilder(MgrApplication.class)
                .web(WebApplicationType.NONE)
                .headless(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    @Override
    public void run(String... args) {
        //TODO: generator :D
        //employeeGeneratorService.generateEmployeeWithCardIdAs0(10);
        SwingUtilities.invokeLater(() -> Window.showFrame(appName, employeeService, cardService));
    }
}
