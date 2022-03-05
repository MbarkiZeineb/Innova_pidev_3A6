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

   String AUTH_TOKEN = "";
    String ACCOUNT_SID = "";


   Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber(NumTel),  
                "MG4e4c868d325676b1f95825ce57d03329", 
                "Votre avis à été bien ajouter. Merci ! ")      
            .create(); 
 
        System.out.println(message.getSid()); 
}
}