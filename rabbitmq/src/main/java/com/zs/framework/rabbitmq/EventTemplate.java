package com.zs.framework.rabbitmq;

public interface EventTemplate {
	
	void send(String queueName,String exchangeName,Object eventContent) throws SendRefuseException;  
    
    void send(String queueName,String exchangeName,Object eventContent,CodecFactory codecFactory) throws SendRefuseException;

}
