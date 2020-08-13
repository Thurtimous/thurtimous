package thurtimous.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import thurtimous.entity.Asset;
import thurtimous.entity.Receipt;
import thurtimous.entity.User;
import thurtimous.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.Arrays;

@Component
@Slf4j
public class TestInit {


    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public final void init() {
        userRepository.save(getUser("erling", "hytte", "mansion", "mansion2", "superBåt"));
        userRepository.save(getUser("kjetil", "hytte", "hus", "dog"));
        userRepository.save(getUser("tim", "båt"));
        userRepository.save(getUser("jon"));
        userRepository.save(getUser("ben", "hest"));
        userRepository.save(getUser("dan", "hest"));
        userRepository.save(getUser("chong", "hest"));
        userRepository.save(getUser("tai", "hest"));
        userRepository.save(getUser("leo", "hest"));
        userRepository.save(getUser("eli", "hest"));
        userRepository.save(getUser("ian", "hest"));
        userRepository.save(getUser("kai", "hest"));
        userRepository.save(getUser("max", "hest"));
        userRepository.save(getUser("jax", "hest"));
        userRepository.save(getUser("Ali", "hest"));
        userRepository.save(getUser("Jay", "hest"));
        userRepository.save(getUser("Roy", "hest"));
        userRepository.save(getUser("joe", "hest"));




    }

    private User getUser(String name, String... assets) {
        User user = new User(name, name + "othan", name + "os");
        Arrays.asList(assets).forEach(asset -> user.getAssets().add(new Asset("hytte", user)));
        user.getReceipts().add(new Receipt("https://www.wordtemplatesonline.net/wp-content/uploads/Taxi-Receipt-02.jpg", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.wordtemplatesonline.net%2Ftaxi-receipt-templates%2F&psig=AOvVaw1YTjwWSX-Clk2DIysDN1FY&ust=1597005864319000&source=images&cd=vfe&ved=0CAMQjB1qFwoTCLi2zsy8jOsCFQAAAAAdAAAAABAD", user));
        return user;
    }


}
