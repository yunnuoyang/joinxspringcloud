package joinx.common.mq.exchange.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 * @author Administrator
 *
 */
@Component
public class OrderSender {

	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;
	
	//exchange 交换器名称
	@Value("${mq.config.exchange.topic}")
	private String exchange;
	
	/*
	 * 发送消息的方法
	 */
	public void send(String msg){
		//向消息队列发送消息
		//参数一：交换器名称。
		//参数二：路由键
		//参数三：消息
		this.rabbitAmqpTemplate.convertAndSend(this.exchange,"order.log.topic.debug", "order.log.topic.debug....."+msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange,"order.log.topic.info", "order.log.topic.info....."+msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange,"order.log.topic.warn","order.log.topic.warn....."+msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange,"order.log.topic.error", "order.log.topic.error....."+msg);
	}
}
