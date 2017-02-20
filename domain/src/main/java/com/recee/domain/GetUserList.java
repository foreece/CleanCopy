package com.recee.domain;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/20/17
 * @Description
 */

public class GetUserList extends UseCase{
    private UserRepository userRepository;
    public GetUserList(UserRepository repository) {
        this.userRepository = repository;
    }
    public Observable<List<String>> users() {
        return Observable.create(new Observable.OnSubscribe<List<String>>() {
            @Override
            public void call(Subscriber<? super List<String>> subscriber) {
                List<String> userList = userRepository.getUsers();
                if (userList == null) {
                    subscriber.onError(new Throwable("error"));
                } else {
                    subscriber.onNext(userList);
                }
                subscriber.onCompleted();
            }
        });
    }
}
