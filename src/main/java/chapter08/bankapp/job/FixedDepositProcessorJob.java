package chapter08.bankapp.job;

import chapter08.bankapp.dao.FixedDepositDao;
import chapter08.bankapp.domain.FixedDepositDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import java.util.List;

public class FixedDepositProcessorJob {
    @Autowired
    private FixedDepositDao fixedDepositDao;

    @Autowired
    private transient JavaMailSender mailSender;

    @Autowired
    @Qualifier("requestProcessedTemplate")
    private transient SimpleMailMessage simpleMailMessage;

    private List<FixedDepositDetails> getInactiveFixedDeposits() {
        return fixedDepositDao.getInactiveFixedDeposits();
    }

    public void sendEmail() throws AddressException, MessagingException {
        List<FixedDepositDetails> inactiveFds = getInactiveFixedDeposits();
        for (FixedDepositDetails fd : inactiveFds) {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(fd.getEmail());
            mimeMessageHelper.setSubject(simpleMailMessage.getSubject());
            mimeMessageHelper.setText(simpleMailMessage.getText());
            mailSender.send(mimeMessage);
        }
        fixedDepositDao.setFixedDepositsAsActive(inactiveFds);
    }
}
