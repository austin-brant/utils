import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.bryant.austin.mail.App;
import com.bryant.austin.mail.service.MailService;

/**
 * 邮件服务单元测试
 *
 * @author austin bryant
 * @since 17/12/4 16:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class MailTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws MessagingException {
        mailService.sendSimpleMail("xxx@qq.com", "xxxx@qq.com", "测试", "测试");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("xxxx@qq.com", "xxx@qq.com", "test simple mail", content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath = "img/star.jpg";
        mailService.sendAttachmentsMail("xxx@qq.com", "xxxx@qq.com",
                "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "img/zhaoyun.jpeg";

        mailService.sendInlineResourceMail("xxx@qq.com", "xxx@qq.com",
                "主题：这是有图片的邮件", content, imgPath, rscId);
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("562099931@qq.com", "yangxiaochen@baidu.com",
                "主题：这是模板邮件", emailContent);
    }

}
