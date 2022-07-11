package poly.service;

import poly.dto.MailDTO;

public interface IMailService {


	int doSendmail(MailDTO pDTO);


	int contactwrite(MailDTO pDTO);
}
