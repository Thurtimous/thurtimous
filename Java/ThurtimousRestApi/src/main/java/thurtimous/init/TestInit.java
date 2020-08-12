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

@Component
@Slf4j
public class TestInit {


    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public final void init() {
        log.info("vi kommer hit??");
        Instant before = Instant.now();
       // userRepository.findAll();
        User kjetil = new User("kjetil", "svergja");
        kjetil.getAssets().add(new Asset("hytte", kjetil));
        kjetil.getReceipts().add(new Receipt("https://upload.wikimedia.org/wikipedia/commons/0/0b/ReceiptSwiss.jpg", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fsimple.wikipedia.org%2Fwiki%2FReceipt&psig=AOvVaw048nkbqE--jRt35LeKt78-&ust=1597005777164000&source=images&cd=vfe&ved=0CAMQjB1qFwoTCOCDpKK8jOsCFQAAAAAdAAAAABAD", kjetil));
        userRepository.save(kjetil);
        User erling = new User("erling", "nikolai", "ukkelberg");
        erling.getReceipts().add(new Receipt("https://www.wordtemplatesonline.net/wp-content/uploads/Taxi-Receipt-02.jpg", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.wordtemplatesonline.net%2Ftaxi-receipt-templates%2F&psig=AOvVaw1YTjwWSX-Clk2DIysDN1FY&ust=1597005864319000&source=images&cd=vfe&ved=0CAMQjB1qFwoTCLi2zsy8jOsCFQAAAAAdAAAAABAD", erling));
        userRepository.save(erling);
  //      List<User> asd = userRepository.findAll();
      //  asd.forEach(System.out::println);
     //   asd.forEach(s -> System.out.println(s.getName()));
        log.info(getLogMessage(before));
    }




    private String getLogMessage(final Temporal before) {
        String seconds = Duration.between(before, Instant.now()).toSeconds() + " seconds";
        return getClass().getSimpleName() + " took " + seconds;
    }


}
