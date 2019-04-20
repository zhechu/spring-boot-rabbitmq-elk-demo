package com.wise.demo.log;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.logback.AmqpAppender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.encoder.Encoder;

/**
 * 修复 json 解析 BUG
 * @author lingyuwang
 *
 */
public class AmqpLogbackAppender extends AmqpAppender {

    private Encoder<ILoggingEvent> encoder;

    /**
     * We remove the default message layout and replace with the JSON {@link Encoder}
     */
    @Override
    public Message postProcessMessageBeforeSend(Message message, Event event) {
        return new Message(this.encoder.encode(event.getEvent()), message.getMessageProperties());
    }

    @Override
    public void start() {
        super.start();
        encoder.setContext(getContext());

        if (!encoder.isStarted()) {
            encoder.start();
        }

    }

    @Override
    public void stop() {
        super.stop();
        encoder.stop();
    }

	public Encoder<ILoggingEvent> getEncoder() {
		return encoder;
	}

	public void setEncoder(Encoder<ILoggingEvent> encoder) {
		this.encoder = encoder;
	}

}
