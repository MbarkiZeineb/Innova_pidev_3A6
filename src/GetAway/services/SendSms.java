/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetAway.services;


import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber; 
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;


/**
 *
 * @author TheBoss'07
 */

 
public class SendSms { 
   

    public void sendSms(String NumTel){

   String AUTH_TOKEN = "9b037ae992b48af2bdeef26fd06fb7c7";
    String ACCOUNT_SID = "AC13598b9ef19843484e05b1b5c80fcb84";


   Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber(NumTel),  
                "MG4e4c868d325676b1f95825ce57d03329", 
                "Votre avis à été bien ajouter. Merci ! ")      
            .create(); 
 
        System.out.println(message.getSid()); 
}
}