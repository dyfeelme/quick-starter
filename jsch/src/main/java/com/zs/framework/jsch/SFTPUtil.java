package com.zs.framework.jsch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpProgressMonitor;

public class SFTPUtil {
	
	Session session = null;
    ChannelSftp channel = null;
    
    private static final int TIMEOUT = 60000;
    private static final byte[] BUFFER = new byte[1024 * 256]; // 设定每次传输的数据块大小为256KB
    
    private static final byte[] buff = new byte[1024 * 2];
	private static final String PROP_SSH_PORT = "port";
	private static final String PROP_SSH_USER = "username";
	private static final String PROP_SSH_HOST = "host";
	private static final String PROP_SSH_PASSWORD = "password";

    
    public SFTPUtil openChannel(Properties config) throws Exception{
    	JSch jsch = new JSch();
    	int port = Integer.parseInt(config.getProperty(PROP_SSH_PORT, "21"));
    	String username = config.getProperty(PROP_SSH_USER);
    	String password = config.getProperty(PROP_SSH_PASSWORD);
    	String host = config.getProperty(PROP_SSH_HOST);
    	
    	if("".equals(username)){
    		throw new Exception("");
    	}
    	
    	if("".equals(host)){
    		throw new Exception("");
    	}
    	
		if(port != 0){
			session = jsch.getSession(username, host,port);
		}else{
			session = jsch.getSession(username, host);
		}
		
		session.setPassword(password);
		
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(TIMEOUT); // 设置timeout时间
        session.connect(); // 通过Session建立链接

        channel = (ChannelSftp) session.openChannel("sftp"); // 打开SFTP通道
        channel.connect(); // 建立SFTP通道的连接
        
    	return this;
    }
	
	public SFTPUtil openChannel(String host,String username,String password,int ...port) throws Exception{
		JSch jsch = new JSch();
		if(port.length > 0){
			session = jsch.getSession(username, host,port[0]);
		}else{
			session = jsch.getSession(username, host);
		}
		
		session.setPassword(password);
		
		Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(TIMEOUT); // 设置timeout时间
        session.connect(); // 通过Session建立链接

        channel = (ChannelSftp) session.openChannel("sftp"); // 打开SFTP通道
        channel.connect(); // 建立SFTP通道的连接
        
		return this;
	}
	
	public SFTPUtil upload(File file,String remoteDir) throws Exception{
		
		if(file.exists()){
			if(file.isDirectory()){
				
			}
			channel.put(src, dst);
		}
		return this;
	}
	
	public SFTPUtil fetch(String remoteDir,String targetDir) throws Exception{
		
		if(remoteDir.indexOf(".")>0){
			String path = remoteDir.substring(0, remoteDir.lastIndexOf(File.separatorChar));
			channel.cd(path);
		}
		
		channel.get(src, dst, new ProgressMonitor());
		
		return this;
	}
	
	public SFTPUtil logout() throws Exception{
		return this;
	}
	
	public void close() throws Exception{
		if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
	}
	
	public class ProgressMonitor implements SftpProgressMonitor {
		private long transfered;

	    @Override
	    public boolean count(long count) {
	        transfered = transfered + count;
	        System.out.println("Currently transferred total size: " + transfered + " bytes");
	        return true;
	    }

	    @Override
	    public void end() {
	        System.out.println("Transferring done.");
	    }

	    @Override
	    public void init(int op, String src, String dest, long max) {
	        System.out.println("Transferring begin.");
	    }
	}

}
