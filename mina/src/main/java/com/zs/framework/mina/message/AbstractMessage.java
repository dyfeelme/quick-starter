package com.zs.framework.mina.message;

import java.io.Serializable;

public abstract class AbstractMessage implements Serializable{
	static final long serialVersionUID = 1L;
    
    private int sequence;

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

}
