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
        Map<Long, UserEntity> realUsers = new HashMap<>();
        for (Map.Entry<Long, UserEntity> entry : users.entrySet()) {
            if (!entry.getValue().getDeleted()) realUsers.put(entry.getKey(), entry.getValue());
        };
        return realUsers;
    }

    public void deleteUser(Long id) {
        for (Map.Entry<Long, UserEntity> entry : users.entrySet()) {
            if ((id!=null)&&(id.equals(entry.getValue().getId()))) {entry.getValue().setDeleted(true);}
        }
    }

    public void modifyUser(Long userId, UserDto userDto) {
        if ((userId!=null)&&(userId<=id)) {
            users.get(userId).setFirstName(userDto.getFirstName());
            users.get(userId).setLastName(userDto.getLastName());
        }
    }

}
