package ru.ariona.sokrat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SokratService {

    @Autowired
    SokratRepo sokratRepo;

    private final char[] characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private final Random random = new Random();

    public Sokrat findByUserLink(String userLink) {
        return sokratRepo.findByUserLink(userLink);
    }

    public Sokrat findByShortLink(String shortLink) {
        return sokratRepo.findByShortLink(shortLink);
    }

    public Sokrat generate(String userLink) {
        Sokrat sokrat = sokratRepo.findByUserLink(userLink);
        if (sokrat == null) {
            sokrat = new Sokrat(userLink);
            sokrat.setShortLink(generateLink());
        }
        sokratRepo.save(sokrat);
        return sokrat;
    }

    private String generateLink() {
        char[] buf = new char[4];
        for (int i = 0; i < 4; i++) {
            buf[i] = characters[random.nextInt(characters.length - 1)];
        }
        if (sokratRepo.findByShortLink(String.valueOf(buf)) != null) {
            generateLink();
        }
        return String.valueOf(buf);
    }
}
