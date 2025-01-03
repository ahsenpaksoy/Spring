package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;

public class MailService implements MessageService{

   // private DbRepository repo = new DbRepository(); //mailservice in objesi dbrepository ye sıkı sıkı bagımlı olur

   // private Repository repo = new FileRepository();

    //MailService
    private Repository repo; //null

    //param const
    public MailService(Repository repo) {
        this.repo = repo;
    }

    //MailService mesajları gondermeyi saglar

    public void sendMessage(Message message){
        System.out.println("Mesajınız mail ile gönderiliyor...Mesaj: "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
       // DbRepository repo = new DbRepository();
        repo.save(message);
    }

}
