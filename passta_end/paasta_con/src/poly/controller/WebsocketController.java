package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

// ServerEndpoint라는 Annotation에서, 본 서버가 어떤 주소로 바인딩 되는지를 정의한다.
@Controller
@ServerEndpoint(value="/echo.do")
public class WebsocketController {
	
	private static final List<Session> sessionList = new ArrayList<Session>();;
	private static final Logger log = LoggerFactory.getLogger(WebsocketController.class);
	
	public WebsocketController() {
		log.info("웹소켓(서버) 객체 생성");
	}
	
	// 웹소켓 연결이 구성되면, Session(Session 인스턴스는 웹소켓이 닫히기 전까지 유효)이 생성되고 
	// @OnOpen 어노테이션이 붙은 endpoint가 호출된다. 
	@OnOpen
    public void onOpen(Session session){
        log.info("Open session id:" + session.getId());
        try {
            final Basic basic = session.getBasicRemote();
            basic.sendText("대화에 연결 되었습니다.");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        sessionList.add(session);
    }
	
	/*
     * 모든 사용자에게 메시지를 전달한다.
     * @param self
     * @param message
     */
	private void sendAllsessionToMessage(Session self, String sender, String message) {
		
		 try {
	            for (Session session : WebsocketController.sessionList) {
	                if (!self.getId().equals(session.getId())) {
	                    session.getBasicRemote().sendText(sender + " : " + message);
	                }
	            }
	        } catch (Exception e) {
	            log.info(e.getMessage());
	        }
	}

	/*
	 * 내가 입력하는 메세지
	 * @param message
	 * @param session
	 */
	@OnMessage
    public void onMessage(String message, Session session) {
		
        log.info("Message : " +message);
        String sender = message.split(",")[1];
		message = message.split(",")[0];
		log.info("message from : "+ sender + " : " + message);
		
        try {
            final Basic basic = session.getBasicRemote();
            basic.sendText("<나> : " + message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sendAllsessionToMessage(session, sender, message);
    }
	
	
	@OnError
	public void onError(Throwable e, Session session) {
	}
	// 웹소켓 연결이 닫힐 때, @OnClose 어노테이션이 붙은 매서드가 호출된다. 
	// 해당 매서드는 다음과 같은 파라미터를 포함할 수 있다.
	@OnClose
	public void onClose(Session session) {
		log.info("Session : " + session.getId() + " has ended");
		sessionList.remove(session);
	}
}
