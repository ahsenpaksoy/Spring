package com.tpe.controller;

import com.tpe.domain.Message;
import com.tpe.repository.FileRepository;
import com.tpe.repository.Repository;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.WhatsappService;

public class MessageApplication {
    public static void main(String[] args) {

        Message message = new Message();
        message.setBody("Spring is COMING:");

        //bu class ta kullanıcının taleplerini alıyoruz

        //bu mesajı maille gonderelim
       // MailService mailService=new MailService();
       // mailService.sendMessage(message);

        //bu mesajı whatsapp ile gonderelim
       // WhatsappService whatsappService = new WhatsappService();
       // whatsappService.sendMessage(message);

        //ref interfaceden alalım
        Repository repository=new FileRepository();//bağımlılık enjeksiyonu_dependency injection
        MessageService service=new WhatsappService(repository);
        service.sendMessage(message);


        service=new MailService(repository);
        service.sendMessage(message);

        //gönderilen mesajı kaydedelim
        service.saveMessage(message);

        MessageService service2 = new WhatsappService(repository);
        service2.sendMessage(message);
        service2.saveMessage(message);

        //objeler arasındaki bagımlılıgı gevsetmek icin
        //  1-referance olarak interface
        //  2-bagımlılıgı dogrudan vermek yerine daha sonra parametreli const (veya setter methodu) ile verdik

        //problem:
        //1-objeleri biz olusturuyoruz
        //2-objelerin bagımlılıklarını biz manuel olarak enjekte etmek zorundayız

        //cozum:
        //spring is COMING:)

    }
}
