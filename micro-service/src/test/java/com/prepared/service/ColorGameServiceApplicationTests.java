package com.prepared.service;

import com.prepared.service.modules.rabbitmq.MsgProducer;
import com.prepared.service.modules.rabbitmq.MsgReceiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ColorGameServiceApplicationTests {

	@Autowired
	private MsgProducer msgProducer;

	@Autowired
	private MsgReceiver msgReceiver;

	@Test
	public void testRabbitMQ() {
		msgProducer.sendMsg("test rabbitMQ");
	}

	@Test
	public void testRabbitMQ2() {
		msgReceiver.process("test rabbitMQ");
	}

}
