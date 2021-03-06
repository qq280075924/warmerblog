package warmer.star.blog.security.oauth2;

import org.springframework.stereotype.Component;
import warmer.star.blog.enums.UserSource;
import warmer.star.blog.mapper.UserMapper;
import warmer.star.blog.model.User;
import warmer.star.blog.util.SpringUtils;

@Component
public class GiteePrincipalExtractor extends AbstractPrincipalExtractor {

    @Override
    public User getUserByOpenId(String openId) {
        UserMapper userMapper = SpringUtils.getBean(UserMapper.class);
        return userMapper.getByOpenId(openId);
    }

    @Override
    public Integer getSourceTypeOauth2ClientName() {
        return UserSource.gitee.getValue();
    }


}
