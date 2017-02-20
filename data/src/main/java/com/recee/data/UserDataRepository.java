package com.recee.data;

import com.recee.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/20/17
 * @Description
 */

public class UserDataRepository implements UserRepository {

    @Override
    public List<String> getUsers() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> result = new ArrayList<String>();
        result.add("Tom");
        result.add("Bob");
        result.add("Kevin");
        result.add("Jack");
        result.add("Simon");
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return random.nextBoolean() ? null : result;
    }
}
