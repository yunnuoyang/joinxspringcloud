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
public class UserSender {

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
		this.rabbitAmqpTemplate.convertAndSend(this.exchange,"user.log.topic.debug", "user.log.debug....."+msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange,"user.log.topic.info", "user.log.info....."+msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange,"user.log.topic.warn","user.log.warn....."+msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange,"user.log.topic.error", "user.log.error....."+msg);
	}
}
