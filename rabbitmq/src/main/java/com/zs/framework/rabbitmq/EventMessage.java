package com.zs.framework.rabbitmq;

import java.io.Serializable;

public class EventMessage implements Serializable{
	
	private String queueName;  
    
    private String exchangeName;  
      
    private byte[] eventData;
    
    public EventMessage(){}
  
    public EventMessage(String queueName, String exchangeName, byte[] eventData) {  
        this.queueName = queueName;  
        this.exchangeName = exchangeName;  
        this.eventData = eventData;  
    }

	public String getQueueName() {
		return queueName;
	}


	public String getExchangeName() {
		return exchangeName;
	}


	public byte[] getEventData() {
		return eventData;
	}

}
