package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.Scanner;

@Configuration//bu classta yapılandırma ayarları verilecek
@ComponentScan("com.tpe") //bu pathde yer alan tüm componentların tarar. com.tpe nin altındaki tum package ları classları tarar
//default path:AppConfiguration class ının icinde bulundugu path tanımlıdır
public class AppConfiguration {

    @Bean//thirdParty classtan bean oluşturulmasını sağlar
    public Random random(){
        return new Random();
    }

    @Bean//thirdParty classtan bean oluşturulmasını sağlar
    public Scanner scanner(){
        return new Scanner(System.in);
    }


}

//@Component class seviyesinde @Bean method seviyesinde bean olusturur