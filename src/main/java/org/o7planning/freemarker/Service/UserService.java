package org.o7planning.freemarker.Service;

import org.o7planning.freemarker.Dto.UserDto;
import org.o7planning.freemarker.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static Map<Long, UserEntity> users = new HashMap<>();

    private Long id = 1L;

    public void createUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity(userDto);
        userEntity.setId(id);
        users.put(id, userEntity);
        id++;
    }

    public Map<Long, UserEntity> getUsers() {
        return users;
    }


}
