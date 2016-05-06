package com.zs.framework.mina.filter.codec.demux;

import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;

import com.zs.framework.mina.message.AddMessage;
import com.zs.framework.mina.message.ResultMessage;

public class SumUpProtocolCodecFactory extends DemuxingProtocolCodecFactory {

	public SumUpProtocolCodecFactory(boolean server) {
		if (server) {
			super.addMessageDecoder(AddMessageDecoder.class);
			super.addMessageEncoder(ResultMessage.class, ResultMessageEncoder.class);
		} else // Client
		{
			super.addMessageEncoder(AddMessage.class, AddMessageEncoder.class);
			super.addMessageDecoder(ResultMessageDecoder.class);
		}
	}

}
