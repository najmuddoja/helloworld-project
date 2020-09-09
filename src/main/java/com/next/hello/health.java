package com.next.hello;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class health
{
	@Autowired
	BuildProperties buildProperties;
	
	@RequestMapping(path ="health", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
     public @ResponseBody Map<String,String> showExecutiveSummar() throws UnknownHostException{
		
		 RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
    	 long startTime = rb.getStartTime();
         Date startDate = new Date(startTime);
         SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
         String formatDateTime2 = formatter.format(startDate); 
         InetAddress myHost = InetAddress.getLocalHost();
      
               
        Map<String,String> userDetails = new HashMap<String,String>();
        userDetails .put("status", "ok" );
        userDetails .put("version", buildProperties.getVersion());
        userDetails .put("up since", formatDateTime2);
       
    return userDetails;
    }
}

