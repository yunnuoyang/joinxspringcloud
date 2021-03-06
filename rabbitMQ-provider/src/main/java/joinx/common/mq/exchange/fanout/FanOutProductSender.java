package joinx.common.mq.exchange.fanout;

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
public class FanOutProductSender {

	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;
	
	//exchange 交换器名称
	@Value("${mq.config.exchange.fanout}")
	private String exchange;
	
	/*
	 * 发送消息的方法
	 */
	public void send(String msg){
		//向消息队列发送消息
		//参数一：交换器名称。
		//参数二：路由键
		//参数三：消息
		this.rabbitAmqpTemplate.convertAndSend(this.exchange,"product.log.topic.debug", "product.log.debug....."+msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange,"product.log.topic.info", "product.log.info....."+msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange,"product.log.topic.warn","product.log.warn....."+msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange,"product.log.topic.error", "product.log.error....."+msg);
	}
}
