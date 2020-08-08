package thurtimous.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import thurtimous.assets.Asset;
import thurtimous.user.User;
import thurtimous.user.UserRepository;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;

@Component
@Slf4j
public class Init {


    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public final void init() {
        log.info("vi kommer hit??");
        Instant before = Instant.now();
       // userRepository.findAll();
        User kjetil = new User("kjetil", "svergja");
        kjetil.getAssets().add(new Asset("hytte", kjetil));
        userRepository.save(kjetil);
        userRepository.save(new User("erling", "nikolai", "ukkelberg"));
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
