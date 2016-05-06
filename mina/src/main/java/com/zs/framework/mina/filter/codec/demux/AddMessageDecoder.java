package com.zs.framework.mina.filter.codec.demux;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;

public class AddMessageDecoder implements MessageDecoder{

	@Override
	public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageDecoderResult decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
